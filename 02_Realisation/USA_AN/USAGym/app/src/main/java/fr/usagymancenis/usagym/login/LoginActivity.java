package fr.usagymancenis.usagym.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fr.usagymancenis.usagym.R;
import fr.usagymancenis.usagym.account.NewAccountFirstActivity;


public class LoginActivity extends Activity {


    private Button mNewUser, mOtherUsers, mLoginNoAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mOtherUsers = (Button) findViewById(R.id.login_other_users);
        mOtherUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open a dialog to present user save
                // TODO
            }
        });

        mLoginNoAccount = (Button) findViewById(R.id.login_no_account);
        mLoginNoAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start dashbord page
                // TODO
            }
        });

        mNewUser = (Button) findViewById(R.id.login_new_user);
        mNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the new activity to create a user
                // TODO
                Intent intent = new Intent(LoginActivity.this, NewAccountFirstActivity.class);
                startActivity(intent);
            }
        });

    }

}
