package com.example.loglib.log4j;

import android.util.Log;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;

/**
 * @author
 * @version 1.0
 * @date 2017/12/5
 */

public class LogCatAppender extends AppenderSkeleton {
    private Layout mLayout;
    
    public LogCatAppender(Layout layout) {
        this.mLayout = layout;
    }

    @Override
    protected void append(LoggingEvent loggingEvent) {
        switch (loggingEvent.getLevel().toInt()){
       
            case Level.DEBUG_INT:
                if(loggingEvent.getLocationInformation()!=null){
                    Log.d(getLayout().format(loggingEvent),getLayout().format(loggingEvent),loggingEvent.getThrowableInformation().getThrowable());
                }else {
                    Log.d(getLayout().format(loggingEvent),getLayout().format(loggingEvent));
                }
                break;
                
            case Level.INFO_INT:
                if(loggingEvent.getLocationInformation()!=null){                                                                                       
                    Log.i(getLayout().format(loggingEvent),getLayout().format(loggingEvent),loggingEvent.getThrowableInformation().getThrowable());
                }else {                                                                                                                                
                    Log.i(getLayout().format(loggingEvent),getLayout().format(loggingEvent));                                                      
                }                                                                                                                                      
                
                break;
            case Level.WARN_INT:
                if(loggingEvent.getLocationInformation()!=null){                                                                                       
                    Log.w(getLayout().format(loggingEvent),getLayout().format(loggingEvent),loggingEvent.getThrowableInformation().getThrowable());
                }else {                                                                                                                                
                    Log.w(getLayout().format(loggingEvent),getLayout().format(loggingEvent));                                                      
                }                                                                                                                                      break;
            case Level.ERROR_INT:
                if(loggingEvent.getLocationInformation()!=null){                                                                                       
                    Log.e(getLayout().format(loggingEvent),getLayout().format(loggingEvent),loggingEvent.getThrowableInformation().getThrowable());
                }else {                                                                                                                                
                    Log.e(getLayout().format(loggingEvent),getLayout().format(loggingEvent));                                                      
                }                                                                                                                                      break;
            case Level.TRACE_INT:
                if(loggingEvent.getLocationInformation()!=null){                                                                                       
                    Log.wtf(getLayout().format(loggingEvent),getLayout().format(loggingEvent),loggingEvent.getThrowableInformation().getThrowable());
                }else {                                                                                                                                
                    Log.wtf(getLayout().format(loggingEvent),getLayout().format(loggingEvent));                                                      
                }                                                                                                                                      break;
        }
    }

    @Override
    public void close() {

    }

    @Override
    public boolean requiresLayout() {
        return true;
    }

    @Override
    public Layout getLayout() {
        return mLayout;
    }

    @Override
    public void setLayout(Layout layout) {
        mLayout = layout;
    }
}
