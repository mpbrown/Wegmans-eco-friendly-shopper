package io.github.anthonymj.foodpointtech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this, Previous_Visits_Activity.class));
                DatabaseHelper dbH = new DatabaseHelper();
                String s = dbH.getMilkInline();
                int respcode = dbH.get_myresponsecode();
                String rscStr = Integer.toString(respcode);
                String mytext = "nope";
                if (s.isEmpty()){
                    mytext = "yesss";
                }
                Toast.makeText(MainActivity.this, s,
                        Toast.LENGTH_LONG).show();
            }
        });
        button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this, ShoppingCart.class));
            }
        });
        button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this, Expiry.class));
            }
        });
    }
}
