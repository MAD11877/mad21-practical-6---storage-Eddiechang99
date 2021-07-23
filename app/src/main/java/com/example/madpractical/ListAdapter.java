package com.example.madpractical;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListViewHolder> {
    Context context;
    ArrayList<User> userList;

    public ListAdapter(Context ctx, ArrayList<User> userList)
    {
        context = ctx;
        this.userList = userList;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = null;

        if(viewType == 7) {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_list2,parent,false);
        } else {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_list,parent,false);
        }
        return new ListViewHolder(item);
    }

    @Override
    public int getItemViewType(int position) {
        return Integer.parseInt(userList.get(position).getName().substring(userList.get(position).getName().length()-1));
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        User u = userList.get(position);

        holder.name.setText(u.getName());
        holder.desc.setText(u.getDesc());
        holder.profilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(context)
                        .setTitle("Profile")
                        .setMessage(u.getName())
                        .setNegativeButton("CLOSE", null)
                        .setPositiveButton("VIEW", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(context,MainActivity.class);
                                i.putExtra("user", u);
                                context.startActivity(i);
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
