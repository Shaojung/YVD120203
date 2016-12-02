package com.example.user.yvd120203;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = Volley.newRequestQueue(MainActivity.this);
    }
    public void click1(View v)
    {
        StringRequest request = new StringRequest("http://rate.bot.com.tw/xrt?Lang=zh-TW", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int loc = response.indexOf("USD");
                Log.d("LOC", String.valueOf(loc));
                String s2 = response.substring(loc+364, loc+370);
                Log.d("LOC", s2);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
        queue.start();
    }
}
