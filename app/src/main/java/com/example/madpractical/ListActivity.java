package com.example.madpractical;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    ArrayList<User> userList = null;
    DBHandler db = null;
    RecyclerView rv = null;
    ListAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        db = new DBHandler(this);
        userList = db.getUsers();

        rv = findViewById(R.id.listRV);
        adapter = new ListAdapter(this, userList);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        userList = db.getUsers();
        adapter = new ListAdapter(this, userList);
        adapter.notifyDataSetChanged();
        rv.setAdapter(adapter);
    }
}
