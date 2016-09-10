package com.liangmayong.android_loading;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.liangmayong.loading.Loading;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Loading.showLoading(this, "Loading", 0xfffcb815, 0x30aaaaaa, 0.3f);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Loading.showLoading(MainActivity.this, "开始加载数据");
                initCancelLoading();
            }
        }, 3000);
    }

    private void initCancelLoading() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Loading.cancelLoading(MainActivity.this);
            }
        }, 3000);
    }
}
