package com.aariyan.faster.Common;


import android.content.Context;
import android.content.SharedPreferences;
import android.view.Window;
import android.view.WindowManager;

//Here will all the Common variable, method and so on:
//that will be usable from any classes:
//Definitely most of the value will be declared in Static format with Public AccessModifier:
public class Common {


    //Key for checking the OnBoarding Screen:
    public static String onBoardingCompletedStatus = "OnBoardingStatus";

    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;
    public static String DEFAULT_VAL = "N/A";


    public static String AuthenticationType = "";

}
