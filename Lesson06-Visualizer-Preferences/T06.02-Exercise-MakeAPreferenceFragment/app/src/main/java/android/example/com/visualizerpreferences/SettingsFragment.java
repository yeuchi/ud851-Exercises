package android.example.com.visualizerpreferences;

/**
 * Created by ctyeung on 8/27/17.
 */

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.perf_visualizer);
    }
}
