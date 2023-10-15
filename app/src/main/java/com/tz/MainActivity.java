package com.tz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button Login;
    TextView username;
    TextView password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (TextView) findViewById(R.id.username);
        password = (TextView) findViewById(R.id.password);
        Login = (Button) findViewById(R.id.Login);

        findViewById(R.id.Login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(pass)) {   //*1.判断用户名或密码是否为空，如果是否，则下一步
                    if (name.equals("teio")) {         //*2.用户名为teio,判断用户名是否为teio，是则下一步
                        if (pass.equals("1234")) {     //*3.密码为1234，判断密码是否为1234，如果是则下一步
                            Intent intent = new Intent(MainActivity.this, tz2.class);  //如果以上都没问题，则进行页面跳转
                            startActivity(intent);

                        } else {
                            Toast.makeText(MainActivity.this, "密码错了罢", Toast.LENGTH_SHORT).show();//*3.如果密码不是1234，则弹窗提示密码错误
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "用户名错了罢", Toast.LENGTH_SHORT).show();//*2.如果用户名不是teio，则弹窗提示用户名错误
                    }
                } else {
                    Toast.makeText(MainActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();//*1.如果用户名或密码其中一个为空，则弹窗提示用户名或密码不能为空
                }
            }
        });
    }
}