package com.example.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.model.Account;
import com.example.myapplication.db.*;
public class LoginActivity extends AppCompatActivity {
    private EditText edtUser, edtPass;
    private TextView register;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtUser = findViewById(R.id.edt_username);
        edtPass = findViewById(R.id.edt_password);
        edtPass.setTransformationMethod(new PasswordTransformationMethod());
        register = findViewById(R.id.register);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edtUser.getText().toString();
                String pass = edtPass.getText().toString();
                if(user.isEmpty() || pass.isEmpty()){
                    Toast.makeText(getBaseContext(), "Vui lòng nhập đủ thông tin!", Toast.LENGTH_SHORT).show();
                }
                else{
                    UserSQL userSQL = new UserSQL(getBaseContext());
                    if(userSQL.checkUserName(user)){
                        Toast.makeText(getBaseContext(), "Tên tài khoản không tồn tại!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Account account = userSQL.checkLogin(user, pass);
                        if(account == null){
                            Toast.makeText(getBaseContext(), "Sai thông tin đăng nhập!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            MainActivity.account = account;
                            Toast.makeText(getBaseContext(), "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(LoginActivity.this, MainActivity.class);
                            i.putExtra("account",account);
                            startActivityForResult(i, 1);
                        }
                    }
                }

            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(i, 1);
            }
        });
    }
}