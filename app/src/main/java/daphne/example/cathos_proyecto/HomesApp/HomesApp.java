package daphne.example.cathos_proyecto.HomesApp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import daphne.example.cathos_proyecto.R;
import daphne.example.cathos_proyecto.conexiones.Services;

public class HomesApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homes_app);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                callservice();
            }
        });

        loadComponents();
    }

    public void callservice(){
        //llamada a la clase Data
        Data.LISTINGS = new ArrayList<>();


        /*AsyncHttpClient client = new AsyncHttpClient();

        client.get("http://18.219.197.67/listhomes",  new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                        //super.onSuccess(statusCode, headers, response);
                        //JSONArray data = response.getJSONArray("data");

                    })*/




        AsyncHttpClient client = new AsyncHttpClient();
        client.get(Services.LISTINGS + "?", new JsonHttpResponseHandler(){

            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
               // AsyncHttpClient.log.w(LOG_TAG, "onSuccess(int, Header[], JSONObject) was not overriden, but callback was received");
            }
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                //AsyncHttpClient.log.w(LOG_TAG, "onSuccess(int, Header[], JSONArray) was not overriden, but callback was received");
                for (int i=0 ;i<response.length(); i++){
                    try {
                        JSONObject obj = response.getJSONObject(i);
                        DataStruct ins = new DataStruct();
                        ins.setId(obj.getString("_id"));
                        ins.setDescription(obj.getString("descriptions"));
                        ins.setDirections(obj.getString("directions"));
                        ins.setDisclainer(obj.getString("disclainer"));
                        ins.setLat(obj.getDouble("lat"));
                        ins.setLog(obj.getDouble("log"));
                        ins.setPrimary_photo(obj.getString("primary_photo"));
                        Data.LISTINGS.add(ins);
                    }catch (JSONException err){
                        Log.d("ERROR", err.getMessage());
                    }

                }


                Intent results = new Intent(HomesApp.this,Results.class);
                startActivity(results);

            }

        });


    }


    private void loadComponents() {

        //homessApp
        Spinner min = findViewById(R.id.minspinner);
        Spinner max = findViewById(R.id.maxspinner);

        ArrayList<String> minlist = new ArrayList<>();

        minlist.add("50000");
        minlist.add("100000");
        minlist.add("150000");
        minlist.add("200000");
        minlist.add("250000");
        minlist.add("300000");
        minlist.add("350000");
        minlist.add("400000");
        minlist.add("450000");
        minlist.add("500000");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, minlist);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, minlist);

        min.setAdapter(adapter);
        max.setAdapter(adapter1);


    }

}
