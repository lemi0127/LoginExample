package com.algonquincollege.lemi0127.loginexample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText userNameText = (EditText) findViewById(R.id.username);
        final EditText passwordText = (EditText) findViewById(R.id.password);
        final Button loginButton = (Button) findViewById(R.id.loginbutton);
        final Button forgotButton = (Button) findViewById(R.id.forgotbutton);
        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = userNameText.getText().toString();
                String password = passwordText.getText().toString();
                Boolean checkBoxValue = checkBox.isChecked();

                if (userName.isEmpty()) {
                    userNameText.setError("Please Enter Your Username");
                    userNameText.requestFocus();
                }
                if (password.isEmpty()) {
                    passwordText.setError("Please Enter Your Password");
                    passwordText.requestFocus();
                }
                if (userName.length()!=8){
                    userNameText.setError("Username must be 8 characters long!");
                    userNameText.requestFocus();
                    return;
                }
                if (password.length() < 5){
                    passwordText.setError("Password must be at least 5 characters long!");
                    passwordText.requestFocus();
                    return;
                }
                if ( !Character.isLowerCase(userName.charAt(0)) || !Character.isLowerCase(userName.charAt(1)) ){
                    userNameText.setError("The first and second characters must be letters!");
                    userNameText.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(userNameText.getText()).matches()){
                    userNameText.setError("");
                    userNameText.requestFocus();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_LONG).show();
                }
            }

        });

        forgotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Forgot My Password :: onClick( )", Toast.LENGTH_SHORT).show();
            }
        });
    }

            @Override
            public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.menu_main, menu);
                return true;
            }

            public void handleLoginButton(View v) {
                Toast.makeText(getApplicationContext(), "Login button :: onClick( )", Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean onOptionsItemSelected(MenuItem item) {
                // Handle action bar item clicks here. The action bar will
                // automatically handle clicks on the Home/Up button, so long
                // as you specify a parent activity in AndroidManifest.xml.
                int id = item.getItemId();

                //noinspection SimplifiableIfStatement
                if (id == R.id.action_settings) {
                    return true;
                }

                return super.onOptionsItemSelected(item);
            }
        }
