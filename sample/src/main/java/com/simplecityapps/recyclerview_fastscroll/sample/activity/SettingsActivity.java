package com.simplecityapps.recyclerview_fastscroll.sample.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

import com.simplecityapps.recyclerview_fastscroll.sample.R;

public class SettingsActivity extends PreferenceActivity {
    public static final String PREFS_KEY_ITEM_COUNT = "prefs_count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }

    public static class SettingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
            updateCountSummary();
        }

        @Override
        public void onResume() {
            super.onResume();
            getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        }

        @Override
        public void onPause() {
            super.onPause();
            getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        }

        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            switch (key) {
                case PREFS_KEY_ITEM_COUNT:
                    updateCountSummary();
            }
        }

        private void updateCountSummary() {
            Preference prefs = findPreference(PREFS_KEY_ITEM_COUNT);
            String countStr = prefs.getSharedPreferences().getString(PREFS_KEY_ITEM_COUNT, getResources().getString(R.string.prefs_item_count_default));
            prefs.setSummary(String.format(getResources().getString(R.string.prefs_item_count_summary), countStr));
        }

    }
}
