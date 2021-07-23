package com.example.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    User user;
    Button followBtn;
    Button messageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Debug","create");

        followBtn = findViewById(R.id.btnFollow);
        messageBtn = findViewById(R.id.btnMsg);
        user = (User)getIntent().getSerializableExtra("user");

        followBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setFollowed(!user.getFollowed());
                if(user.getFollowed()) {
                    Toast.makeText(MainActivity.this, "Followed", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Unfollowed", Toast.LENGTH_SHORT).show();
                }
                setFollowBtn();
            }
        });

        messageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListActivity.class);
                startActivity(i);
            }
        });

        TextView name = findViewById(R.id.txtName);
        name.setText(user.getName());
        TextView description = findViewById(R.id.txtDescription);
        description.setText(user.getDesc());
        setFollowBtn();
    }

    private void setFollowBtn() {
        if (user.getFollowed()) {
            followBtn.setText("Unfollow");
        } else {
            followBtn.setText("Follow");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Debug","Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Debug", "Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Debug", "Destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Debug","Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Debug","Resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Debug","Restart");
    }
}