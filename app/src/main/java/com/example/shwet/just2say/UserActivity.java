package com.example.shwet.just2say;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static android.R.interpolator.linear;
import static com.example.shwet.just2say.R.id.phone;

/**
 * Created by Shwet on 2/16/2017.
 */

public class UserActivity extends AppCompatActivity {

    private Button profile_btn, contact_btn, aboutus_btn, notification_btn;

    private ProgressDialog loading;

    private static final String TAG = "UserActivity";

    private TextView greetingTextView;
    private Button btnLogOut;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Bundle bundle = getIntent().getExtras();
        String user = bundle.getString("username");
        greetingTextView = (TextView) findViewById(R.id.greeting_text_view);
        btnLogOut = (Button) findViewById(R.id.signout_btn);
        profile_btn = (Button)findViewById(R.id.profile_btn);
        contact_btn = (Button)findViewById(R.id.contact_btn);
        aboutus_btn = (Button)findViewById(R.id.aboutus_btn);
        notification_btn = (Button)findViewById(R.id.notification_btn);
        greetingTextView.setText("Hello " + user);

        //editTextId = (EditText) findViewById(R.id.editTextId);
        //buttonGet = (Button) findViewById(R.id.buttonGet);
        //textViewResult = (TextView) findViewById(R.id.textViewResult);

        // Progress dialog
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });


        //buttonGet.setOnClickListener(this);
        profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(i);
            }
        });

        contact_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ContactActivity.class);
                startActivity(i);
            }
        });

        aboutus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AboutUsActivity.class);
                startActivity(i);
            }
        });

        notification_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), NotificationActivity.class);
                startActivity(i);
            }
        });
    }


    /*
    private void getData() {
        String id = editTextId.getText().toString().trim();
        if (id.equals("")) {
            Toast.makeText(this, "Please enter a Phone Number", Toast.LENGTH_LONG).show();
            return;
        }
        loading = ProgressDialog.show(this, "Please wait...", "Fetching...", false, false);

        String url = Config.DATA_URL + editTextId.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                loading.dismiss();
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(UserActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }     */

    private void showJSON(String response) {
        String name = "";
        String email = "";
        String phoneNo = "";
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(Config.JSON_ARRAY);
            JSONObject userData = result.getJSONObject(0);
            name = userData.getString(Config.KEY_NAME);
            email = userData.getString(Config.KEY_EMAIL);
            phoneNo = userData.getString(Config.KEY_PHONE);
        } catch (JSONException e) {
            e.printStackTrace();
        }
       // textViewResult.setText("Name:\t" + name + "\nEmail:\t" + email + "\nPhone No:\t" + phoneNo);

    }

    /*
    @Override
    public void onClick(View v) {
        getData();
    }        */
}

