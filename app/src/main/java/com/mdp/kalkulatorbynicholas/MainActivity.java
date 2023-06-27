package com.mdp.kalkulatorbynicholas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    private TextView tvinput, tvoutput;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnkoma,
            btnac, btnc, btnhasil, btntambah, btnkurang, btnkali, btnbagi, btnpersen;
    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnkoma = findViewById(R.id.btnkoma);
        btnpersen = findViewById(R.id.btnpersen);
        btnac = findViewById(R.id.btnAC);
        btnc = findViewById(R.id.btnhapus);
        btntambah = findViewById(R.id.btntambah);
        btnkurang = findViewById(R.id.btnkurang);
        btnkali = findViewById(R.id.btnkali);
        btnbagi = findViewById(R.id.btnbagi);
        btnhasil = findViewById(R.id.btnsamadengan);
        tvinput = findViewById(R.id.tvinput);
        tvoutput = findViewById(R.id.tvoutput);

        tvoutput.setText("0");

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = tvinput.getText().toString();
                tvinput.setText(data + "0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = tvinput.getText().toString();
                tvinput.setText(data + "1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = tvinput.getText().toString();
                tvinput.setText(data + "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = tvinput.getText().toString();
                tvinput.setText(data + "3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = tvinput.getText().toString();
                tvinput.setText(data + "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = tvinput.getText().toString();
                tvinput.setText(data + "5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = tvinput.getText().toString();
                tvinput.setText(data + "6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = tvinput.getText().toString();
                tvinput.setText(data + "7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = tvinput.getText().toString();
                tvinput.setText(data + "8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = tvinput.getText().toString();
                tvinput.setText(data + "9");
            }
        });
        btnkoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = tvinput.getText().toString();
                tvinput.setText(data + ".");
            }
        });
        btnac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvinput.setText("");
                tvoutput.setText("0");
            }
        });
        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kata = tvinput.getText().toString();
                int input = kata.length();
                if (input > 0) {
                    tvinput.setText(kata.substring(0, input - 1));
                }
            }
        });
        btntambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = tvinput.getText().toString();
                tvinput.setText(data + "+");
            }
        });
        btnkurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = tvinput.getText().toString();
                tvinput.setText(data + "-");
            }
        });
        btnkali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = tvinput.getText().toString();
                tvinput.setText(data + "×");
            }
        });
        btnbagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = tvinput.getText().toString();
                tvinput.setText(data + "÷");
            }
        });
        btnpersen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = tvinput.getText().toString();
                tvinput.setText(data + "%");
            }
        });

        btnhasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String finalResult;
                try {
                    data = tvinput.getText().toString();
                    data = data.replace("%", "/100");
                    data = data.replace("÷", "/");
                    data = data.replace("×", "*");

                    Context context = Context.enter();
                    context.setOptimizationLevel(-1);
                    Scriptable scriptable = context.initStandardObjects();
                    finalResult = context.evaluateString(scriptable, data,
                            "Javascript", 1, null).toString();

                    if (finalResult.endsWith(".0")) {
                        finalResult = finalResult.replace(".0", "");
                    }

                } catch (Exception e) {
                    finalResult = "Error";
                }

                tvoutput.setText(finalResult);

            }
        });
    }
}