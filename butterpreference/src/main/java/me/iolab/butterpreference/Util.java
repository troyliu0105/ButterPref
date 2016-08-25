package me.iolab.butterpreference;

import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

/**
 * Created by Troy on 2016/8/25.
 */

public final class Util {

    public static boolean isFragment(Object obj) {
        if (obj instanceof PreferenceFragment) {
            return true;
        } else if (obj instanceof PreferenceActivity) {
            return false;
        }
        throw new IllegalStateException(obj + "must be PreferenceFragment or PreferenceActivity");
    }

}
