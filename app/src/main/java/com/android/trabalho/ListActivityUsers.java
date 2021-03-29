package com.android.trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;

public class ListActivityUsers extends ListActivity {

    public static int position = 0;
    public ArrayAdapter<User> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        arrayAdapter = new ArrayAdapter<User>(this, android.R.layout.simple_list_item_1, MainActivity.registeredUsers);
        super.setListAdapter(arrayAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        this.position = position;

        Intent intent = new Intent(this, ToastActivity.class);
        intent.putExtra("data", arrayAdapter.getItem(position).toString());

        startActivity(intent);
    }
}
