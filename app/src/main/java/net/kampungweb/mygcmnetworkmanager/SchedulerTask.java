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

    public void onCreatePeriodicTask(){
        Task periodicTask = new PeriodicTask.Builder()
                .setService(SchedulerService.class) // Menentukan GcmTaskService yang akan dijalankan ketika kriteria terpenuhi
                .setPeriod(60)                      // menentukan interval task yang akan dijalankan dalam satuan detik
                .setFlex(10)                        // menentukan range waktu untuk eksekusi task yang akan dijalankan.
                                                    // misal : kita atur period 30 dan flex = 10 maka, task akan dijalankan
                                                    // di range antara 20 sampai 30
                .setTag(SchedulerService.TAG_TASK_WEATHER_LOG)  // memberikan tag dari task yang dijalankan
                .setPersisted(true)                 // metode ini membuat semua task yang akan dijalankan, tetap dipertahankan ketika
                                                    // terjadi proses reboot device
                .build();
        gcmNetworkManager.schedule(periodicTask);
    }

    public void cancelPeriodicTask(){
        if (gcmNetworkManager != null){
            gcmNetworkManager.cancelTask(SchedulerService.TAG_TASK_WEATHER_LOG, SchedulerService.class);
        }
    }

}
