package com.afayp.util.utils;

import android.app.Activity;

import java.util.LinkedList;
import java.util.List;


public class ActivityManagerUtil {

    private List<Activity> mActivityList = new LinkedList<Activity>();
    private static ActivityManagerUtil instance;

    private ActivityManagerUtil(){}

    public static ActivityManagerUtil getInstance(){
        if(instance==null){
            instance=new ActivityManagerUtil();
        }
        return instance;
    }
    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity){
        if (activity != null){
            mActivityList.add(activity);
        }
    }

    /**
     *移除Activity从堆栈
     */
    public void removeActivity(Activity activity){
        if (activity != null){
            mActivityList.remove(activity);
        }
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity){
        if(activity!=null){
            if (mActivityList.contains(activity)){
                mActivityList.remove(activity);
            }
            activity.finish();
            activity=null;
        }
    }

    /**
     *通过类名结束指定Activity
     */
    public void finishActivityByClass(Class<?> cls){
        Activity tempActivity = null;
        for (Activity activity : mActivityList) {
            if (activity.getClass().equals(cls)) {
                tempActivity = activity;
            }
        }
        finishActivity(tempActivity);
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity(){
        while(mActivityList.size() > 0) {
            Activity activity = mActivityList.get(mActivityList.size() - 1);
            mActivityList.remove(mActivityList.size() - 1);
            activity.finish();
        }
    }
}
