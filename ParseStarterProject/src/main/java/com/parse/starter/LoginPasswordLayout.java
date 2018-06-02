package com.parse.starter;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by rajeev on 31/05/2018.
 */

public class LoginPasswordLayout {
    Activity activity;
    public LinearLayout loginPasswordLayout;
     public EditText loginPassword;
    public Button loginPasswordButton;
    public TextView signupPasswordUserText;

    public LoginPasswordLayout(MainActivity mainActivity) {
        activity=mainActivity;
        getLoginOtPLayoutVariables();
    }

    public LoginPasswordLayout() {
        getLoginOtPLayoutVariables();
    }

    public void getLoginOtPLayoutVariables() {

        loginPasswordLayout=(LinearLayout)activity.findViewById(R.id.loginPasswordLayout);
        loginPassword=(EditText)activity.findViewById(R.id.loginPassword);
        loginPasswordButton=(Button)activity.findViewById(R.id.loginPasswordButton);
        signupPasswordUserText=(TextView)activity.findViewById(R.id.signupPasswordUserText);

    }
    }
