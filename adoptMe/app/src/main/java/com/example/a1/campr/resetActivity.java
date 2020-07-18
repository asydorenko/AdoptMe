package com.example.a1.campr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class resetActivity extends AppCompatActivity {
    private Button msubmit;
    private TextView mback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        msubmit = (Button) findViewById(R.id.submit);
        msubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(resetActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        });


        mback = (TextView) findViewById(R.id.back);
        mback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(resetActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        });

    }
}
