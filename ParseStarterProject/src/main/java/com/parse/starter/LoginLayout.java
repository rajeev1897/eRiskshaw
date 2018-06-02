package com.parse.starter;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by rajeev on 31/05/2018.
 */

public class LoginLayout {
    LinearLayout loginLayout;

    public Activity activity;
    public EditText loginPhoneNumber;
    public  TextView loginWithPassword;
    public  Button loginOTPGenerator;
    public TextView signupUserText;

    public LoginLayout(Activity mainActivity) {
       activity=mainActivity;
        getLoginLayoutVariables();
    }

    public LoginLayout() {
        getLoginLayoutVariables();
    }

    public void getLoginLayoutVariables() {
        loginLayout = (LinearLayout) activity.findViewById(R.id.loginLayout);
        loginPhoneNumber = (EditText) activity.findViewById(R.id.loginPhoneNumber);
        loginWithPassword = (TextView) activity.findViewById(R.id.loginWithPassword);
        loginOTPGenerator = (Button) activity.findViewById(R.id.loginOTPGenerator);
        signupUserText = (TextView) activity.findViewById(R.id.signupUserText);
        View.OnClickListener dummyHandler = null;
        loginWithPassword.setOnClickListener(dummyHandler);

        dummyHandler = new View.OnClickListener() {
            public void onClick(View view) {
                Log.i("listenere called","Listener called");
            }
        };


    }


    public void loginOTP(View view) {
        Log.i("listenere called","Listener called");
    }

    public void onClick(View view) {

    }
}
