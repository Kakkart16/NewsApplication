package com.example.newspilot;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.VewHolder> {
    Context context;
    ArrayList<ModelClass> modelClassArrayList;

    public Adapter(Context context2, ArrayList<ModelClass> modelClassArrayList2) {
        this.context = context2;
        this.modelClassArrayList = modelClassArrayList2;
    }

    public VewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VewHolder(LayoutInflater.from(this.context).inflate(R.layout.layout_item, (ViewGroup) null, false));
    }

    public void onBindViewHolder(VewHolder holder, int position) {
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Adapter.this.context, webView.class);
                i.putExtra("url", Adapter.this.modelClassArrayList.get(position).getUrl());
                Adapter.this.context.startActivity(i);
            }
        });
        TextView textView = holder.mtime;
        textView.setText("Published At: " + this.modelClassArrayList.get(position).getPublishedAt());
        holder.mauthor.setText(this.modelClassArrayList.get(position).getAuthor());
        holder.mheading.setText(this.modelClassArrayList.get(position).getTitle());
        holder.mcontent.setText(this.modelClassArrayList.get(position).getDescription());
        Glide.with(this.context).load(this.modelClassArrayList.get(position).getUrlToImage()).into(holder.imageView);
    }

    public int getItemCount() {
        return this.modelClassArrayList.size();
    }

    public class VewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imageView;
        TextView mauthor;
        TextView mcontent;
        TextView mheading;
        TextView mtime;

        public VewHolder(View itemView) {
            super(itemView);
            this.mheading = (TextView) itemView.findViewById(R.id.mainheading);
            this.mcontent = (TextView) itemView.findViewById(R.id.content);
            this.mauthor = (TextView) itemView.findViewById(R.id.author);
            this.mtime = (TextView) itemView.findViewById(R.id.time);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageview);
            this.cardView = (CardView) itemView.findViewById(R.id.cardview);
        }
    }
}
