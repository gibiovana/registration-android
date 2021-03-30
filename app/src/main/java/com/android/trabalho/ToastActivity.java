package com.android.trabalho;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        /*Toast.makeText(this, "olá mundo", Toast.LENGTH_LONG).show();

        MainActivity.registeredUsers.get(ListActivityUsers.position).showToast(ToastActivity.this);

        Bundle receivedData = getIntent().getExtras();
        String value = receivedData.getString("data");
        Toast.makeText(this, value, Toast.LENGTH_LONG).show();*/
    }
}