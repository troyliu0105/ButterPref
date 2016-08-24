package me.iolab.butterpreference;

import android.content.Context;
import android.text.TextUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Troy on 2016/8/24.
 */

public class ButterPrefs {

    public static void bind(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        Method findPreference;
        Context context;
        try {
            findPreference = obj.getClass().getMethod("findPreference", CharSequence.class);
            findPreference.setAccessible(true);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        for (Field field : fields) {
            BindPref bindPref = field.getAnnotation(BindPref.class);
            if (bindPref != null) {
                String keyStr = getKeyStr(obj, bindPref);
                Object prefObj;
                try {
                    prefObj = findPreference.invoke(obj, keyStr);
                    field.set(obj, prefObj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static String getKeyStr(Object obj, BindPref bindPref) {
        Context context;
        String keyStr = bindPref.value();
        if (TextUtils.isEmpty(keyStr)) {
            int keyRes = bindPref.resId();
            if (keyRes == -1) {
                throw new IllegalArgumentException("must have a String key or StringRes key!");
            }
            try {
                //noinspection ConfusingArgumentToVarargsMethod
                Method getActicity = obj.getClass().getMethod("getActivity");
                getActicity.setAccessible(true);
                Object o = getActicity.invoke(obj);
                if (o instanceof Context) {
                    context = (Context) o;
                    keyStr = context.getString(keyRes);
                }
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return keyStr;
    }

}