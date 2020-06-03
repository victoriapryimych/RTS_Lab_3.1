package com.example.lab31_rts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view){
        EditText input = findViewById(R.id.number1);
        int num = Integer.parseInt(input.getText().toString());
        TextView result = findViewById(R.id.Result);
        String resStr = "";
        long start = System.nanoTime();
        long deltaTime;

        if(num == 0){
            resStr = "Root1 = Root2 = 0";
            deltaTime = System.nanoTime() - start;
            resStr += "\nTime = " + deltaTime + " nanoseconds";
            result.setText(resStr);
            return;
        }
        if(num % 2 == 0){
            resStr = "Root1 = " + (2);
            resStr += "\nRoot2 = " + (num/2);
            deltaTime = System.nanoTime() - start;
            resStr += "\nTime = " + deltaTime + " nanoseconds";
            result.setText(resStr);
            return;
        }
        int a = (int) Math.ceil(Math.sqrt(num));
        if (a*a == num){
            resStr = "Root1 = Root2 = " + a;
            deltaTime = System.nanoTime() - start;
            resStr += "\nTime = " + deltaTime + " nanoseconds";
            result.setText(resStr);
            return;
        }
        int b;
        while(true){
            int b1 = a*a - num;
            b = (int)(Math.sqrt(b1));
            if(b*b == b1)
                break;
            else
                a++;
        }
        resStr = "Root1 = " + (a-b);
        resStr += "\nRoot2 = " + (a+b);
        deltaTime = System.nanoTime() - start;
        resStr += "\nTime = " + deltaTime + " nanoseconds";
        result.setText(resStr);
        return;
    }
}
