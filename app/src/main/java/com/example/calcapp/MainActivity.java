package com.example.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

    }

    private void toastMake(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void onClick(View v) {

        try {

        EditText editText1 = (EditText)findViewById(R.id.editText1);
        String s = editText1.getText().toString();
        Double num1 = Double.parseDouble(s);

        EditText editText2 = (EditText)findViewById(R.id.editText2);
        String t = editText2.getText().toString();
        Double num2 = Double.parseDouble(t);

        double sum = 0;

            switch (v.getId()) {
                case R.id.button1:
                    sum = num1 + num2;
                    break;
                case R.id.button2:
                    sum = num1 - num2;
                    break;
                case R.id.button3:
                    sum = num1 * num2;
                    break;
                case R.id.button4:
                    sum = num1 / num2;
                    break;
                default:
                    break;
            }

            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("VALUE1", sum);
            startActivity(intent);

        } catch (NumberFormatException e) {
            toastMake("正しい数値を入力してください");
        }
    }
}
