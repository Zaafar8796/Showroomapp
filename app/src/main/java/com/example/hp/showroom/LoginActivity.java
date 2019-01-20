package com.example.hp.showroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button login;
    TextView signUpText, withoutLogin;
    EditText editEmail, editPassword;
    //String email, emailPattern;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        signUpText = findViewById(R.id.signUpText);
        signUpText.setOnClickListener(this);

        withoutLogin = findViewById(R.id.withoutLogin);
        withoutLogin.setOnClickListener(this);

        editEmail = findViewById(R.id.editEmail);

        login = findViewById(R.id.login);
        login.setOnClickListener(this);

        editPassword = findViewById(R.id.editPassword);


    }

    @Override
    public void onClick(View view) {

        String email = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString();

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        switch (view.getId()) {

            case R.id.login:

                String editemail = editEmail.getText().toString();
                String editpassword = editPassword.getText().toString();

                if (email.isEmpty()) {
                    editEmail.requestFocus();
                    editEmail.setError("Email Required");
                } else if (!email.matches(emailPattern)) {

                    editEmail.requestFocus();
                    editEmail.setError("Invalid Email");
                } else if (email.matches(emailPattern) && password.isEmpty()) {
                    editPassword.requestFocus();
                    editPassword.setError("Password is required");
                } else {

//                    List<User> list = User.find(User.class,
//                            "email = ? and password = ?",
//                            editemail, editpassword);
//                    if (list.size() > 0) {
//                        //progressDialog.dismiss();
//                        startActivity(new Intent(this, CarListActivity.class));
//                        finish();
//                    } else {
//                        //progressDialog.dismiss();
//                        Toast.makeText(this, "User not found please Sign UP!", Toast.LENGTH_SHORT).show();
//                    }

//                    User useremail = (User) User.find(User.class, "email = ?",editemail);
//                    User userpassword = (User) User.find(User.class, "password = ?",editpassword);
//
//                    if(useremail != null && editemail.matches(String.valueOf(useremail))&& editpassword.matches(String.valueOf(userpassword))){
//                        Intent intent = new Intent(this, CarListActivity.class);
//                        startActivity(intent);
//                    }
//                    else{
//                        Toast.makeText(this, "Invalid email or password", Toast.LENGTH_LONG).show();
//                    }
                    Intent intent = new Intent(this, CarListActivity.class);
                    startActivity(intent);


                }
                break;

            case R.id.signUpText:
                Intent intent1 = new Intent(this, SignUpActivity.class);
                startActivity(intent1);

                break;

            case R.id.withoutLogin:
                Intent intent4 = new Intent(this, CarListActivity.class);
                startActivity(intent4);
        }
    }


}