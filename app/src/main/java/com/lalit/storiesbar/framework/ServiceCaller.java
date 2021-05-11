package com.lalit.storiesbar.framework;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.lalit.storiesbar.Contants;

import java.util.HashMap;
import java.util.Map;


public class ServiceCaller {
    Context context;

    public ServiceCaller(Context context) {
        this.context = context;
    }

    public void calStroiesService(final IAsyncWorkCompletedCallback workCompletedCallback) {
        final String url = "https://m.queno.in/webapi/ApiGenerate/getStories_v2";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                workCompletedCallback.onDone(response, true);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
                workCompletedCallback.onDone(error.getMessage(), false);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("user_id", "101");
                return params;
            }
        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(20000, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        AppController.getInstance().addToRequestQueue(stringRequest);//, tag_json_obj);
    }


}
