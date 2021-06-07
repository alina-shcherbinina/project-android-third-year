package com.example.projectandroidthirdyear;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private final ArrayList<ItemClass> myList;

    // INTERFACE FOR CLICKABLE ITEMS -----

    private OnRecyclerViewClickListener listener;

    public interface OnRecyclerViewClickListener{
        public void OnItemClick(int position);
    }
    // constructor for the interface
    public void OnRecyclerViewClickListener(OnRecyclerViewClickListener listener){
        this.listener = listener;
    }

    // ----------------- end

    public MyAdapter(ArrayList<ItemClass> myList) {
        this.myList = myList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_template, parent,false);
        return new MyViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ItemClass item = myList.get(position);
        holder.imageView_img.setImageResource(item.getImg());
        holder.textView_name.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView_img;
        public TextView textView_name;
                                                    // INTERFACE-------------
        public MyViewHolder(@NonNull View itemView, OnRecyclerViewClickListener listener) {
            super(itemView);

            imageView_img = itemView.findViewById(R.id.id_img_CardView);
            textView_name = itemView.findViewById(R.id.id_name_CardView);

            // USING INTERFACE -----
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null && getLayoutPosition()!=RecyclerView.NO_POSITION){
                        listener.OnItemClick(getLayoutPosition());
                        Log.d("my", "position" + getLayoutPosition());
                    }
                }
            });
        }
    }

}