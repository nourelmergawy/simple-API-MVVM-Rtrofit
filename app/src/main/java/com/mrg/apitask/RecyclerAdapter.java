package com.mrg.apitask;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<MyList>mylists;
    private Context context;
    public RecyclerAdapter(List<MyList> mylists, Context context) {
        this.mylists = mylists;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view =  inflater.inflate(R.layout.recycler_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textView.setText(mylists.get(position).getTitle());
        Glide.with(context)
                .load(mylists.get(position).getImgUri())
//                .error(R.drawable.mainicon)
                .placeholder(R.drawable.ic_launcher_background)
                .into( holder.imageView);

    holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: done");
            }
        });
    }

    @Override
    public int getItemCount() {
        return mylists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView ,textView2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);

        }
    }
    public void updateList( List<MyList> newList) {
        // on below line we are clearing
        // our notes array list
//        mylists.clear();
        // on below line we are adding a
        // new list to our all notes list.
        mylists.addAll(newList);
        // on below line we are calling notify data
        // change method to notify our adapter.
        notifyDataSetChanged();
    }
}
