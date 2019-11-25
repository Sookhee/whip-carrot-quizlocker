package kr.hs.emirim.shookhee.quizlocker;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

public class SaveSharedPreference {

    public static int PREF_LEVEL= 1;

    static SharedPreferences getSharedPreferences(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public static int getPrefLevel(Context ctx) {
        return PREF_LEVEL;
    }

    public static void setPrefLevel(Context ctx) {

        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putInt("PREF_LEVEL", PREF_LEVEL+1);
        editor.commit();
    }


}
