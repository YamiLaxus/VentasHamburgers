
//Impulsado pot PhoneDev.

package com.phonedev.inventarioventas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void Registro(View view){
        Intent reg = new Intent(this, ActivityReg.class);
        startActivity(reg);
    }
}
