package com.ignacio.lorenz.prrcmobile;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private Button Login;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Name = (EditText) findViewById(R.id.etEmail);
        Password = (EditText) findViewById(R.id.etPassword);
        Login = (Button) findViewById(R.id.btnLogin);

        Login.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });
    }

    //User Authentication
    private void validate(String userEmail, String userPassword) {
        if ((userEmail.equals("SuperAdmin")) && userPassword.equals("SuperAdmin")) {
            Intent intent = new Intent(Login.this, HomeActivity.class);
            startActivity(intent);
        }   else if ((userEmail.equals("Encoder")) && userPassword.equals("Encoder")) {
            Intent intent = new Intent(Login.this, HomeActivity.class);
            startActivity(intent);
        }  else if ((userEmail.equals("Admin")) && userPassword.equals("Admin")) {
            Intent intent = new Intent(Login.this, HomeActivity.class);
            startActivity(intent);
        }  else if ((userEmail.equals("Viewer")) && userPassword.equals("Viewer")) {
            Intent intent = new Intent(Login.this, HomeActivity.class);
            startActivity(intent);
        }

        //Dialog Box
        else if (userEmail.equals("") || userPassword.equals("")) {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("ALERT!");
            alertDialog.setMessage("Fill All Fields!");
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            alertDialog.show();
        } else {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("ALERT!");
            alertDialog.setMessage("Incorrect Username OR Password");
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            alertDialog.show();
        }

    }
}


