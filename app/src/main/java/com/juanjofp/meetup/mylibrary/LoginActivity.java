package com.juanjofp.meetup.mylibrary;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.juanjofp.meetup.mylibrary.helpers.Credentials;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPasswd;
    private Button btSubmit;

    public static Intent newActivity(Context ctx) {
        return new Intent(ctx, LoginActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText)findViewById(R.id.etUsernameLoginActivity);
        etPasswd = (EditText)findViewById(R.id.etPasswordLoginActivity);

        btSubmit = (Button)findViewById(R.id.btSubmitLoginActivity);
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doLogin();
            }
        });
        setResult(RESULT_CANCELED);
    }

    private void doLogin() {
        btSubmit.setEnabled(false);

        CharSequence username = etUsername.getText().toString();
        CharSequence pwd = etPasswd.getText().toString();

        // TODO: Check valid user and passwd
        if(TextUtils.isEmpty(username)) {
            etUsername.setError(getString(R.string.invalid_username));
            btSubmit.setEnabled(true);
            return;
        }

        if(pwd.length() < 6) {
            etPasswd.setError(getString(R.string.invalid_password));
            btSubmit.setEnabled(true);
            return;
        }
        // TODO: request to ws

        if(username.toString().equals("juanjo") && pwd.toString().equals("123456")) {
            Credentials.saveToken(this, "supertokenobtenidodelws");
            setResult(RESULT_OK);
            finish();
        }
        else {
            etUsername.setError(getString(R.string.invalid_credentials));
            btSubmit.setEnabled(true);
        }
    }
}
