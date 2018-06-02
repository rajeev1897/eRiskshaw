package com.parse.starter;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by rajeev on 31/05/2018.
 */

public class LoginOTPLayout {

    Activity activity;
    public LinearLayout loginOTPLayout;
    public EditText loginOTP;
    public Button loginOTPButton;
    public TextView signupOTPUserText;

    public LoginOTPLayout(MainActivity mainActivity) {
        activity=mainActivity;
        getLoginOtPLayoutVariables();
    }

    public LoginOTPLayout() {
        getLoginOtPLayoutVariables();
    }

    public void getLoginOtPLayoutVariables(){
        loginOTPLayout=(LinearLayout)activity.findViewById(R.id.loginOTPLayout);
        loginOTP=(EditText)activity.findViewById(R.id.loginOTP);
        loginOTPButton=(Button)activity.findViewById(R.id.loginOTPButton);
        signupOTPUserText=(TextView)activity.findViewById(R.id.signupOTPUserText);

    }
}
