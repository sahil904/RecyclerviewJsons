package com.example.omsairam.recyclerviewjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
List<Model>list;
String url="http://spffacilities.com/Admin_pannel/json/banner.php";
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        list=new ArrayList<> ();
         recyclerView = (RecyclerView) findViewById(R.id.recycler);

//        list.add (new Model (R.drawable.ic_launcher_background,"GHJG"));

        StringRequest stringRequest=new StringRequest (Request.Method.POST, url, new Response.Listener<String> () {
            @Override
            public void onResponse(String response) {
                Log.d ("finf",response);
                try {
                    Log.d ("responce",response);
                    JSONObject jsonObject=new JSONObject (response);
                    JSONArray jsonArray=jsonObject.getJSONArray ("banner");
                    for(int i = 0; i<jsonArray.length(); i++) {

                        JSONObject jsonObject1 = jsonArray.getJSONObject (i);
                        Model model = new Model ();


                        model.image = jsonObject1.getString ("image");
                        model.text = jsonObject1.getString ("id");
                        Log.d ("findimae", model.image);
                        list.add (model);
                    }
                        recyclerView.setLayoutManager (new LinearLayoutManager (getApplicationContext ()));

                        CustomAdapter customAdapter = new CustomAdapter (MainActivity.this, list);
                        recyclerView.setAdapter (customAdapter);
                }

                catch ( JSONException e ) {
                    e.printStackTrace ();
                }


            }
        }, new Response.ErrorListener () {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText (MainActivity.this, "error", Toast.LENGTH_SHORT).show ();
            }
        }){

//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String,String> map=new HashMap<> ();
//
//                return map;
//            }
        };
        RequestQueue requestQueue=Volley.newRequestQueue (this);
        requestQueue.add (stringRequest);

    }
}
