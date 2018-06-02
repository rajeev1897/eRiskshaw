package com.parse.starter;

import android.app.Activity;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by rajeev on 31/05/2018.
 */

public class VechileSignupLayout {
    Activity activity;
    public  EditText signupNumberPlate,signupVechileName,signupModelNumber,signupLicenceNumber,signupVechileStatus;
    public LinearLayout vechileSignupLayout;

    public VechileSignupLayout(MainActivity mainActivity) {
        activity=mainActivity;
        getvechileSignupLayoutVariables();

    }

    public VechileSignupLayout() {
        getvechileSignupLayoutVariables();
    }

    public void getvechileSignupLayoutVariables()
    {
        vechileSignupLayout=(LinearLayout)activity.findViewById(R.id.vechileSignupLayout);
        signupNumberPlate=(EditText)activity.findViewById(R.id.signupNumberPlate);
        signupVechileName=(EditText)activity.findViewById(R.id.signupVechileName);
        signupModelNumber=(EditText)activity.findViewById(R.id.signupModelNumber);
        signupLicenceNumber=(EditText)activity.findViewById(R.id.signupLicenceNumber);
        signupVechileStatus=(EditText)activity.findViewById(R.id.signupVechileStatus);
    }
}
