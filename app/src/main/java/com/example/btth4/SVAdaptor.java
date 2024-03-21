package com.example.btth4;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SVAdaptor extends RecyclerView.Adapter<SVAdaptor.ViewHolder> {

    ArrayList<SV> listSV;

    public SVAdaptor(ArrayList<SV> listSV) {
        this.listSV = listSV;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_sv,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtTitle1.setText(listSV.get(position).getTitle1());
        holder.txtTitle2.setText(listSV.get(position).getTitle2());
        holder.txtTitle3.setText(listSV.get(position).getTitle3());
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(
                listSV.get(holder.getAdapterPosition()).getImg(), "drawable", holder.itemView.getContext().getPackageName()
        );
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.imgSV);
        holder.btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.itemView.getContext().startActivity(new Intent(holder.itemView.getContext(),WebViewActivity.class));
            }
        });

        holder.txtTitle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double latitude = 21.007773;
                double longitude = 105.823882;
                String label = "Trường DH Thủy Lợi";
                String uriString = "geo:" + latitude + "," + longitude + "?q=" + latitude + "," + longitude + "(" + label + ")";
                Uri locationUri = Uri.parse(uriString);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, locationUri);
                holder.itemView.getContext().startActivity(mapIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listSV.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle1,txtTitle2,txtTitle3,btnOpen;
        ImageView imgSV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle1 = itemView.findViewById(R.id.txtTitle1);
            txtTitle2 = itemView.findViewById(R.id.txtTitle2);
            txtTitle3 = itemView.findViewById(R.id.txtTitle3);
            imgSV = itemView.findViewById(R.id.imgSV);
            btnOpen = itemView.findViewById(R.id.btnOpen);
        }
    }


}
