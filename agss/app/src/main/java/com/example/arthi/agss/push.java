package com.example.arthi.agss;

import android.app.Application;



import com.parse.Parse;

import com.parse.ParseInstallation;



    public class push extends Application {

        @Override

        public void onCreate() {

            super.onCreate();

            Parse.initialize(this);

            ParseInstallation installation = ParseInstallation.getCurrentInstallation();

            // don't forget to change the line below with the sender ID you obtained at Firebase

            installation.put("GCMSenderId", "72398117876");

            installation.saveInBackground();



        }

    }

