package com.example.covid_19;


import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.ReferenceQueue;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Home extends AppCompatActivity {


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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://corona.lmao.ninja/v2/all";
        String urlAfrica = "https://disease.sh/v3/covid-19/continents/Africa?yesterday=true&strict=true&allowNull=true";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    newCasesWorld.setText(  jsonObject.getString("todayCases"));
                    newDeathsWorld.setText( jsonObject.getString("todayDeaths"));
                    newRecoveredWorld.setText( jsonObject.getString("todayRecovered"));
                    totalCasesWorld.setText(jsonObject.getString("cases"));
                    totalDeathsWorld.setText(jsonObject.getString("deaths"));
                    totalRecoveredWorld.setText( jsonObject.getString("recovered"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                error -> {
                    Toast.makeText(getApplicationContext(),"data not mentioned",Toast.LENGTH_LONG).show();

            });
        queue.add(stringRequest);


        StringRequest africaRequest = new StringRequest(Request.Method.GET, urlAfrica, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    newCasesAfrica.setText(  jsonObject.getString("todayCases"));
                    newDeathsAfrica.setText( jsonObject.getString("todayDeaths"));
                    newRecoveredAfrica.setText( jsonObject.getString("todayRecovered"));
                    totalCasesAfrica.setText(jsonObject.getString("cases"));
                    totalDeathsAfrica.setText(jsonObject.getString("deaths"));
                    totalRecoveredAfrica.setText( jsonObject.getString("recovered"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                error -> {
                    Toast.makeText(getApplicationContext(),"data not mentioned",Toast.LENGTH_LONG).show();

                });
        queue.add(africaRequest);
    }
}

