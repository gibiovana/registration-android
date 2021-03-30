package com.android.trabalho;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListActivityUsers extends ListActivity {

    public static int position = 0;
    public List<User> usersList = MainActivity.registeredUsers;
    public List<String> itemsListActivity = new ArrayList<>();
    public ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        addList();
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemsListActivity);
        super.setListAdapter(arrayAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        this.position = position;

        Intent intent = new Intent(this, ToastActivity.class);
        //intent.putExtra("data", arrayAdapter.getItem(position).toString());

        startActivity(intent);
    }

    public void addList() {
        for (User user : usersList)
            itemsListActivity.add(user.getName() + ": " + user.getGender());
    }
}
