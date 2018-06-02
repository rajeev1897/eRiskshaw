package com.parse.starter;

import android.app.Activity;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by rajeev on 01/06/2018.
 */

public class Visible {
    Activity activity;
    public Button registerButton,backButton;
   LinearLayout loginLayout,loginOTPLayout,loginPasswordLayout,userLoginLayout,vechileSignupLayout;
    LoginLayout loginlayout;
    LoginOTPLayout  loginOTPlayout;
    LoginPasswordLayout  loginPasswordlayout;
    UserSignupLayout userSignuplayout;
    VechileSignupLayout vechileSignuplayout;

    public Visible(MainActivity mainActivity) {
        activity=mainActivity;
        getButton();

    }
    public void getButton()
    {
        registerButton=(Button)activity.findViewById(R.id.registerButton);
        backButton=(Button)activity.findViewById(R.id.backButton);
        getInformation();
    }
    public void getInformation()
    {
        loginlayout=new LoginLayout();
        loginOTPlayout=new LoginOTPLayout();
        loginPasswordlayout=new LoginPasswordLayout();
        userSignuplayout=new UserSignupLayout();
        vechileSignuplayout=new VechileSignupLayout();;


        //   System.out.println("hai");
        loginLayout=loginlayout.loginLayout;
        loginOTPLayout=loginOTPlayout.loginOTPLayout;
        loginPasswordLayout=loginPasswordlayout.loginPasswordLayout;
        userLoginLayout=userSignuplayout.userLoginLayout;
        vechileSignupLayout=vechileSignuplayout.vechileSignupLayout;
    }


}
