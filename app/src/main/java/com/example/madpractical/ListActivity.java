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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<User> userList = new ArrayList<>();
        for(int i = 0; i<20; i++) {
            int randomName = new Random().nextInt();
            int randomDesc = new Random().nextInt();
            boolean randomFollow = new Random().nextBoolean();
            User u = new User();
            u.setName("Name"+randomName);
            u.setDesc("Description "+randomDesc);
            u.setFollowed(randomFollow);
            userList.add(u);
        }

        RecyclerView rv = findViewById(R.id.listRV);
        ListAdapter adapter = new ListAdapter(this, userList);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);
    }
}
