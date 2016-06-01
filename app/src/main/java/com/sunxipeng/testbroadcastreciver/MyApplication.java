package com.sunxipeng.testbroadcastreciver;

import android.app.Application;

/**
 * Created by Administrator on 2016/6/1.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

       /* Intent service = new Intent(this, NetworkStateReceiver.class);
        startService(service);*/

    }


}
