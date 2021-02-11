package com.maihuong.btvn2_clock;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvIn, tvOut;
    private String input = "", result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvIn = (TextView) findViewById(R.id.edtValue);
        tvOut = (TextView) findViewById(R.id.tvResult);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    public void ButtonCheck(View v) {
        Button button = (Button) v;
        String data = button.getText().toString();
        switch(data) {
            case "AC":
                input = "";
                tvIn.setText(input);
                tvOut.setText(input);
                break;
            case "C":
                if (input.length() > 0) {
                    String newInput = input.substring(0, input.length() - 1);
                    input = newInput;
                }
                tvIn.setText(input);
                break;
            case "=":
                result = input;
                tvIn.setText(input);
                Solve();
                break;
            case "x":
                input += "*";
                tvIn.setText(input);
                Solve();
                break;
            default:
                if (data == null) {
                    input = "";
                    tvIn.setText(input);
                }
                if (data.equals("+") || data.equals("-") || data.equals("/") || data.equals("%")) {
                    Solve();
                }
                input += data;
                tvIn.setText(input);
        }
    }

    public void Solve(){
        if(input.split("\\*").length == 2) {
            String number[] = input.split("\\*");
            try{
                double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input = mul + "";
                tvOut.setText(input);
            }catch (Exception e) {

            }
        }

        if(input.split("\\%").length == 2) {
            String number[] = input.split("\\%");
            try{
                double mul = Double.parseDouble(number[0]) % Double.parseDouble(number[1]);
                input = mul + "";
                tvOut.setText(input);
            }catch (Exception e) {

            }
        }

        if(input.split("\\-").length == 2) {
            String number[] = input.split("\\-");
            try{
                double acc = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                input = acc + "";
                tvOut.setText(input);
            }catch (Exception e) {

            }
        }

        if(input.split("\\+").length == 2) {
            String number[] = input.split("\\+");
            try{
                double add = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = add + "";
                tvOut.setText(input);
            }catch (Exception e) {

            }
        }

        if(input.split("\\/").length == 2) {
            String number[] = input.split("\\/");
            try{
                double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input = div + "";
                tvOut.setText(input);
            }catch (Exception e) {

            }
        }
    }
}