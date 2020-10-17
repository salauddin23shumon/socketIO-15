package com.kriyatma.nodesocket;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyViewHolder> {

    private List<Message> mMessages;
    public static final String TAG = "MessageAdapter";

    public MessageAdapter(List<Message> mMessages) {
        this.mMessages = mMessages;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.layout_message, parent, false);
        return new MessageAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Message message = mMessages.get(position);
//        Message message = mMessages.get(position);
        holder.setMessage(message.getMessage());
        if (message.getBitmap() != null)
            holder.setImage(message.getBitmap());
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + mMessages.size());
        return mMessages.size();
    }


    public void updateMsg(List<Message> mMessages) {
        this.mMessages = mMessages;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;
        private TextView mMessageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.image);
            mMessageView = (TextView) itemView.findViewById(R.id.message);
        }

        public void setMessage(String message) {
            if (message == null)
                return;
            else
                mMessageView.setText(message);
        }

        public void setImage(Bitmap bmp) {
            if (bmp == null) {
                Log.d(TAG, "setImage: no image");
                return;
            } else
                mImageView.setImageBitmap(bmp);
        }
    }
}
