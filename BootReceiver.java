package com.irtwaa.water;
import android.content.*;
public class BootReceiver extends BroadcastReceiver { public void onReceive(Context c,Intent i){MainActivity.schedule(c);} }