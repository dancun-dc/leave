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
    private TextView tvStartDate,tvEndDate,tvTel,tvCause,tvLocal,tvName,tvDate1,tvDate2,tvDate3,tvDate4,tvCarbon,tvCarbon1,tvCarbon2,tvCarbon3,thistime;
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
        tvCarbon1.setText(baseEntit.getCarbon()+" - 审批");
        tvCarbon2.setText(baseEntit.getCarbon2()+" - 审批");
        tvCarbon3.setText(baseEntit.getCarbon3()+" - 审批");
        tvLocal.setText(""+baseEntit.getLocal());
        String day = new SimpleDateFormat("MM-dd hh").format(new Date());
        int min = Integer.parseInt(new SimpleDateFormat("mm").format(new Date()));
        tvDate1.setText(day+(min-15));
        tvDate2.setText(day+(min-8));
        tvDate3.setText(day+(min-5));
        tvDate4.setText(day+(min-3));
        tvTel.setText(""+baseEntit.getTel());
        tvName.setText(""+baseEntit.getName());

    }

    private void initView() {
        tvStartDate = findViewById(R.id.tv_start_date);
        tvEndDate = findViewById(R.id.tv_end_date);
        tvCause = findViewById(R.id.tv_cause);
        tvCarbon = findViewById(R.id.tv_carbon);
        tvCarbon1 = findViewById(R.id.tv_carbon1);
        tvCarbon2 = findViewById(R.id.tv_carbon2);
        tvCarbon3 = findViewById(R.id.tv_carbon3);
        tvLocal = findViewById(R.id.tv_local);
        tvDate1 = findViewById(R.id.date1);
        tvDate2 = findViewById(R.id.date2);
        tvDate3 = findViewById(R.id.date3);
        tvDate4 = findViewById(R.id.date4);
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