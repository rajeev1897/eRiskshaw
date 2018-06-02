/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.LogInCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    LinearLayout loginLayout,loginOTPLayout,loginPasswordLayout,userSignupLayout,vechileSignupLayout;
    Boolean flag=true,check=false;
    ImageView logoImage;


    public  EditText loginOTP,loginPhoneNumber,loginPassword;
    public  EditText signupUsername,signupPassword,signupConfirmPassword,signupPhoneNumber,signupPincode,signupNumberPlate,signupVechileName;
    public  EditText signupModelNumber,signupLicenceNumber,signupVechileStatus;
    public TextView signupOTPUserText,loginWithPassword,signupUserText,signupPasswordUserText,registerText;
    public Button loginOTPButton,loginOTPGenerator,loginPasswordButton,registerButton,backButton;
     /*
    public void loginOTP(View view)
    {

       getDriver();

    }   */

    public void getLoginOTPLayout(){
        if(check) {
            logoImage.setVisibility(View.VISIBLE);
            loginLayout.setVisibility(View.INVISIBLE);
            loginOTPLayout.setVisibility(View.VISIBLE);
            backButton.setVisibility(View.VISIBLE);
            check=false;

        }
        else {
            Toast.makeText(this, "phone number doesnt exists", Toast.LENGTH_SHORT).show();
            check=false;
        }
    }

    public void loginPassword(View view)
    {
        logoImage.setVisibility(View.VISIBLE);
        loginLayout.setVisibility(View.INVISIBLE);
        loginPasswordLayout.setVisibility(View.VISIBLE);
        backButton.setVisibility(View.VISIBLE);
    }


    public void signupUserDetails(View view)
    {
        logoImage.setVisibility(View.INVISIBLE);
        loginLayout.setVisibility(View.INVISIBLE);
        loginPasswordLayout.setVisibility(View.INVISIBLE);
        loginOTPLayout.setVisibility(View.INVISIBLE);
        userSignupLayout.setVisibility(View.VISIBLE);
        registerButton.setVisibility(View.VISIBLE);
        registerText.setVisibility(View.VISIBLE);
        backButton.setVisibility(View.VISIBLE);

    }


    public void loginUser(View view)
    {
        loginOTPLayout.setVisibility(View.INVISIBLE);
        backButton.setVisibility(View.INVISIBLE);
        createDriver();
    }


    public void registerUser(View view)
    {

        if (registerButton.getText().equals("next") && signupPassword.getText().toString().equals(signupConfirmPassword.getText().toString()) )
        {
            logoImage.setVisibility(View.INVISIBLE);
            userSignupLayout.setVisibility(View.INVISIBLE);
            vechileSignupLayout.setVisibility(View.VISIBLE);
            registerButton.setText("Signup");
            backButton.setVisibility(View.VISIBLE);
        }

        else if(registerButton.getText().equals("Signup"))
        {
              logoImage.setVisibility(View.INVISIBLE);
            vechileSignupLayout.setVisibility(View.INVISIBLE);
            loginOTPLayout.setVisibility(View.VISIBLE);
            backButton.setVisibility(View.VISIBLE);
            registerButton.setVisibility(View.INVISIBLE);
            registerButton.setText("next");

        }
        else
        {
            Toast.makeText(this, "passwords and confirm password are not same", Toast.LENGTH_SHORT).show();
        }


    }



    public void createDriver()
    {

        ParseObject driver=new ParseObject("Driver");
        driver.put("username",signupUsername.getText().toString());
        driver.put("password",signupPassword.getText().toString());
        driver.put("confirmPassword",signupConfirmPassword.getText().toString());
        driver.put("phoneNumber",signupPhoneNumber.getText().toString());
        driver.put("pincode",signupPincode.getText().toString());
        driver.put("numberPlate",signupNumberPlate.getText().toString());
        driver.put("vechileName",signupVechileName.getText().toString());
        driver.put("modelNumber",signupModelNumber.getText().toString());
        driver.put("liceinceNumber",signupLicenceNumber.getText().toString());
        driver.put("vechileStatus",signupVechileStatus.getText().toString());

        driver.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e==null)
                {
                    Log.i("saveInbaground","successful");
                }
                else {
                    Log.i("saveInbaground","unsuccessful");
                }
            }
        });


    }

    public void getDriver()
    {
        ParseQuery<ParseObject> query=ParseQuery.getQuery("Driver");
        query.whereEqualTo("phoneNumber",loginPhoneNumber.getText().toString());
        query.setLimit(1);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e==null)
                {
                    Log.i("FindinBackGround","Retrived"+objects.size()+"objects");
                     if(objects.size()>0)
                     {
                         for(ParseObject object:objects)
                         {
                             Log.i("result",object.getString("username"));
                             check = true;

                         }
                         getLoginOTPLayout();
                     }
                }

            }
        });

    }

    @SuppressLint("WrongConstant")
    public void backRegister(View view) {

        if (loginOTPLayout.getVisibility() == 0 || loginPasswordLayout.getVisibility() == 0 || userSignupLayout.getVisibility() == 0) {
               logoImage.setVisibility(View.VISIBLE);
            loginLayout.setVisibility(View.VISIBLE);
            loginOTPLayout.setVisibility(View.INVISIBLE);
            loginPasswordLayout.setVisibility(View.INVISIBLE);
            userSignupLayout.setVisibility(View.INVISIBLE);
            vechileSignupLayout.setVisibility(View.INVISIBLE);
            registerText.setVisibility(View.INVISIBLE);
            registerButton.setVisibility(View.INVISIBLE);
            backButton.setVisibility(View.INVISIBLE);

        } else if (vechileSignupLayout.getVisibility() == 0)
        {
               logoImage.setVisibility(View.INVISIBLE);
            userSignupLayout.setVisibility(View.VISIBLE);
            vechileSignupLayout.setVisibility(View.INVISIBLE);
            registerButton.setText("next");
        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseUser.getCurrentUser().logOut();
        logoImage=(ImageView)findViewById(R.id.logoImage);

        loginLayout=(LinearLayout)findViewById(R.id.loginLayout);
        loginOTPLayout=(LinearLayout)findViewById(R.id.loginOTPLayout);
        loginPasswordLayout=(LinearLayout)findViewById(R.id.loginPasswordLayout);
        userSignupLayout=(LinearLayout)findViewById(R.id.userSignupLayout);
        vechileSignupLayout=(LinearLayout)findViewById(R.id.vechileSignupLayout);


        loginOTP=(EditText)findViewById(R.id.loginOTP);
        loginOTPButton=(Button)findViewById(R.id.loginOTPButton);
        signupOTPUserText=(TextView)findViewById(R.id.signupOTPUserText);


        loginPhoneNumber=(EditText)findViewById(R.id.loginPhoneNumber);
        loginWithPassword=(TextView)findViewById(R.id.loginWithPassword);
        loginOTPGenerator=(Button)findViewById(R.id.loginOTPGenerator);
        signupUserText=(TextView)findViewById(R.id.signupUserText);


        loginPassword=(EditText)findViewById(R.id.loginPassword);
        loginPasswordButton=(Button)findViewById(R.id.loginPasswordButton);
        signupPasswordUserText=(TextView)findViewById(R.id.signupPasswordUserText);


        signupUsername=(EditText)findViewById(R.id.signupUsername);
        signupPassword=(EditText)findViewById(R.id.signupPassword);
        signupConfirmPassword=(EditText)findViewById(R.id.signupConfirmPassword);
        signupPhoneNumber=(EditText)findViewById(R.id.signupPhoneNumber);
        signupPincode=(EditText)findViewById(R.id.signupPincode);


        signupNumberPlate=(EditText)findViewById(R.id.signupNumberPlate);
        signupVechileName=(EditText)findViewById(R.id.signupVechileName);
        signupModelNumber=(EditText)findViewById(R.id.signupModelNumber);
        signupLicenceNumber=(EditText)findViewById(R.id.signupLicenceNumber);
        signupVechileStatus=(EditText)findViewById(R.id.signupVechileStatus);

        registerText=(TextView)findViewById(R.id.registerText);

        registerButton=(Button)findViewById(R.id.registerButton);
        backButton=(Button)findViewById(R.id.backButton);


        ParseAnalytics.trackAppOpenedInBackground(getIntent());

    }


}

