package com.star.uibestpractice;


public class Msg {

    private static final int TYPE_RECEIVED = 0;
    private static final int TYPE_SENT = 1;

    private String mContent;
    private int mType;

    public Msg(String content, int type) {
        this.mContent = content;
        this.mType = type;
    }

    public String getContent() {
        return mContent;
    }

    public int getType() {
        return mType;
    }
}
