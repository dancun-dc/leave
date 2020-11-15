package com.dancun.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dancun.R;
import com.dancun.entity.BaseEntity;

public class HomeActivity extends AppCompatActivity {
    private TextView tvHomeSn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BaseEntity baseEntity = (BaseEntity) getIntent().getExtras().getSerializable("baseEntity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvHomeSn=findViewById(R.id.tv_home_sn);
        if(baseEntity.getSchoolName()!=""){
            tvHomeSn.setText(baseEntity.getSchoolName()+"  ﹀");
        }


    }
    public void tost(View v){
        Toast.makeText(this,"网络问题,稍后重试",Toast.LENGTH_SHORT).show();
    }
    public void startleave(View v){
        Intent intent = new Intent(HomeActivity.this,LeaveDetail.class);
        startActivity(intent);
    }
}