package comp3350.umhub.presentation;

import comp3350.umhub.R;
import comp3350.umhub.application.Services;
import comp3350.umhub.persistence.sqlite.DatabaseNotCreatedException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends Activity implements View.OnClickListener {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        try{
            Services.getDatabase();
        } catch (DatabaseNotCreatedException e) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Initializing database for the first time. Please be patient",Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
        }
        Button loginBtn = findViewById(R.id.login1);
        TextView signUp = findViewById(R.id.signup1);
        loginBtn.setOnClickListener(this);
        signUp.setOnClickListener(this);
    }

    protected void onDestroy(){
        super.onDestroy();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login1:
                startActivity(new Intent(HomeActivity.this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                break;
            case R.id.signup1:
                startActivity(new Intent(HomeActivity.this, MajorsActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                break;
        }
    }
}


