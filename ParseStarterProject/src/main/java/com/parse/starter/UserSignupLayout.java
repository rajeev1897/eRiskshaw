package com.parse.starter;

import android.app.Activity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by rajeev on 31/05/2018.
 */

public class UserSignupLayout {
    Activity activity;
    TextView registerText;
   public EditText signupUsername,signupPassword,signupConfirmPassword,signupPhoneNumber,signupPincode;
     public LinearLayout userLoginLayout;

    public UserSignupLayout(MainActivity mainActivity) {
        activity=mainActivity;
        getuserSignupLayoutVariables();
    }

    public UserSignupLayout() {
        getuserSignupLayoutVariables();
    }

    public void getuserSignupLayoutVariables() {

        registerText=(TextView)activity.findViewById(R.id.registerText);


        userLoginLayout=(LinearLayout)activity.findViewById(R.id.userSignupLayout);
        signupUsername = (EditText) activity.findViewById(R.id.signupUsername);
        signupPassword = (EditText) activity.findViewById(R.id.signupPassword);
        signupConfirmPassword = (EditText)activity.findViewById(R.id.signupConfirmPassword);
        signupPhoneNumber = (EditText)activity.findViewById(R.id.signupPhoneNumber);
        signupPincode = (EditText)activity.findViewById(R.id.signupPincode);
    }

}
