package net.kampungweb.mygcmnetworkmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSetScheduler, btnCancelScheduler;
    SchedulerTask schedulerTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCancelScheduler = findViewById(R.id.btn_cancel_scheduler);
        btnSetScheduler = findViewById(R.id.btn_set_scheduler);
        btnSetScheduler.setOnClickListener(this);
        btnCancelScheduler.setOnClickListener(this);
        schedulerTask = new SchedulerTask(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_set_scheduler){
            schedulerTask.createPeriodicTask();
            Toast.makeText(getApplicationContext(), "Periodic Task clicked", Toast.LENGTH_SHORT).show();

        } else if (view.getId() == R.id.btn_cancel_scheduler){
            schedulerTask.cancelPeriodicTask();
            Toast.makeText(getApplicationContext(), "Periodic Task Canceled", Toast.LENGTH_SHORT).show();
        }

    }
}
