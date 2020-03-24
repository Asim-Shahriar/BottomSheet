package com.example.bottomsheet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ImageViewHolder> {

    private int[] images;
    public RecyclerAdapter(int[] images){
        this.images=images;
    }
    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.bottom_sheet_recycler_item,parent,false);
        ImageViewHolder imageViewHolder=new ImageViewHolder(v);
        return imageViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {

        int image_id=images[position];
        holder.car.setImageResource(image_id);
        holder.carname.setText("Images :"+position);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView car;
        TextView carname;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            car=itemView.findViewById(R.id.car_iv);
            carname=itemView.findViewById(R.id.car_tv);
        }
    }
}
