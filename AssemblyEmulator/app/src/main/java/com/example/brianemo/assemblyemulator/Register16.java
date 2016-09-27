package com.example.brianemo.assemblyemulator;

/**
 * Created by Brian Emo on 9/22/2016.
 */

public class Register16
{
    private String name;
    private Register8 high;

    private Register8 low;

    public Register16(String name)
    {
        this.name = name;
        this.high = new Register8(this.name + "H");
        this.low = new Register8(this.name + "L");
    }

    public Register8 getHigh() {
        return high;
    }

    public Register8 getLow() {
        return low;
    }
}
