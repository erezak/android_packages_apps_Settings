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

import android.content.Context;
import android.preference.SeekBarPreference;
import android.util.AttributeSet;

public class SeekBarWithSummaryPreference extends SeekBarPreference {

    private CharSequence mSummary;

    public SeekBarWithSummaryPreference(Context context) {
		super(context);
	}

	public SeekBarWithSummaryPreference(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
	}

	public SeekBarWithSummaryPreference(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

    /**
     * Returns the summary of this Preference.
     *
     * @return The summary.
     * @see #setSummary(CharSequence)
     */
    public CharSequence getSummary() {
        return mSummary;
    }
    /**
     * Sets the summary for this Preference with a CharSequence.
     *
     * @param summary The summary for the preference.
     */
    public void setSummary(CharSequence summary) {
        if (summary == null && mSummary != null || summary != null && !summary.equals(mSummary)) {
            mSummary = summary;
            notifyChanged();
        }
    }
}
