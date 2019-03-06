package com.ignacio.lorenz.prrcmobile;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class Login extends AppCompatActivity {

    Button btn_login;
    EditText et_username;
    EditText et_password;
    SharedPreferences sp;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_username = (EditText) findViewById(R.id.etEmail);
        et_password = (EditText) findViewById(R.id.etPassword);
        btn_login = (Button) findViewById(R.id.btnLogin);

        sp = PreferenceManager.getDefaultSharedPreferences(this);
        btn_login.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {

                HashMap postData = new HashMap();
                postData.put("btn_Login", "Login");
                postData.put("mobile", "android");
                postData.put("txtUsername", et_username.getText().toString());
                postData.put("txtPassword", et_password.getText().toString() );

                PostResponseAsyncTask loginTask =
                        new PostResponseAsyncTask(Login.this, postData, new AsyncResponse() {
                            @Override
                            public void processFinish(String output) {
                                if(output.equals("success")){
                                    SharedPreferences.Editor editor = sp.edit();
                                    editor.putString("username", et_username.getText().toString());
                                    editor.apply();
                                    Intent intent = new Intent(Login.this, HomeActivity_SuperAdmin.class);
                                    startActivity(intent);
                                    /*Toast.makeText(Login.this, "Login Successfully", Toast.LENGTH_LONG).show();*/
                                }else if (et_username.equals("") || et_password.equals("")) {
                                    AlertDialog alertDialog = new AlertDialog.Builder(Login.this).create();
                                    alertDialog.setTitle("ALERT!");
                                    alertDialog.setMessage("Fill All Fields!");
                                    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                        }
                                    });
                                    alertDialog.show();
                                } else {
                                    AlertDialog alertDialog = new AlertDialog.Builder(Login.this ).create();
                                    alertDialog.setTitle("ALERT!");
                                    alertDialog.setMessage("Incorrect Username OR Password");
                                    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                        }
                                    });
                                    alertDialog.show();
                                }
                            }
                        });
                //Use 10.0.3.2 for GenyMotion
                //Use 10.0.2.2:80 for Android native Emulator
                //If you're going to use a real Android device, use your laptop's IP Address (type 'ipconfig' in CMD for details)
                loginTask.execute("http://192.168.1.7/android/login.php");
            }
        });
    }
}


