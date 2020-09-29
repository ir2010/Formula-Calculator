package com.ir_sj.thermalanddimensionalcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class Splashscreen extends AppCompatActivity {
    Handler handle;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Calculator");


        progressBar=findViewById(R.id.pbar);
        progressBar.getProgress();
        handle=new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                    startActivity(new Intent(Splashscreen.this, MainActivity.class));
                finish();
            }
        },4000);
    }
}
