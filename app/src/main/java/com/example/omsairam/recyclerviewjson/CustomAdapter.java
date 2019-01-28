package com.example.omsairam.recyclerviewjson;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ListviewHolder> {
    Context context;
    public List<Model> modelList;

    public CustomAdapter(Context context, List<Model> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ListviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View modelview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_layout,viewGroup,false);
        return new ListviewHolder (modelview);
    }

    @Override
    public void onBindViewHolder(@NonNull ListviewHolder listviewHolder, int i) {
        Model row =  modelList.get(i);
      listviewHolder.textView.setText (row.getText ());
Picasso.get ().load (row.getImage ()).into (listviewHolder.img);

    }

    @Override
    public int getItemCount() {
        return modelList.size ();
    }

    public class ListviewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView textView;

        public ListviewHolder(@NonNull View itemView) {
            super (itemView);
            img = itemView.findViewById (R.id.image);
            textView = itemView.findViewById (R.id.text);
        }
    }
}
