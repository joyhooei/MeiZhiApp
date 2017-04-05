package com.hola.notification;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/4/5.
 */

public class NotificationBroadcastReceiver extends BroadcastReceiver {

    public static final String TYPE = "type";
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        int type = intent.getIntExtra(TYPE,-1);

        /**
         * 跳转到MainActivity
         */
        Intent newIntent = new Intent(context,MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(newIntent);


        /**
         * 清楚通知栏信息
         */
//        if(type != -1){
//            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//            notificationManager.cancel(type);
//        }
//        if(action.equals("notification_clicked")){
//            Toast.makeText(context.getApplicationContext(),"click",Toast.LENGTH_SHORT).show();
//        }
//        if(action.equals("notification_cancelled")){
//            Toast.makeText(context.getApplicationContext(),"cancel",Toast.LENGTH_SHORT).show();
//        }
    }
}
