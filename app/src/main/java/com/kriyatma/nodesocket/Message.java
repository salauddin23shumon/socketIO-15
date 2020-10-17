package com.kriyatma.nodesocket;

import android.graphics.Bitmap;

public class Message {

    private String message;
    private Bitmap bitmap;


    public Message(String message, Bitmap bitmap) {
        this.message = message;
        this.bitmap = bitmap;
    }

    public Message(String message) {
        this.message = message;
    }

    public Message() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
