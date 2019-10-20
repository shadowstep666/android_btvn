package vn.edu.hust.calcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvResult;
    TextView textInput;

    double op1 =Double.NaN ;
    double op2;   // gia tri 2 toan hang
    int op;         // 1: add, 2: sub, 3: mul, 4: div
    int state;      // 1: nhap op1, 2: nhap op2
    int tg;
    String ACTION ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.text_result);
        textInput = findViewById(R.id.text_input);

        findViewById(R.id.btn_0).setOnClickListener(this);
        findViewById(R.id.btn_1).setOnClickListener(this);
        findViewById(R.id.btn_2).setOnClickListener(this);
        findViewById(R.id.btn_3).setOnClickListener(this);
        findViewById(R.id.btn_4).setOnClickListener(this);
        findViewById(R.id.btn_5).setOnClickListener(this);
        findViewById(R.id.btn_6).setOnClickListener(this);
        findViewById(R.id.btn_7).setOnClickListener(this);
        findViewById(R.id.btn_8).setOnClickListener(this);
        findViewById(R.id.btn_9).setOnClickListener(this);

        findViewById(R.id.btn_add).setOnClickListener(this);
        findViewById(R.id.btn_sub).setOnClickListener(this);
        findViewById(R.id.btn_mul).setOnClickListener(this);
        findViewById(R.id.btn_div).setOnClickListener(this);

        findViewById(R.id.btn_equal).setOnClickListener(this);

        findViewById(R.id.btn_rev).setOnClickListener(this);
        findViewById(R.id.btn_bs).setOnClickListener(this);
        findViewById(R.id.btn_ce).setOnClickListener(this);
        findViewById(R.id.btn_c).setOnClickListener(this);

        // Khoi tao cac gia tri
        state = 1;
        op = 0;
        tg = 0 ;
        op1=0;

        tvResult.setText(String.valueOf(op1));

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_0:
                addValue(0);
                break;
            case R.id.btn_1:
                addValue(1);
                break;
            case R.id.btn_2:
                addValue(2);
                break;
            case R.id.btn_3:
                addValue(3);
                break;
            case R.id.btn_4:
                addValue(4);
                break;
            case R.id.btn_5:
                addValue(5);
                break;
            case R.id.btn_6:
                addValue(6);
                break;
            case R.id.btn_7:
                addValue(7);
                break;
            case R.id.btn_8:
                addValue(8);
                break;
            case R.id.btn_9:
                addValue(9);
                break;
            case R.id.btn_add:
                selectOperator(1);
                break;
            case R.id.btn_sub:
                selectOperator(2);
                break;
            case R.id.btn_mul:
                selectOperator(3);
                break;
            case R.id.btn_div:
                selectOperator(4);
                break;
            case R.id.btn_equal:
                calcResult();
                break;
            case R.id.btn_rev:
                reverseOperand();
                break;
            case R.id.btn_bs:
                removeDigit();
                break;
            case R.id.btn_ce:
                clearOperand();
                break;
            case R.id.btn_c:
                clearOperator();
                break;
        }


    }

    private void clearOperator() {
        // Khoi tao cac gia tri
        op1 = 0;
        op2 = 0;
        state = 1;
        op = 0;
        tg = 0 ;

        tvResult.setText(String.valueOf(op1));
        textInput.setText(String.valueOf(tg));
    }

    private void clearOperand() {
        if (state == 1) {
            op1 = 0;
            tvResult.setText(String.valueOf(op1));
            textInput.setText(String.valueOf(tg));
        } else {
            op2 = 0;
            tvResult.setText(String.valueOf(op2));
            textInput.setText(String.valueOf(op1));
        }
    }

    private void removeDigit() {
        if (state == 1) {
            op1 = op1 / 10;
            tvResult.setText(String.valueOf(op1));
            textInput.setText(String.valueOf(tg));
        } else {
            op2 = op2 / 10;
            tvResult.setText(String.valueOf(op2));
            textInput.setText(String.valueOf(op1));
        }
    }

    private void reverseOperand() {
        if (state == 1) {
            op1 = -op1;
            tvResult.setText(String.valueOf(op1));
        } else {
            op2 = -op2;
            tvResult.setText(String.valueOf(op2));
        }
    }








    private void calcResult() {
        double result = 0;
        switch (op) {
            case 1: result = op1 + op2; break;
            case 2: result = op1 - op2; break;
            case 3: result = op1 * op2; break;
            case 4: result = op1 / op2; break;
        }
        tvResult.setText(String.valueOf(result));
        if (op==1){
            textInput.setText(String.valueOf(op1)+'+'+String.valueOf(op2)+'=');
        }
        if (op==2){
            textInput.setText(String.valueOf(op1)+'-'+String.valueOf(op2)+'=');
        }
        if (op==3){
            textInput.setText(String.valueOf(op1)+'*'+String.valueOf(op2)+'=');
        }
        else {
            textInput.setText(String.valueOf(op1)+'/'+String.valueOf(op2)+'=');
        }
        state = 1;
        op1 = op2 = 0;
        op = 0;

    }

    private void selectOperator(int p) {
        op = p;
        state = 2;

        op2 = 0;
        tvResult.setText(String.valueOf(op2));
        if (op==1){
            textInput.setText(String.valueOf(op1)+'+');
        }
        if (op==2){
            textInput.setText(String.valueOf(op1)+'-');
        }
        if (op==3){
            textInput.setText(String.valueOf(op1)+'*');
        }
        else {
            textInput.setText(String.valueOf(op1)+'/');
        }
    }
//
    private void addValue(int c) {
        if (state == 1) {
            op1 = op1 * 10 + c;
            tvResult.setText(String.valueOf(op1));
        } else {
            op2 = op2 * 10 + c;
            tvResult.setText(String.valueOf(op2));
        }
    }
}
