package com.juanjofp.meetup.mylibrary.helpers;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by Juanjo on 19/5/17.
 */

public class Credentials {

    private static final String CREDENTIALS_PREF = "credentials";
    private static final String TOKEN = "token";

    public static boolean isLogin(Activity actv) {
        SharedPreferences sp = actv.getSharedPreferences(CREDENTIALS_PREF, Activity.MODE_PRIVATE);
        return sp.getString(TOKEN, null) != null;
    }

    public static boolean saveToken(Activity actv, String token) {
        // TODO: Check valid token...
        SharedPreferences sp = actv.getSharedPreferences(CREDENTIALS_PREF, Activity.MODE_PRIVATE);
        SharedPreferences.Editor spEditor = sp.edit();
        spEditor.putString(TOKEN, token);
        return spEditor.commit();
    }
}
