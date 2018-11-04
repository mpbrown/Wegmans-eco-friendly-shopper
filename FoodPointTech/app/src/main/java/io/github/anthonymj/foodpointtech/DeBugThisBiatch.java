package io.github.anthonymj.foodpointtech;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DeBugThisBiatch extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_de_bug_this_biatch);


        button = findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MilkTask newTask = new MilkTask(getApplicationContext());
                newTask.execute();
            }
        });
        button = findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Toast.makeText(DeBugThisBiatch.this, "works", Toast.LENGTH_LONG).show();
            }
        });


    }




}