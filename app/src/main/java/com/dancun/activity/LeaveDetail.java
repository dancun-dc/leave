package com.dancun.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dancun.R;
import com.dancun.entity.BaseEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LeaveDetail extends AppCompatActivity {
    private TextView tvLeaveDate,tvDates;
    private BaseEntity baseEntity = new BaseEntity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_detail);
        tvDates = findViewById(R.id.tv_dates);
        tvLeaveDate = findViewById(R.id.tv_leave_date);
        String date="";
        try {
            Date start = new SimpleDateFormat("MM-dd hh:mm").parse(baseEntity.getStartDate());
            Date end = new SimpleDateFormat("MM-dd hh:mm").parse(baseEntity.getEndDate());
            date =new SimpleDateFormat("共hh小时mm分").format(new Date(end.getTime()-start.getTime()));
        }catch (Exception e){
            date = "8小时20分";
        }

        tvDates.setText(baseEntity.getStartDate()+" ~ "+baseEntity.getEndDate()+"    "+date);
        tvLeaveDate.setText(new SimpleDateFormat("MM-dd").format(new Date()));
    }
    public void leave(View v){
        Intent intent = new Intent(LeaveDetail.this,LeaveActivity.class);
        startActivity(intent);

    }
    public void leaveState(View v){
        Intent intent = new Intent(LeaveDetail.this,LeaveStateActivity.class);
        startActivity(intent);

    }
}