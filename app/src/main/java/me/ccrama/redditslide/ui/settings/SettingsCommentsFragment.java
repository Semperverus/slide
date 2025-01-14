package me.ccrama.redditslide.ui.settings;

import android.app.Activity;
import android.widget.TextView;

import androidx.appcompat.widget.SwitchCompat;

import ltd.ucode.slide.R;
import ltd.ucode.slide.SettingValues;

public class SettingsCommentsFragment {

    private final Activity context;

    public SettingsCommentsFragment(Activity context) {
        this.context = context;
    }

    public void Bind() {
        final SwitchCompat commentsCropImageSwitch = context.findViewById(R.id.settings_comments_cropImage);
        final SwitchCompat commentsColorDepthSwitch = context.findViewById(R.id.settings_comments_colorDepth);
        final SwitchCompat commentsHighlightOpColorSwitch = context.findViewById(R.id.settings_comments_highlightOpColor);
        final SwitchCompat commentsWideDepthSwitch = context.findViewById(R.id.settings_comments_wideDepth);
        final SwitchCompat commentsShowCreateFabSwitch = context.findViewById(R.id.settings_comments_showCreateFab);
        final SwitchCompat commentsRightHandedCommentsSwitch = context.findViewById(R.id.settings_comments_rightHandedComments);
        final SwitchCompat commentsUpvotePercentSwitch = context.findViewById(R.id.settings_comments_upvotePercent);
        final SwitchCompat commentsColoredTimeBubbleSwitch = context.findViewById(R.id.settings_comments_coloredTimeBubble);
        final SwitchCompat commentsHideAwardsSwitch = context.findViewById(R.id.settings_comments_hideAwards);

        final SwitchCompat commentsParentCommentNavSwitch = context.findViewById(R.id.settings_comments_parentCommentNav);
        final TextView commentsAutohideNavbarView = context.findViewById(R.id.settings_comments_autohideCommentNavbarView);
        final SwitchCompat commentsAutohideNavbarSwitch = context.findViewById(R.id.settings_comments_autohideCommentNavbar);
        final TextView commentsShowCollapseExpandView = context.findViewById(R.id.settings_comments_showCollapseExpandView);
        final SwitchCompat commentsShowCollapseExpandSwitch = context.findViewById(R.id.settings_comments_showCollapseExpand);
        final SwitchCompat commentsVolumeNavCommentsSwitch = context.findViewById(R.id.settings_comments_volumeNavComments);
        final SwitchCompat commentsNavbarVoteGesturesSwitch = context.findViewById(R.id.settings_comments_navbarVoteGestures);

        final SwitchCompat commentsSwapLongpressTapSwitch = context.findViewById(R.id.settings_comments_swapLongpressTap);
        final SwitchCompat commentsFullCollapseSwitch = context.findViewById(R.id.settings_comments_fullCollapse);
        final SwitchCompat commentsCollapseChildCommentsSwitch = context.findViewById(R.id.settings_comments_collapseChildComments);
        final SwitchCompat commentsCollapseDeletedCommentsSwitch = context.findViewById(R.id.settings_comments_collapseDeletedComments);

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//* Display */
        commentsCropImageSwitch.setChecked(SettingValues.cropImage);
        commentsCropImageSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SettingValues.cropImage = isChecked;
            SettingValues.editBoolean(SettingValues.PREF_CROP_IMAGE, isChecked);
        });
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        commentsColorDepthSwitch.setChecked(SettingValues.colorCommentDepth);
        commentsColorDepthSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SettingValues.colorCommentDepth = isChecked;
            SettingValues.editBoolean(SettingValues.PREF_COLOR_COMMENT_DEPTH, isChecked);
        });
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        commentsHighlightOpColorSwitch.setChecked(SettingValues.highlightCommentOP);
        commentsHighlightOpColorSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SettingValues.highlightCommentOP = isChecked;
            SettingValues.editBoolean(SettingValues.PREF_HIGHLIGHT_COMMENT_OP, isChecked);
        });
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        commentsWideDepthSwitch.setChecked(SettingValues.largeDepth);
        commentsWideDepthSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SettingValues.largeDepth = isChecked;
            SettingValues.editBoolean(SettingValues.PREF_LARGE_DEPTH, isChecked);
        });
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        commentsShowCreateFabSwitch.setChecked(SettingValues.fabComments);
        commentsShowCreateFabSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SettingValues.fabComments = isChecked;
            SettingValues.editBoolean(SettingValues.PREF_COMMENT_FAB, isChecked);
        });
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        commentsRightHandedCommentsSwitch.setChecked(SettingValues.rightHandedCommentMenu);
        commentsRightHandedCommentsSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SettingValues.rightHandedCommentMenu = isChecked;
            SettingValues.editBoolean(SettingValues.PREF_RIGHT_HANDED_COMMENT_MENU, isChecked);
        });
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        commentsUpvotePercentSwitch.setChecked(SettingValues.upvotePercentage);
        commentsUpvotePercentSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SettingValues.upvotePercentage = isChecked;
            SettingValues.editBoolean(SettingValues.PREF_UPVOTE_PERCENTAGE, isChecked);
        });
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        commentsColoredTimeBubbleSwitch.setChecked(SettingValues.highlightTime);
        commentsColoredTimeBubbleSwitch.setEnabled(SettingValues.INSTANCE.getCommentLastVisit());
        commentsColoredTimeBubbleSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SettingValues.highlightTime = isChecked;
            SettingValues.editBoolean(SettingValues.PREF_HIGHLIGHT_TIME, isChecked);
        });
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        commentsHideAwardsSwitch.setChecked(SettingValues.hideCommentAwards);
        commentsHideAwardsSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SettingValues.hideCommentAwards = isChecked;
            SettingValues.editBoolean(SettingValues.PREF_HIDE_COMMENT_AWARDS, isChecked);
        });

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//* Navigation */
        commentsParentCommentNavSwitch.setChecked(SettingValues.fastscroll);
        commentsParentCommentNavSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SettingValues.fastscroll = isChecked;
            SettingValues.editBoolean(SettingValues.PREF_FASTSCROLL, isChecked);

            //Disable autohidenav and showcollapseexpand if commentNav isn't checked
            if (!isChecked) {
                commentsAutohideNavbarSwitch.setEnabled(false);
                commentsAutohideNavbarSwitch.setChecked(SettingValues.commentAutoHide);
                commentsAutohideNavbarView.setAlpha(0.25f);
                commentsShowCollapseExpandSwitch.setEnabled(false);
                commentsShowCollapseExpandSwitch.setChecked(SettingValues.commentAutoHide);
                commentsShowCollapseExpandView.setAlpha(0.25f);
            } else {
                commentsAutohideNavbarSwitch.setEnabled(true);
                commentsAutohideNavbarView.setAlpha(1f);
                commentsShowCollapseExpandSwitch.setEnabled(true);
                commentsShowCollapseExpandView.setAlpha(1f);
            }
        });
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        commentsAutohideNavbarSwitch.setChecked(SettingValues.commentAutoHide);
        if (!commentsParentCommentNavSwitch.isChecked()) {
            commentsAutohideNavbarSwitch.setEnabled(false);
            commentsAutohideNavbarView.setAlpha(0.25f);
        }
        commentsAutohideNavbarSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SettingValues.commentAutoHide = isChecked;
            SettingValues.editBoolean(SettingValues.PREF_AUTOHIDE_COMMENTS, isChecked);
        });
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        commentsShowCollapseExpandSwitch.setChecked(SettingValues.showCollapseExpand);
        if (!commentsParentCommentNavSwitch.isChecked()) {
            commentsShowCollapseExpandSwitch.setEnabled(false);
            commentsShowCollapseExpandView.setAlpha(0.25f);
        }
        commentsShowCollapseExpandSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SettingValues.showCollapseExpand = isChecked;
            SettingValues.editBoolean(SettingValues.PREF_SHOW_COLLAPSE_EXPAND, isChecked);
        });
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        commentsVolumeNavCommentsSwitch.setChecked(SettingValues.commentVolumeNav);
        commentsVolumeNavCommentsSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SettingValues.commentVolumeNav = isChecked;
            SettingValues.editBoolean(SettingValues.PREF_COMMENT_NAV, isChecked);
        });
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        commentsNavbarVoteGesturesSwitch.setChecked(SettingValues.voteGestures);
        commentsNavbarVoteGesturesSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SettingValues.voteGestures = isChecked;
            SettingValues.editBoolean(SettingValues.PREF_VOTE_GESTURES, isChecked);
        });

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//* Collapse actions */
        commentsSwapLongpressTapSwitch.setChecked(SettingValues.swap);
        commentsSwapLongpressTapSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SettingValues.swap = isChecked;
            SettingValues.editBoolean(SettingValues.PREF_SWAP, isChecked);
        });
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        commentsFullCollapseSwitch.setChecked(SettingValues.collapseComments);
        commentsFullCollapseSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SettingValues.collapseComments = isChecked;
            SettingValues.editBoolean(SettingValues.PREF_COLLAPSE_COMMENTS, isChecked);
        });
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        commentsCollapseChildCommentsSwitch.setChecked(SettingValues.collapseCommentsDefault);
        commentsCollapseChildCommentsSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SettingValues.collapseCommentsDefault = isChecked;
            SettingValues.editBoolean(SettingValues.PREF_COLLAPSE_COMMENTS_DEFAULT, isChecked);
        });
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        commentsCollapseDeletedCommentsSwitch.setChecked(SettingValues.collapseDeletedComments);
        commentsCollapseDeletedCommentsSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SettingValues.collapseDeletedComments = isChecked;
            SettingValues.editBoolean(SettingValues.PREF_COLLAPSE_DELETED_COMMENTS, isChecked);
        });
    }
}
