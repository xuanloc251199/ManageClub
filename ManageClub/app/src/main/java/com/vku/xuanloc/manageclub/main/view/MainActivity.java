package com.vku.xuanloc.manageclub.main.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.vku.xuanloc.manageclub.R;
//import com.vku.xuanloc.manageclub.login_register.view.LoginActivity;
//import com.vku.xuanloc.manageclub.login_register.view.RegisterActivity;

public class MainActivity extends AppCompatActivity {

    Handler handler;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        img = findViewById(R.id.img);
        img.animate().alpha(4000).setDuration(0);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent dsp  = new Intent(MainActivity.this, NavigationBarActivity.class);
                startActivity(dsp);
                finish();
            }
        },2000);
    }
}