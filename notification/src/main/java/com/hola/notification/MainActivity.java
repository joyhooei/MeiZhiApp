package com.hola.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

//    @BindView(R.id.show_botificationBtn)
//    Button BtnShow;

   @OnClick(R.id.show_botificationBtn) void showNotification(){
       Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_SHORT).show();
       Intent intentClick = new Intent(this,NotificationBroadcastReceiver.class);
       intentClick.setAction("notification_clicked");
       int type = 1;
       intentClick.putExtra(NotificationBroadcastReceiver.TYPE,type);
       PendingIntent pendingIntentClick = PendingIntent.getBroadcast(this,0,intentClick,PendingIntent.FLAG_ONE_SHOT);

       Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
       Intent intentCancel = new Intent(this,NotificationBroadcastReceiver.class);
       intentCancel.setAction("notification_cancelled");
       intentCancel.putExtra(NotificationBroadcastReceiver.TYPE,type);
       PendingIntent pendingIntentCancel = PendingIntent.getBroadcast(this,0,intentCancel,PendingIntent.FLAG_ONE_SHOT);

       NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
       NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
       Notification notification = builder
               .setContentTitle("这是通知栏标题")
               .setContentText("这是通知内容")
               .setWhen(System.currentTimeMillis())
               .setSmallIcon(R.mipmap.ic_launcher)
               .setSound(defaultSoundUri)
               .setContentIntent(pendingIntentClick)
               .setDeleteIntent(pendingIntentCancel)
               .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
               .setColor(Color.parseColor("#EAA935"))
               .build();
       manager.notify(type,notification);
   }



}
