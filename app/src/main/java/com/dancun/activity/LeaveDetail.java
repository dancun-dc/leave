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


        tvDates.setText(baseEntity.getStartDate()+" ~ "+baseEntity.getEndDate()+"    共8小时20分");
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