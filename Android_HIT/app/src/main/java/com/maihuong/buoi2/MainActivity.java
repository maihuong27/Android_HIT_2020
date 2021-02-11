package com.maihuong.buoi2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    Button bntLogin;
    TextView tvKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ANHXA();

        bntLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = etName.getText().toString();
                Log.d("TAG", "ONCLICK: username = " + userName);
                tvKQ.setText( "User Name: " + userName);
                Toast.makeText(getBaseContext(), "ĐĂNG NHẬP THÀNH CÔNG", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void ANHXA(){
        etName = findViewById(R.id.edtEditText);
        bntLogin = findViewById(R.id.btnButton);
        tvKQ = findViewById(R.id.tvResult);
    }
}