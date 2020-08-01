package com.example.covid_19;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    @BindView(R.id.newCasesWorld)
    TextView newCasesWorld;
    @BindView(R.id.newDeathsWorld)
    TextView newDeathsWorld;
    @BindView(R.id.newRecoveredWorld)
    TextView newRecoveredWorld;
    @BindView(R.id.totalCasesWorld)
    TextView totalCasesWorld;
    @BindView(R.id.totalDeathsWorld)
    TextView totalDeathsWorld;
    @BindView(R.id.totalRecoveredWorld)
    TextView totalRecoveredWorld;
    @BindView(R.id.newCasesAfrica)
    TextView newCasesAfrica;
    @BindView(R.id.newDeathsAfrica)
    TextView newDeathsAfrica;
    @BindView(R.id.newRecoveredAfrica)
    TextView newRecoveredAfrica;
    @BindView(R.id.totalCasesAfrica)
    TextView totalCasesAfrica;
    @BindView(R.id.totalDeathsAfrica)
    TextView totalDeathsAfrica;
    @BindView(R.id.totalRecoveredAfrica)
    TextView totalRecoveredAfrica;
    @BindView(R.id.newCasesKenya)
    TextView newCasesKenya;
    @BindView(R.id.newDeathsKenya)
    TextView newDeathsKenya;
    @BindView(R.id.newRecoveredKenya)
    TextView newRecoveredKenya;
    @BindView(R.id.totalCasesKenya)
    TextView totalCasesKenya;
    @BindView(R.id.totalDeathsKenya)
    TextView totalDeathsKenya;
    @BindView(R.id.totalRecoveredKenya)
    TextView totalRecoveredKenya;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
//

        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        String url = "https://corona.lmao.ninja/v2/all";
        String urlAfrica = "https://disease.sh/v3/covid-19/continents/Africa?yesterday=false&strict=true&allowNull=true";
        String urlKenya = "https://disease.sh/v3/covid-19/countries/Kenya?yesterday=false&strict=true&allowNull=true";


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {
                    JSONObject jsonObject = new JSONObject(response);
                    newCasesWorld.setText(jsonObject.getString("todayCases"));
                    newDeathsWorld.setText(jsonObject.getString("todayDeaths"));
                    newRecoveredWorld.setText(jsonObject.getString("todayRecovered"));
                    totalCasesWorld.setText(jsonObject.getString("cases"));
                    totalDeathsWorld.setText(jsonObject.getString("deaths"));
                    totalRecoveredWorld.setText(jsonObject.getString("recovered"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                error -> {
                    Toast.makeText(getActivity().getApplicationContext(), "data not mentioned", Toast.LENGTH_LONG).show();

                });
        queue.add(stringRequest);
        StringRequest africaRequest = new StringRequest(Request.Method.GET, urlAfrica, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    newCasesAfrica.setText(jsonObject.getString("todayCases"));
                    newDeathsAfrica.setText(jsonObject.getString("todayDeaths"));
                    newRecoveredAfrica.setText(jsonObject.getString("todayRecovered"));
                    totalCasesAfrica.setText(jsonObject.getString("cases"));
                    totalDeathsAfrica.setText(jsonObject.getString("deaths"));
                    totalRecoveredAfrica.setText(jsonObject.getString("recovered"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                error -> {
                    Toast.makeText(getActivity().getApplicationContext(), "data not mentioned", Toast.LENGTH_LONG).show();

                });
        queue.add(africaRequest);

        StringRequest kenyaRequest = new StringRequest(Request.Method.GET, urlKenya, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    newCasesKenya.setText(jsonObject.getString("todayCases"));
                    newDeathsKenya.setText(jsonObject.getString("todayDeaths"));
                    newRecoveredKenya.setText(jsonObject.getString("todayRecovered"));
                    totalCasesKenya.setText(jsonObject.getString("cases"));
                    totalDeathsKenya.setText(jsonObject.getString("deaths"));
                    totalRecoveredKenya.setText(jsonObject.getString("recovered"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                error -> {
                    Toast.makeText(getActivity().getApplicationContext(), "data not mentioned", Toast.LENGTH_LONG).show();

                });
        queue.add(kenyaRequest);

        return view;
    }

}



