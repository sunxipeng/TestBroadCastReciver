package com.sunxipeng.testbroadcastreciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/6/1.
 */
public class NetworkStateReceiver extends BroadcastReceiver {

    private static final String TAG = "NetworkStateReceiver";

    private static boolean netuse = false;
    //static NetChange mNetChange;

   // private static Map mdata = new HashMap();


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "network state changed.");
        if (!isNetworkAvailable(context)/*&&(!netuse)*/) {

            Toast.makeText(context, "网络不可用!", Toast.LENGTH_SHORT).show();
            netuse = true;

           // notifyall();

        }else if(isNetworkAvailable(context)){

            Toast.makeText(context, "网络可用!", Toast.LENGTH_SHORT).show();
            netuse = false;
           // mNetChange.changetouse();
        }

    }

    /**
     * 网络是否可用
     *
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager mgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] info = mgr.getAllNetworkInfo();
        if (info != null) {
            for (int i = 0; i < info.length; i++) {
                if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

   /* public static void register(String name,NetChange netChange){

        //添加进集合
        mNetChange = netChange;
        mdata.put(name, netChange);

    }

    public static void unregister(String name){
        //从集合中移除
        mdata.remove(name);

    }

    public static void notifyall(){
        //遍历集合
        mNetChange.changetonouse();
    }

    public interface NetChange{

        void changetonouse();

        void changetouse();
    }*/
}