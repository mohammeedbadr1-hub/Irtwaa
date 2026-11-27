package com.irtwaa.water;
import android.content.*; import android.database.*; import android.database.sqlite.*;
import java.util.*;
public class WaterDb extends SQLiteOpenHelper {
 public WaterDb(Context c){super(c,"water.db",null,1);}
 public void onCreate(SQLiteDatabase d){d.execSQL("CREATE TABLE drink(id INTEGER PRIMARY KEY AUTOINCREMENT, ts INTEGER, ml INTEGER)"); d.execSQL("CREATE TABLE day(date TEXT PRIMARY KEY,total INTEGER,goal INTEGER)");}
 public void onUpgrade(SQLiteDatabase d,int o,int n){}
 public long add(long ts,int ml){ContentValues v=new ContentValues();v.put("ts",ts);v.put("ml",ml);return getWritableDatabase().insert("drink",null,v);}
 public void del(long id){getWritableDatabase().delete("drink","id=?",new String[]{""+id});}
 public int total(String date){Cursor c=getReadableDatabase().rawQuery("SELECT COALESCE(SUM(ml),0) FROM drink WHERE date(ts/1000,'unixepoch','localtime')=?",new String[]{date});c.moveToFirst();int n=c.getInt(0);c.close();return n;}
 public Cursor today(String date){return getReadableDatabase().rawQuery("SELECT id,ts,ml FROM drink WHERE date(ts/1000,'unixepoch','localtime')=? ORDER BY ts DESC",new String[]{date});}
 public void saveDay(String date,int total,int goal){ContentValues v=new ContentValues();v.put("date",date);v.put("total",total);v.put("goal",goal);getWritableDatabase().insertWithOnConflict("day",null,v,SQLiteDatabase.CONFLICT_REPLACE);}
 public Cursor history(){return getReadableDatabase().rawQuery("SELECT date,total,goal FROM day ORDER BY date DESC",null);}
}