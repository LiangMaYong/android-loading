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

    //defualt loadingColor
    private static int loadingColor = -1;
    //defualt backgroundColor
    private static int backgroundColor = -1;
    //defualt dimAmount
    private static float dimAmount = 0.0f;
    //defualt round
    private static int round = 20;
    //fragment tag
    private static final String TAG = "LoadingFragment";

    /**
     * setBackgroundColor
     *
     * @param backgroundColor backgroundColor
     */
    public static void setBackgroundColor(int backgroundColor) {
        Loading.backgroundColor = backgroundColor;
    }

    /**
     * setDimAmount
     *
     * @param dimAmount dimAmount
     */
    public static void setDimAmount(float dimAmount) {
        Loading.dimAmount = dimAmount;
    }

    /**
     * setLoadingColor
     *
     * @param loadingColor loadingColor
     */
    public static void setLoadingColor(int loadingColor) {
        Loading.loadingColor = loadingColor;
    }

    /**
     * setLoadingColor
     *
     * @param round round
     */
    public static void setRound(int round) {
        Loading.round = round;
    }

    /**
     * showLoading
     *
     * @param activity activity
     */
    public static LoadingFragment showLoading(FragmentActivity activity) {
        return showLoading(activity, "", loadingColor, backgroundColor, round, dimAmount);
    }

    /**
     * showLoading
     *
     * @param activity activity
     * @param label    label
     */
    public static LoadingFragment showLoading(FragmentActivity activity, String label) {
        return showLoading(activity, label, loadingColor, backgroundColor, round, dimAmount);
    }

    /**
     * showLoading
     *
     * @param activity        activity
     * @param label           label
     * @param backgroundColor backgroundColor
     * @param dimAmount       dimAmount
     */
    public static LoadingFragment showLoading(FragmentActivity activity, String label, int loadingColor, int backgroundColor,int round, float dimAmount) {
        try {
            synchronized (activity) {
                DialogFragment loadingFragment = (DialogFragment) activity.getSupportFragmentManager()
                        .findFragmentByTag(TAG);
                if (loadingFragment != null) {
                    ((LoadingFragment) loadingFragment).setLabel(label);
                    ((LoadingFragment) loadingFragment).setLoadingColor(loadingColor);
                    ((LoadingFragment) loadingFragment).setBackgroundColor(backgroundColor);
                    ((LoadingFragment) loadingFragment).setDimAmount(dimAmount);
                    ((LoadingFragment) loadingFragment).setRound(round);
                    if (loadingFragment.isAdded()) {
                        activity.getSupportFragmentManager().beginTransaction().show(loadingFragment).commit();
                    }
                } else {
                    loadingFragment = new LoadingFragment();
                    ((LoadingFragment) loadingFragment).setLabel(label);
                    ((LoadingFragment) loadingFragment).setLoadingColor(loadingColor);
                    ((LoadingFragment) loadingFragment).setBackgroundColor(backgroundColor);
                    ((LoadingFragment) loadingFragment).setDimAmount(dimAmount);
                    ((LoadingFragment) loadingFragment).setRound(round);
                    loadingFragment.show(activity.getSupportFragmentManager(), TAG);
                }
                return (LoadingFragment) loadingFragment;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
