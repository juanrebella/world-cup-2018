package com.example.nacho.world_cup_russia_2018.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.nacho.world_cup_russia_2018.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void goHome(View view) {

        //todo AGREGAR INTENT QUE ENVÍA A HOME
    }

    public void goCreateAccount(View view) {
        //todo AGREGAR INTENT QUE CREA CUENTA
    }
}
