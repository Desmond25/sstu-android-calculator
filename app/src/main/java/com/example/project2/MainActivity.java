package com.example.project2;

import android.service.autofill.OnClickAction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CalculatorModel calculator;

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] numberIds = new int[] {
            R.id.n0,
            R.id.n1,
            R.id.n2,
            R.id.n3,
            R.id.n4,
            R.id.n5,
            R.id.n6,
            R.id.n7,
            R.id.n8,
            R.id.n9,
            R.id.dot
        };

        int[] actionsIds = new int[] {
            R.id.plus,
            R.id.minus,
            R.id.division,
            R.id.multiply,
            R.id.equals,
            R.id.sqrt,
            R.id.fraction,
            R.id.toggleSign,
            R.id.clear
        };

        text = findViewById(R.id.text);

        calculator = new CalculatorModel();

        View.OnClickListener numButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onNumPressed(view.getId());
                text.setText(calculator.getText());
            }
        };

        View.OnClickListener actionButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onActionPressed(view.getId());
                text.setText(calculator.getText());
            }
        };

        for (int i = 0; i < numberIds.length; i++) {
            findViewById(numberIds[i]).setOnClickListener(numButtonClickListener);
        }

        for (int i = 0; i < actionsIds.length; i++) {
            findViewById(actionsIds[i]).setOnClickListener(actionButtonClickListener);
        }
    }
}