package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity2 extends AppCompatActivity {
    RequestQueue requestQueue;
    public static final String url = "https://my-json-server.typicode.com/typicode/demo/posts";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        requestQueue = Volley.newRequestQueue(this);
        JsonRequest ();
    }
    private void Stringrecuest ()
    {
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                TextView txtSaludo = (TextView)findViewById(R.id.txtMostrar);
                txtSaludo.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(request);
    }
private void JsonRequest ()
{
JsonArrayRequest  jsonarrayrquest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
    @Override
    public void onResponse(JSONArray response) {
int size = response.length();
for (int i =0; i<= size;i++)
{
    try {
        JSONObject jsonObject = new JSONObject(response.get(i).toString());
        String title = jsonObject.getString("title");
        TextView txtSaludo = (TextView)findViewById(R.id.txtMostrar);
        txtSaludo.append("title:" + title+"\n");
    } catch (JSONException e) {
        e.printStackTrace();
    }
}
    }
}, new Response.ErrorListener() {
    @Override
    public void onErrorResponse(VolleyError error) {

    }
}
);
requestQueue.add(jsonarrayrquest);
}

}