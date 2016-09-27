package com.example.brianemo.assemblyemulator;

import android.widget.TextView;

/**
 * Created by Brian Emo on 9/22/2016.
 */

public class Register8
{
    private String payload;

    private String name;

    public TextView textView;

    public Register8(String name)
    {
        this.name = name;
        this.payload = "";
        this.textView = null;
    }

    public String getPayload()
    {
        return payload;
    }

    public void setPayload(String payload)
    {
        this.payload = payload;
    }

    public String getName() { return name; }

    public TextView getTextView()
    {
        return textView;
    }

    public void setTextView(TextView textView)
    {
        this.textView = textView;
    }

}
