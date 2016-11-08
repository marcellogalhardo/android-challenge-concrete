package br.com.marcellogalhardo.challenge.dagger.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;

@Module
public class PreferenceModule {

    @Provides
    @Reusable
    SharedPreferences providesSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

}