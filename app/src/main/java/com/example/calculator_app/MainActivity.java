package com.example.calculator_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button calculate;
    private EditText op1;
    private EditText op2;
    private RadioButton add;
    private RadioButton sub;
    private RadioButton mul;
    private RadioButton div;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        getViews();
        clickListener();
    }

    private void clickListener() {
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    private void calculate() {
        String operand_1 = op1.getText().toString();
        String operand_2 = op2.getText().toString();
        int var1 = Integer.parseInt(operand_1);
        int var2 = Integer.parseInt(operand_2);
        if (add.isChecked()) {
            result.setText(String.format("ADDITION :: %d", (var1 + var2)));
        } else if (sub.isChecked()) {
            result.setText(String.format("SUBTRACTION :: %d", (var1 - var2)));
        } else if (mul.isChecked()) {
            result.setText(String.format("MULTIPLICATION :: %d", (var1 * var2)));
        } else if (div.isChecked()) {
            try {
                int check = var1 / var2;
                result.setText(String.format("DIVISION :: %d", (var1 / var2)));
            } catch (ArithmeticException ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }

    private void getViews() {
        calculate = findViewById(R.id.button_calculate);
        op1 = findViewById(R.id.edit_text_op1);
        op2 = findViewById(R.id.edit_text_op2);
        add = findViewById(R.id.radio_button_add);
        sub = findViewById(R.id.radio_button_sub);
        mul = findViewById(R.id.radio_button_mul);
        div = findViewById(R.id.radio_button_div);
        result = findViewById(R.id.text_view_result);
    }
}