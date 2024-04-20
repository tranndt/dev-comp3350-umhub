package comp3350.umhub.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import javax.security.auth.login.LoginException;

import comp3350.umhub.application.Services;

import comp3350.umhub.R;
import comp3350.umhub.application.SignUpException;
import comp3350.umhub.business.ILogin;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private ILogin iLogin;
    private EditText eName;                      /* A user interface for entering/modifying the text */
    private EditText ePassword;
    private Button eLogin;
    private Button eSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        iLogin = Services.getILogin();

        eName = findViewById(R.id.etUserName);
        ePassword = findViewById(R.id.etPassword);
        eLogin = findViewById(R.id.btnLogin);
        eSignUp = findViewById(R.id.btnSignUp);

        /* Handle the click on login button */
        eLogin.setOnClickListener(this);
        eSignUp.setOnClickListener(this);
    }




    public void onClick(View view) {
        String username = eName.getText().toString();
        String password = ePassword.getText().toString();
        switch ( view.getId() ){
            case R.id.btnLogin:

                try
                {
                    iLogin.login(username,password);
                    startActivity(new Intent(this , MajorsActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                }
                catch(LoginException e)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Please enter valid credentials!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }
                break;
            case R.id.btnSignUp:
                try {
                    iLogin.signUp(username,password);
                    Toast toast = Toast.makeText(getApplicationContext(),"New user successfully created! Now you can log in using the credentials", Toast.LENGTH_SHORT);
                    toast.show();
                } catch (SignUpException e) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            e.getMessage(), Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }
                break;
        }
    }


    protected void onDestroy(){
        super.onDestroy();
    }

}
