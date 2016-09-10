package com.liangmayong.loading;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;

/**
 * Loading
 *
 * @author LiangMaYong
 * @version 1.0
 */
public class Loading {

    private static final String TAG = "LoadingFragment";

    /**
     * showLoading
     *
     * @param activity activity
     */
    public static void showLoading(FragmentActivity activity, String label) {
        try {
            DialogFragment loadingFragment = (DialogFragment) activity.getSupportFragmentManager()
                    .findFragmentByTag(TAG);
            loadingFragment = loadingFragment == null ? new LoadingFragment() : loadingFragment;
            ((LoadingFragment) loadingFragment).setLabel(label);
            if (loadingFragment.isAdded()) {
                activity.getSupportFragmentManager().beginTransaction().show(loadingFragment).commit();
            } else {
                loadingFragment.show(activity.getSupportFragmentManager(), TAG);
            }
        } catch (Exception e) {
        }
    }

    /**
     * cancelLoading
     *
     * @param activity activity
     */
    public static void cancelLoading(FragmentActivity activity) {
        try {
            DialogFragment loadingFragment = (DialogFragment) activity.getSupportFragmentManager()
                    .findFragmentByTag(TAG);
            if (loadingFragment != null) {
                activity.getSupportFragmentManager().beginTransaction().hide(loadingFragment).commit();
            }
        } catch (Exception e) {
        }
    }

}
