package me.iolab.butterpreferencesample.settingacti;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.widget.Toast;

import me.iolab.butterpreference.BindPref;
import me.iolab.butterpreference.ButterPrefs;
import me.iolab.butterpreferencesample.R;

/**
 * Created by Troy on 2016/8/25.
 */

public class SettingAtivity extends PreferenceActivity implements Preference.OnPreferenceClickListener {

    @BindPref("test1")
    EditTextPreference test1;
    @BindPref("test2")
    CheckBoxPreference test2;
    @BindPref(resId = R.string.test3)
    EditTextPreference test3;
    @BindPref(resId = R.string.test4)
    CheckBoxPreference test4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);
        ButterPrefs.bind(this);
        test1.setOnPreferenceClickListener(this);
        test2.setOnPreferenceClickListener(this);
        test3.setOnPreferenceClickListener(this);
        test4.setOnPreferenceClickListener(this);
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        Toast.makeText(this, preference.getKey() + " isClicked", Toast.LENGTH_SHORT).show();
        return false;
    }
}
