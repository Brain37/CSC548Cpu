package com.example.brianemo.assemblyemulator;

import android.widget.MultiAutoCompleteTextView;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Brian Emo on 9/22/2016.
 */

public class Cpu
{
    public Register16[] getRegisters() {
        return Registers;
    }

    private Register16[] Registers;


    public Cpu()
    {
        this.Registers = new Register16[]{new Register16("A"), new Register16("B"), new Register16("C"), new Register16("D")};
    }

    public void Move(String destination, String source, String sourceType)

    {
        Register8 registerDestination = GetDestination(destination);

        if(sourceType.equals("payload"))
        {
            registerDestination.setPayload(source);
        }
        else if(sourceType.equals("register"))
        {
            Register8 registerSource = GetDestination(source);
            registerDestination.setPayload(registerSource.getPayload());
        }
        registerDestination.getTextView().setText(registerDestination.getName() + ": " + registerDestination.getPayload());
    }

    public Register8 GetDestination(String destination)
    {
        for(Register16 register : this.Registers)
        {
            if(destination.equalsIgnoreCase(register.getHigh().getName()))
            {
                return register.getHigh();
            }
            else
            {
                if(destination.equalsIgnoreCase(register.getLow().getName()))
                {
                    return register.getLow();
                }
            }
        }
        return null; //todo add an error throw
    }

    public void ParseCommand(String command)
     {
        StringTokenizer tokenizer = new StringTokenizer(command, " ,");
         String instructionName = "";
         String destination = "";
         String source = "";
         String sourceType = "";
        if(tokenizer.countTokens() > 2)
        {
            instructionName = tokenizer.nextToken().toString();
            destination = tokenizer.nextToken().toString();
            source = tokenizer.nextToken().toString();
            sourceType = isPayload(source).toString();
        }
         if(instructionName.equalsIgnoreCase("move"))
         {
             Move(destination, source, sourceType);
         }

    }

    public String isPayload(String inQuestion)
    {
        for(Register16 register : this.Registers)
        {
            if(inQuestion.equalsIgnoreCase(register.getHigh().getName()) || inQuestion.equalsIgnoreCase(register.getLow().getName()))
            {
                return "register";
            }
        }
        return "payload";
    }
}
