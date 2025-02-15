package me.ccrama.redditslide.ui.settings;

import android.os.Bundle;

import com.mikepenz.aboutlibraries.LibsBuilder;
import com.mikepenz.aboutlibraries.ui.LibsSupportFragment;

import ltd.ucode.slide.ui.BaseActivityAnim;
import ltd.ucode.slide.R;

public class SettingsLibs extends BaseActivityAnim {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        applyColorTheme();
        setContentView(R.layout.activity_settings_libs);
        setupAppBar(R.id.toolbar, R.string.settings_about_libs, true, true);

        LibsSupportFragment fragment = new LibsBuilder()
                .supportFragment();
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.root_fragment, fragment)
                    .commit();
        }
    }
}
