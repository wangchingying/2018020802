package com.cyw.a2018020802;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    //設定鬧鐘要Calendar 及 PendingIntent
    private Calendar calendar = Calendar.getInstance();
    private PendingIntent sender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click1(View v)
    {
        Log.d("log: ","you click to start alarm");
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);

        Intent intent = new Intent(this, MyService.class);
// 建立PendingIntent
        sender = PendingIntent.getService(this, 100, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        calendar.getTime();


        calendar.setTimeInMillis(System.currentTimeMillis());
//        calendar.set(Calendar.HOUR_OF_DAY, 3);
//        calendar.set(Calendar.MINUTE, 50);
        calendar.set(Calendar.HOUR_OF_DAY, Integer.valueOf(calendar.get(Calendar.HOUR_OF_DAY)));
        calendar.set(Calendar.MINUTE, Integer.valueOf(calendar.get(Calendar.MINUTE)+1));
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
    }
}
