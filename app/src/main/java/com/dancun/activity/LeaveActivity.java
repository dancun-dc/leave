package com.dancun.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.dancun.R;
import com.dancun.entity.BaseEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LeaveActivity extends AppCompatActivity {
    private TextView tvStartDate,tvStartTime,tvEndDate,tvEndTime;
    private BaseEntity baseEntity = new BaseEntity();
    private EditText editCause,editCarbon,editLocal,editTel;
    private String startTime="06:00";
    private String endTime="23:00";
    private String startDate=new SimpleDateFormat("MM-dd ").format(new Date());
    private String endDate=new SimpleDateFormat("MM-dd ").format(new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave);
        initView();
    }
    void initView(){
        tvStartDate=findViewById(R.id.tv_edit_satrt_date);
        tvStartTime = findViewById(R.id.tv_satrt_time);
        tvEndTime = findViewById(R.id.tv_end_time);
        tvEndDate = findViewById(R.id.tv_edit_end_date);
        editCarbon = findViewById(R.id.edit_carbon);
        editLocal = findViewById(R.id.edit_local);
        editCause = findViewById(R.id.edit_cause);
        editTel = findViewById(R.id.edit_tel);
    }
    public void setDate(View v){
        Date date = new Date();
        new DatePickerDialog(LeaveActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override//当选择某一个日期会执行 onDateSet这个函数
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                String date = String.format("%s-%s ",(month<10?""+month:""+month),(day<10?"0"+day:""+day));
                if (v.getId()==R.id.tv_edit_satrt_date) {
                    tvStartDate.setText(date + "  ▼");
                    startDate=date;
                }
                else{
                    tvEndDate.setText(date+"  ▼");
                    endDate=date;
                }
                Toast.makeText(LeaveActivity.this,date,Toast.LENGTH_SHORT).show();
            }
        },
                Integer.parseInt(new SimpleDateFormat("yyyy").format(date)),
                Integer.parseInt(new SimpleDateFormat("MM").format(date)),
                Integer.parseInt(new SimpleDateFormat("dd").format(date))
        ).show();
    }
    public void setTime(View v){
        new TimePickerDialog(LeaveActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int h, int m) {
                String time=String.format("%s:%s",(h<10?"0"+h:""+h),(m<10?"0"+m:""+m));
                if (v.getId()==R.id.tv_end_time){
                    tvEndTime.setText(time);
                   endTime = time;
                }else{
                    tvStartTime.setText(time);
                    endTime = time;
                }

            }
        },0,0,true).show();
    }
    public void onsub(View v){
        baseEntity.setCarbon(editCarbon.getText().toString());
        baseEntity.setLeaveCause(editCause.getText().toString());
        baseEntity.setLeaveType("事假");
        baseEntity.setTel(editTel.getText().toString());
        baseEntity.setLocal(editLocal.getText().toString());
        baseEntity.setStartDate(startDate+startTime);
        baseEntity.setEndDate(endDate+endTime);
        Intent intent = new Intent(LeaveActivity.this,LeaveStateActivity.class);
        Bundle bundle =new Bundle();
        bundle.putSerializable("baseEntity",baseEntity);
        intent.replaceExtras(bundle);
        startActivity(intent);


    }
}