package com.irtwaa.water;
import android.content.*;import android.app.*;import android.os.*;
public class ReminderReceiver extends BroadcastReceiver{
 public void onReceive(Context c,Intent i){int goal=c.getSharedPreferences("p",0).getInt("goal",5000);String date=new java.text.SimpleDateFormat("yyyy-MM-dd",java.util.Locale.US).format(new java.util.Date());WaterDb db=new WaterDb(c);if(db.total(date)>=goal)return;
 NotificationManager nm=(NotificationManager)c.getSystemService(Context.NOTIFICATION_SERVICE);if(Build.VERSION.SDK_INT>=26)nm.createNotificationChannel(new NotificationChannel("water","تذكير المياه",NotificationManager.IMPORTANCE_HIGH));
 Notification n=new Notification.Builder(c,"water").setSmallIcon(android.R.drawable.ic_dialog_info).setContentTitle("ارتواء").setContentText("حان وقت شرب بعض المياه 💧").setAutoCancel(true).build();nm.notify(11,n);}
}