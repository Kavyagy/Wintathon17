package com.myapp.android.projectandroid;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Queries extends AppCompatActivity {
    GMailSender sender;
    EditText t1;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queries);
        String idd="khajanchishreya@gmail.com";
        String pass="meshreya";

        sender = new GMailSender(idd,pass);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.
                Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        Button b1 = (Button)findViewById(R.id.submit);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    t1=(EditText)findViewById(R.id.editText);
                    s=t1.getText().toString();
                    // new MyAsyncClass().execute();
                    try {
                        sender.sendMail("Subject",s,"khajanchishreya@gmail.com","shrkhajanchi@gmail.com");
                        Toast.makeText(Queries.this,"mail sent",Toast.LENGTH_SHORT).show();
                    }

                    catch (Exception ex) {
                        Toast.makeText(Queries.this,ex.getMessage(),Toast.LENGTH_LONG).show();
                    }
                } catch (Exception ex) {
                    //Toast.makeText(Activity., ex.toString(), 100).show();
                }
            }
        });
    }
    class MyAsyncClass extends AsyncTask<Void, Void, Void> {

        ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = ProgressDialog.show(Queries.this, "Please wait", "Sending mail", true, false);
            pDialog.setMessage("Please wait...");
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... mApi) {
            try {
                sender.sendMail("Subject",s,"khajanchishreya@gmail.com","shrkhajanchi@gmail.com");
                Toast.makeText(Queries.this,"mail sent",Toast.LENGTH_SHORT).show();
            }

            catch (Exception ex) {
                Toast.makeText(Queries.this,ex.getMessage(),Toast.LENGTH_LONG).show();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            pDialog.cancel();
            Toast.makeText(Queries.this, "Email sent", Toast.LENGTH_LONG).show();
        }
    }
}