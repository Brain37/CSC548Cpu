package com.example.brianemo.assemblyemulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity
{
    private Button executeButton;
    private EditText callEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Cpu cpu = new Cpu();
        Register16[] register16s = cpu.getRegisters();

        this.callEditText = (EditText)this.findViewById(R.id.instructionET);
        register16s[0].getHigh().setTextView((TextView)this.findViewById(R.id.AH));
        register16s[0].getLow().setTextView((TextView)this.findViewById(R.id.AL));
        register16s[1].getHigh().setTextView((TextView)this.findViewById(R.id.BH));
        register16s[1].getLow().setTextView((TextView)this.findViewById(R.id.BL));
        register16s[2].getHigh().setTextView((TextView)this.findViewById(R.id.CH));
        register16s[2].getLow().setTextView((TextView)this.findViewById(R.id.CL));
        register16s[3].getHigh().setTextView((TextView)this.findViewById(R.id.DH));
        register16s[3].getLow().setTextView((TextView)this.findViewById(R.id.DL));

        this.executeButton = (Button)this.findViewById(R.id.executeButton);
        executeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                cpu.ParseCommand(callEditText.getText().toString());
            }
        });
    }


}
