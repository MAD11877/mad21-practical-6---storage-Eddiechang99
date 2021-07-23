package com.example.madpractical;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListViewHolder extends RecyclerView.ViewHolder{
    public TextView name;
    public TextView desc;
    public ImageView profilePic;

    public ListViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.listNameTV);
        desc = itemView.findViewById(R.id.listDescTV);
        profilePic = itemView.findViewById(R.id.listImg);
    }
}
