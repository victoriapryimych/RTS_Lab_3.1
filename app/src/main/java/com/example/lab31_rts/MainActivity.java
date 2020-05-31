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
        TextView message = findViewById(R.id.Message);
        TextView result1 = findViewById(R.id.Result1);
        TextView result2 = findViewById(R.id.Result2);

        if(num == 0){
            message.setText("Zero");
            result1.setText("0");
            result2.setText("0");
            return;
        }
        if(num % 2 == 0){
            message.setText("Number is even");
            result1.setText("2");
            result2.setText(Integer.toString(num/2));
            return;
        }
        int a = (int) Math.ceil(Math.sqrt(num));
        if (a*a == num){
            message.setText("Perfect square root");
            result1.setText(Integer.toString(a));
            result2.setText(Integer.toString(a));
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
        message.setText("Result");
        result1.setText(Integer.toString(a - b));
        result2.setText(Integer.toString(a + b));
        return;
    }
}
