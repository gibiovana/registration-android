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

        ArrayAdapter<User> arrayAdapter = new ArrayAdapter<User>(this, android.R.layout.simple_list_item_1, MainActivity.registeredUsers);
        int position = ListActivityUsers.position;

        Toast.makeText(this, arrayAdapter.getItem(position).toString(), Toast.LENGTH_SHORT).show();
    }
}