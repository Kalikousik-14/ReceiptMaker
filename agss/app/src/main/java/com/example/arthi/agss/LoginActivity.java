package com.example.arthi.agss;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseUser;



public class LoginActivity extends AppCompatActivity {



    private EditText usernameView;

    private EditText passwordView;

    SharedPreferences sp;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);




        Parse.initialize(this);
        ParseInstallation.getCurrentInstallation().saveInBackground();


        usernameView = (EditText) findViewById(R.id.username);

        passwordView = (EditText) findViewById(R.id.password);



        final Button login = findViewById(R.id.login_button);

        login.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                //Validating the log in data

                boolean validationError = false;



                StringBuilder validationErrorMessage = new StringBuilder("Please, insert ");

                if (isEmpty(usernameView)) {

                    validationError = true;

                    validationErrorMessage.append("an username");

                }

                if (isEmpty(passwordView)) {

                    if (validationError) {

                        validationErrorMessage.append(" and ");

                    }

                    validationError = true;

                    validationErrorMessage.append("a password");

                }

                validationErrorMessage.append(".");



                if (validationError) {

                    Toast.makeText(LoginActivity.this, validationErrorMessage.toString(), Toast.LENGTH_LONG).show();

                    return;

                }



                //Setting up a progress dialog

                final ProgressDialog dlg = new ProgressDialog(LoginActivity.this);

                dlg.setTitle("Please, wait a moment.");

                dlg.setMessage("Logging in...");

                dlg.show();



                ParseUser.logInInBackground(usernameView.getText().toString(), passwordView.getText().toString(), new LogInCallback() {

                    @Override

                    public void done(ParseUser parseUser, ParseException e) {

                        if (parseUser != null) {

                            dlg.dismiss();

                            alertDisplayer("Sucessful Login","Welcome back " + usernameView.getText().toString() + "!");



                        } else {

                            dlg.dismiss();

                            ParseUser.logOut();

                            Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();

                        }

                    }

                });



            }

        });



        final Button signup_button = findViewById(R.id.signup_button);

        signup_button.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(intent);

            }

        });

        sp = getSharedPreferences("login",MODE_PRIVATE);

        if(sp.getBoolean("logged",false))
        {
            goToAreaActivity();
        }
    }




    private boolean isEmpty(EditText text) {

        if (text.getText().toString().trim().length() > 0) {

            return false;

        } else {

            return true;

        }

    }



    private void alertDisplayer(String title,String message){

        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this)

                .setTitle(title)

                .setMessage(message)

                .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override

                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();

                        sp.edit().putBoolean("logged",true).apply();

                        Intent intent = new Intent(LoginActivity.this, AreaActivity.class);

                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                        startActivity(intent);

                    }

                });

        AlertDialog ok = builder.create();

        ok.show();

    }
    public void goToAreaActivity()
    {
        Intent i = new Intent(this,AreaActivity.class);

        startActivity(i);
    }

}