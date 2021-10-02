package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Path;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private enum Operator{none, add, minus, multiply, divide, eq}
    private double data1 = 0;
    private double data2 = 0;
    private Operator optr = Operator.none;
    private boolean hasDot = false;
    private boolean requireCleaning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickNumericalbtn(View view){

        int viewID = view.getId();
        EditText curtext = (EditText) findViewById(R.id.resultEdit);


        if(optr == optr.eq){
            optr = Operator.none;
            curtext.setText("");
        }

        if (requireCleaning){
            requireCleaning = false;
            curtext.setText("");
        }

        switch(viewID){
            case R.id.btn00:
                curtext.setText(curtext.getText()+"0");
                break;
            case R.id.btn01:
                curtext.setText(curtext.getText()+"1");
                break;
            case R.id.btn02:
                curtext.setText(curtext.getText()+"2");
                break;
            case R.id.btn03:
                curtext.setText(curtext.getText()+"3");
                break;
            case R.id.btn04:
                curtext.setText(curtext.getText()+"4");
                break;
            case R.id.btn05:
                curtext.setText(curtext.getText()+"5");
                break;
            case R.id.btn06:
                curtext.setText(curtext.getText()+"6");
                break;
            case R.id.btn07:
                curtext.setText(curtext.getText()+"7");
                break;
            case R.id.btn08:
                curtext.setText(curtext.getText()+"8");
                break;
            case R.id.btn09:
                curtext.setText(curtext.getText()+"9");
                break;
            case R.id.btnDot:
                if (!hasDot) {
                    curtext.setText(curtext.getText() + ".");
                    hasDot = true;
                }
                else{

                }
                break;
            default:
                curtext.setText("ERROR");
                Log.d("ERROR","ERROR; unkown button pressed");
                break;
        }

    }



    public void onClickFunctionbtn(View view){
        int pressId = view.getId();
        EditText curtext = (EditText)findViewById(R.id.resultEdit);
        requireCleaning = true;

        if (pressId == R.id.btnClear){
            optr = Operator.none;
            curtext.setText("");
            data1 = 0;
            data2 = 0;
            return;
        }
        String datatext = curtext.getText().toString();
        double num = datatext.length() > 0 ? Double.parseDouble(datatext): 0;

        if (optr == Operator.none){
            data1 = num;
            requireCleaning = true;
            switch (pressId){
                case R.id.btnResult:
                    optr = Operator.eq;
                    data1 = 0;
                    break;
                case R.id.btnAdd:
                    optr = Operator.add;
                    break;
                case R.id.btnMinus:
                    optr = Operator.minus;
                    break;
                case R.id.btnDivide:
                    optr = Operator.divide;
                    break;
                case R.id.btnMultiply:
                    optr = Operator.multiply;
                    break;
            }
        }
        else{
            double result = 0;
            data2 = num;

            switch(optr){
                case eq:

                    break;
                case add:
                    result = data1 + data2;
                    break;
                case minus:
                    result = data1 - data2;
                    break;
                case multiply:
                    result = data1*data2;
                    break;
                case divide:
                    result = data1/data2;
                    break;
            }
            data1 = result;
            optr = Operator.none;
            if((result - (int)result) != 0){
                curtext.setText(String.valueOf(result));

            }
            else{
                curtext.setText(String.valueOf((int)result));
            }
        }

    }



}