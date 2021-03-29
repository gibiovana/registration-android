package com.android.trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        Bundle receivedData = getIntent().getExtras();
        String value = receivedData.getString("data");

        Toast.makeText(this, value, Toast.LENGTH_LONG).show();
    }
}