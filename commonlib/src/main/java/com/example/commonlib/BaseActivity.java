package com.example.commonlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        
        
    }

    /**
     * 
     * @return
     */
    protected abstract int getContentView();
    
}
