/*
 * Copyright (C) 2012 Erez A. Korn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.erez;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.preference.SeekBarPreference;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;
import android.util.Log;
import android.widget.Toast;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.Utils;
import com.android.settings.erez.SeekBarWithSummaryPreference;

public class SapirSettings extends SettingsPreferenceFragment implements OnPreferenceChangeListener {

    private static final String FORCE_TABLET_MODE_PREF_KEY = "force_tablet_mode";

    private CheckBoxPreference mPrefForceTabletMode;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.sapir_settings);

        PreferenceScreen prefSet = getPreferenceScreen();

        mPrefForceTabletMode = (CheckBoxPreference) prefSet.findPreference(FORCE_TABLET_MODE_PREF_KEY);

        mPrefForceTabletMode.setChecked((Settings.System.getInt(getActivity().getApplicationContext().getContentResolver(),
                Settings.System.FORCE_TABLET_UI, 0) == 1));

    }

    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        boolean value;

        if (preference == mPrefForceTabletMode) {
            value = mPrefForceTabletMode.isChecked();
            Settings.System.putInt(getActivity().getApplicationContext().getContentResolver(),
                    Settings.System.FORCE_TABLET_UI, value ? 1 : 0);
            Toast.makeText(getActivity(), R.string.force_tablet_mode_reboot_message, Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }

	@Override
	public boolean onPreferenceChange(Preference preference, Object newValue) {
		return false;
	}
}
