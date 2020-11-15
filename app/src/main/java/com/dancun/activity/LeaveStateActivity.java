package com.dancun.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.dancun.R;
import com.dancun.entity.BaseEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LeaveStateActivity extends AppCompatActivity {
    private TextView tvStartDate,tvEndDate,tvTel,tvCause,tvLocal,tvName,tvDate1,tvDate2,tvCarbon,tvCarbon1,thistime;
    private  BaseEntity baseEntit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        baseEntit = new BaseEntity();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_state);
        initView();
        setValue();
        new TimeThread().start();
    }

    private void setValue() {
        tvStartDate.setText(""+baseEntit.getStartDate());
        tvEndDate.setText(""+baseEntit.getEndDate());
        tvCause.setText(""+baseEntit.getLeaveCause());
        tvCarbon.setText(""+baseEntit.getCarbon());
        tvCarbon1.setText("[辅导员]"+baseEntit.getCarbon()+" - 审批");
        tvLocal.setText(""+baseEntit.getLocal());
        tvDate1.setText(new SimpleDateFormat("MM-dd hh:mm").format(new Date()));
        tvDate2.setText(new SimpleDateFormat("MM-dd hh:mm").format(new Date()));
        tvTel.setText(""+baseEntit.getTel());
        tvName.setText(""+baseEntit.getName());

    }

    private void initView() {
        tvStartDate = findViewById(R.id.tv_start_date);
        tvEndDate = findViewById(R.id.tv_end_date);
        tvCause = findViewById(R.id.tv_cause);
        tvCarbon = findViewById(R.id.tv_carbon);
        tvCarbon1 = findViewById(R.id.tv_carbon1);
        tvLocal = findViewById(R.id.tv_local);
        tvDate1 = findViewById(R.id.date1);
        tvDate2 = findViewById(R.id.date2);
        tvTel = findViewById(R.id.tv_tel);
        tvName = findViewById(R.id.tv_name);
        thistime = findViewById(R.id.thistime);
    }
    public void toDetail(View v){
        Intent intent = new Intent(LeaveStateActivity.this,LeaveDetail.class);
        startActivity(intent);
    }
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    thistime.setText("当前时间:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis())));
                    break;
            }
            return false;
        }
    });
    public class TimeThread extends Thread{
        @Override
        public void run() {
            super.run();
            do{
                try {
                    Thread.sleep(1000);
                    Message msg = new Message();
                    msg.what = 1;
                    handler.sendMessage(msg);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }while (true);

        }
    }
}