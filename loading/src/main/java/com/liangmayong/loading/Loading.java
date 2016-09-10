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
    public static void showLoading(FragmentActivity activity) {
        showLoading(activity, "", -1, -1, 0.0f);
    }

    /**
     * showLoading
     *
     * @param activity activity
     * @param label    label
     */
    public static void showLoading(FragmentActivity activity, String label) {
        showLoading(activity, label, -1, -1, 0.0f);
    }

    /**
     * showLoading
     *
     * @param activity        activity
     * @param label           label
     * @param backgroundColor backgroundColor
     * @param labelColor      labelColor
     */
    public static void showLoading(FragmentActivity activity, String label, int loadingColor, int backgroundColor, float dimAmount) {
        try {
            DialogFragment loadingFragment = (DialogFragment) activity.getSupportFragmentManager()
                    .findFragmentByTag(TAG);
            loadingFragment = loadingFragment == null ? new LoadingFragment() : loadingFragment;
            ((LoadingFragment) loadingFragment).setLabel(label);
            ((LoadingFragment) loadingFragment).setLoadingColor(loadingColor);
            ((LoadingFragment) loadingFragment).setBackgroundColor(backgroundColor);
            ((LoadingFragment) loadingFragment).setDimAmount(dimAmount);
            if (loadingFragment.isAdded()) {
                activity.getSupportFragmentManager().beginTransaction().show(loadingFragment).commit();
            } else {
                loadingFragment.show(activity.getSupportFragmentManager(), TAG);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
                activity.getSupportFragmentManager().beginTransaction().remove(loadingFragment).commit();
            }
        } catch (Exception e) {
        }
    }

}
