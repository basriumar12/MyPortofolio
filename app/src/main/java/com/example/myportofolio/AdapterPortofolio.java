package com.example.myportofolio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.ImageViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class AdapterPortofolio  extends RecyclerView.Adapter<AdapterPortofolio.MyHolder> {

    private ArrayList<ModelPortofolio> listPortofolio;
    private OnItemClickCallback onItemClickCallback;
    public interface OnItemClickCallback {
        void onItemClicked(ModelPortofolio data);
    }
    void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    AdapterPortofolio(ArrayList<ModelPortofolio> list) {
        this.listPortofolio = list;
    }

    LayoutInflater inflater;
    @NonNull
    @Override
    public AdapterPortofolio.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterPortofolio.MyHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(listPortofolio.get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgApp);
        holder.tvAppName.setText(listPortofolio.get(position).getName());
        //onclick item
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listPortofolio.get(holder.getAdapterPosition()));
            }
        });
    }

    //menentukan data size yang akan ditampilkan
    @Override
    public int getItemCount() {
        return listPortofolio.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
       ImageView imgApp;
       TextView tvAppName;
        public MyHolder( View itemView) {
            super(itemView);
            imgApp = itemView.findViewById(R.id.img_app);
            tvAppName = itemView.findViewById(R.id.tv_nama_app);

        }
    }
}
