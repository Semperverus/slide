package me.ccrama.redditslide.ui.settings;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import java.io.File;

import ltd.ucode.slide.ui.BaseActivityAnim;
import me.ccrama.redditslide.Fragments.FolderChooserDialogCreate;
import ltd.ucode.slide.R;

/**
 * Created by ccrama on 3/5/2015.
 */
public class SettingsGeneral extends BaseActivityAnim
        implements FolderChooserDialogCreate.FolderCallback {

    private SettingsGeneralFragment fragment = new SettingsGeneralFragment(this);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        applyColorTheme();
        setContentView(R.layout.activity_settings_general);
        setupAppBar(R.id.toolbar, R.string.settings_title_general, true, true);

        ((ViewGroup) findViewById(R.id.settings_general)).addView(
                getLayoutInflater().inflate(R.layout.activity_settings_general_child, null));

        fragment.Bind();
    }

    @Override
    public void onFolderSelection(@NonNull FolderChooserDialogCreate dialog,
                                  @NonNull File folder, boolean isSaveToLocation) {
        fragment.onFolderSelection(dialog, folder, false);
    }

    @Override
    public void onFolderChooserDismissed(@NonNull FolderChooserDialogCreate dialog) {
    }

    @Override
    public void onResume(){
        super.onResume();
        SettingsGeneralFragment.doNotifText(this);
    }
}
