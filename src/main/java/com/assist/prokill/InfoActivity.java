package com.assist.prokill;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;
//testing
/**
 * @author Ashish Kalbhor
 */
public class InfoActivity extends Activity {

    static int killCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_info);


        Button show = (Button) findViewById(R.id.show_button);
        Button kill = (Button) findViewById(R.id.kill_button);

        final List<ApplicationInfo> packages;

        ActivityManager mActivityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        final List<ActivityManager.RecentTaskInfo> recentTasks = mActivityManager.getRecentTasks(10, ActivityManager.RECENT_WITH_EXCLUDED);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < recentTasks.size(); i++) {
                    Toast.makeText(getApplicationContext(), "Name:: " + recentTasks.get(i).id + "\n", Toast.LENGTH_SHORT).show();

                }
            }
        });

        /*kill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Killing processes..",Toast.LENGTH_SHORT).show();
                for(ApplicationInfo pkfInfo : packages)
                {
                    if((pkfInfo.flags & ApplicationInfo.FLAG_SYSTEM)==1)
                    {

                        continue;
                    }
                    killCount++;
                    mActivityManager.killBackgroundProcesses(pkfInfo.packageName);

                }
                Toast.makeText(getApplicationContext(),"Kill Count => " + killCount,Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}
