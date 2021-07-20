package com.example.whatsappclone.Chat;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.whatsappclone.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class MediaAdapter extends RecyclerView.Adapter<MediaAdapter.MediaViewHolder> {

    ArrayList<String> mediaList;
    Context context;

    public MediaAdapter(ArrayList<String> mediaList, Context context) {
        this.mediaList = mediaList;
        this.context = context;
    }


    @NonNull
    @NotNull
    @Override
    public MediaViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_media,null,false);
        MediaViewHolder mediaViewHolder = new MediaViewHolder(layoutView);
        return mediaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MediaAdapter.MediaViewHolder holder, int position) {

        Glide.with(context).load(Uri.parse(mediaList.get(position))).into(holder.mMedia);


    }

    @Override
    public int getItemCount() {
        return mediaList.size();
    }

    public class MediaViewHolder extends RecyclerView.ViewHolder{

        ImageView mMedia;

        public MediaViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            mMedia = itemView.findViewById(R.id.media);
        }
    }


}
