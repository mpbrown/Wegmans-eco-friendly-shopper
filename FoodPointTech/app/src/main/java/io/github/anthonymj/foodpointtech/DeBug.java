package io.github.anthonymj.foodpointtech;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DeBug extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_de_bug);


        button = findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
<<<<<<< HEAD:FoodPointTech/app/src/main/java/io/github/anthonymj/foodpointtech/DeBugThisBiatch.java
                MilkTask task = new MilkTask();
                task.execute();
=======
                DatabaseHelper dbH = new DatabaseHelper();
                String s = dbH.getMilkInline();
                int respcode = dbH.get_myresponsecode();
                String rscStr = Integer.toString(respcode);
                String mytext = "nope";
                if (s.isEmpty()){
                    mytext = "yesss";
                }
                Toast.makeText(DeBug.this, s, Toast.LENGTH_LONG).show();
>>>>>>> pretty-boy:FoodPointTech/app/src/main/java/io/github/anthonymj/foodpointtech/DeBug.java
            }
        });
        button = findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Toast.makeText(DeBug.this, "works", Toast.LENGTH_LONG).show();
            }
        });
    }
}