package io.github.anthonymj.foodpointtech;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ShoppingCart extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        ImageView imageView = (ImageView)findViewById(R.id.imageView2);
        Picasso.get().load("https://wegmans.com/content/dam/wegmans/products/914/11914.jpg").into(imageView);
        imageView = (ImageView)findViewById(R.id.imageView);
        Picasso.get().load("https://wegmans.com/content/dam/wegmans/products/914/11914.jpg").into(imageView);
        imageView = (ImageView)findViewById(R.id.imageView3);
        Picasso.get().load("https://wegmans.com/content/dam/wegmans/products/914/11914.jpg").into(imageView);
        imageView = (ImageView)findViewById(R.id.imageView4);
        Picasso.get().load("https://wegmans.com/content/dam/wegmans/products/914/11914.jpg").into(imageView);
        imageView = (ImageView)findViewById(R.id.imageView5);
        Picasso.get().load("https://wegmans.com/content/dam/wegmans/products/914/11914.jpg").into(imageView);
        imageView = (ImageView)findViewById(R.id.imageView6);
        Picasso.get().load("https://wegmans.com/content/dam/wegmans/products/914/11914.jpg").into(imageView);
        imageView = (ImageView)findViewById(R.id.imageView7);
        Picasso.get().load("https://wegmans.com/content/dam/wegmans/products/914/11914.jpg").into(imageView);
        imageView = (ImageView)findViewById(R.id.imageView8);
        Picasso.get().load("https://wegmans.com/content/dam/wegmans/products/914/11914.jpg").into(imageView);
    }
}
