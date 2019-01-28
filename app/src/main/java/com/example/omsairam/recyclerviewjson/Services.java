package com.example.omsairam.recyclerviewjson;

import android.app.Service;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Services extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<ServiceClass>serviceClassArrayList;
    LinearLayoutManager linearLayoutManager;
    ServiceAdapter serviceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        recyclerView=(RecyclerView) findViewById(R.id.service_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
         ServiceAdapter serviceAdapter=new ServiceAdapter(Services.this,serviceClassArrayList);
        recyclerView.setAdapter(serviceAdapter);

    }




    // Service  Adapter
    public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>{
        Context context;
        ArrayList<ServiceClass>serviceClassArrayList;
        LayoutInflater layoutInflater;

        public ServiceAdapter(Context context, ArrayList<ServiceClass> serviceClassArrayList) {
            this.context = context;
            this.serviceClassArrayList = serviceClassArrayList;
        }

        @NonNull
        @Override
        public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view=LayoutInflater.from(context).inflate(R.layout.service_custom,viewGroup,false);
            return new ServiceViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ServiceViewHolder serviceViewHolder, int i) {
            ServiceClass serviceClass=serviceClassArrayList.get(i);
            serviceViewHolder.textView.setText(serviceClass.service_text);
            Picasso.get().load(serviceClass.service_image).into(serviceViewHolder.imageView);

        }

        @Override
        public int getItemCount() {
            return serviceClassArrayList.size();
        }

        public class ServiceViewHolder extends RecyclerView.ViewHolder{
            ImageView imageView;
            TextView textView;

            public ServiceViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView=(ImageView)itemView.findViewById(R.id.service_image);
                textView=(TextView)itemView.findViewById(R.id.service_text);
            }
        }
    }
}
