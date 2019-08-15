package net.kampungweb.mygcmnetworkmanager;

import android.content.Context;

import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.PeriodicTask;
import com.google.android.gms.gcm.Task;

public class SchedulerTask {
    private GcmNetworkManager gcmNetworkManager;

    public SchedulerTask(Context context){
        gcmNetworkManager = GcmNetworkManager.getInstance(context);
    }

    public void createPeriodicTask(){
        Task periodicTask = new PeriodicTask.Builder()
                .setService(SchedulerService.class)
                .setPeriod(60)
                .setFlex(10)
                .setTag(SchedulerService.TAG_TASK_WEATHER_LOG)
                .setPersisted(true)
                .build();
        gcmNetworkManager.schedule(periodicTask);
    }

    public void cancelPeriodicTask(){
        if (gcmNetworkManager != null){
            gcmNetworkManager.cancelTask(SchedulerService.TAG_TASK_WEATHER_LOG, SchedulerService.class);
        }
    }

}
