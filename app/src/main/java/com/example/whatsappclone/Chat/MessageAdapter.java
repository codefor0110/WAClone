package com.example.whatsappclone.Chat;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.whatsappclone.R;
import com.stfalcon.frescoimageviewer.ImageViewer;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MessageAdapter extends  RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    ArrayList<MessageObject> messageList;

    public MessageAdapter(ArrayList<MessageObject> messageList){
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message,null,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutView.setLayoutParams(lp);

        MessageViewHolder rcv = new MessageViewHolder(layoutView);

        return rcv;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MessageAdapter.MessageViewHolder holder, int position) {

        holder.mMessage.setText(messageList.get(position).getMessage());
        holder.mSender.setText(messageList.get(position).getSenderId());

        if(messageList.get(holder.getAdapterPosition()).getMediaUrlList().isEmpty())
            holder.mViewMedia.setVisibility(View.GONE);

        holder.mViewMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ImageViewer.Builder(v.getContext(), messageList.get(holder.getAdapterPosition()).getMediaUrlList())
                        .setStartPosition(0)
                        .show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }


    public class MessageViewHolder extends RecyclerView.ViewHolder{

        public LinearLayout mLayout;
        TextView mMessage;
        TextView mSender;

        Button mViewMedia;

        public MessageViewHolder(View view){
            super(view);

            mMessage = view.findViewById(R.id.message1);
            mSender = view.findViewById(R.id.sender);
            mLayout = view.findViewById(R.id.layout);
            mViewMedia = view.findViewById(R.id.viewMedia);
        }

    }

}

