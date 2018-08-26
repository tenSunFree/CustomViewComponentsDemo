package com.example.administrator.customviewcomponentsdemo;

import android.app.Application;

public class GlobalVariable extends Application {

    public static boolean
            songListAlreadyClick = true, exclusiveAlreadyClick = false, exploreAlreadyClick = false,
            moreAlreadyClick = false;

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
