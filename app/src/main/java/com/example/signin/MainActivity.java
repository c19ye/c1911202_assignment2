package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText email, pass;
    private Button btn;
    private String _email,_pass;
    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        email=(EditText) findViewById(R.id.txtEmail);
        pass=(EditText) findViewById(R.id.txtPassword);
        btn=(Button) findViewById(R.id.btnSignin);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                _email=email.getText().toString();
                _pass=pass.getText().toString();

                if (!TextUtils.isEmpty(_email) && !TextUtils.isEmpty(_pass)){
                   if (isValidEmail(_email) == true){
                       Toast.makeText(MainActivity.this, "Valid E-mail", Toast.LENGTH_SHORT).show();

                   }else{
                       Toast.makeText(MainActivity.this, "Invalid E-mail!", Toast.LENGTH_SHORT).show();

                   }
                }else{
                    Toast.makeText(MainActivity.this, "E-mail or password is empty!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


}