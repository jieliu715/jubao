package com.best.shanpinyindao;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.best.jubao.MainActivity;
import com.best.jubao.R;

public class ShanpinActivity extends AppCompatActivity {

    public static long currentTiem;
    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shanpin);
        handler.postDelayed(runnable, 300);
    }
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {

            //int shiyong = 0;
            currentTiem = System.currentTimeMillis();
            while (true){
                //加载完数据
                long shiyong = System.currentTimeMillis()-currentTiem;
                if(shiyong<2000){
                    try {
                        Thread.sleep(2000-shiyong);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //跳转到引导页面
//                    Intent intent = new Intent(ShanPinActivity.this, StepActivity.class);
//                    ShanPinActivity.this.startActivity(intent);
//                    finish();
                    actionImage();
                    break;
                }
            }
        }
    };
    public void actionImage(){
        preferences = getSharedPreferences("count",MODE_WORLD_READABLE);
        int count = preferences.getInt("count", 0);

        //判断程序与第几次运行，如果是第一次运行则跳转到引导页面
        if (count == 0) {
            Log.i("aaa",count+"count////////////");
//            startActivity(new Intent(ShanpinActivity.this,
//                    StepActivity.class));

            this.finish();
            SharedPreferences.Editor editor = preferences.edit();
            //存入数据
            editor.putInt("count", ++count);
            //提交修改
            editor.commit();
        }else{
            Log.i("aaa",count+"count............");
            //直接跳转到主页
            finish();
            startActivity(new Intent(ShanpinActivity.this,
                    MainActivity.class));
        }

    }

}
