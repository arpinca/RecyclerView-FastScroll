package com.simplecityapps.recyclerview_fastscroll.sample.activity;

import android.content.Context;
import android.preference.PreferenceManager;

import com.simplecityapps.recyclerview_fastscroll.sample.R;

public class PrefsUtils {
    public static int getItemCount(Context context) {
        return Integer.parseInt(
                PreferenceManager.getDefaultSharedPreferences(context)
                .getString(SettingsActivity.PREFS_KEY_ITEM_COUNT,
                        context.getResources().getString(R.string.prefs_item_count_default)));
    }
}
