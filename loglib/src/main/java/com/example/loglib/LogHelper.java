package com.example.loglib;

import android.os.Environment;
import android.util.Log;

import org.apache.log4j.Level;

import java.io.File;

import de.mindpipe.android.logging.log4j.LogConfigurator;

/**
 * @author
 * @version 1.0
 * @date 2017/12/5
 */

public class LogHelper {
    private static final String TAG = "LogHelper";
    private static final String DEFAULT_LOG_FILE_NAME = "MyApp.log";

    private static LogConfigurator mLogConfigurator = new LogConfigurator();

    public static void config(String path, boolean isDebug) {

        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath() + path;
        Log.d(TAG, "log path:" + absolutePath);
        mLogConfigurator.setFileName(absolutePath);
        mLogConfigurator.setFilePattern("%-d{yyyy-mm-dd HH:mm} [%t:%r]-[%p]-[%1]%m%n");
        mLogConfigurator.setLogCatPattern("[%1] %m%n");
        mLogConfigurator.setImmediateFlush(true);
        mLogConfigurator.setInternalDebugging(isDebug);
        mLogConfigurator.setMaxBackupSize(5);
        mLogConfigurator.setMaxFileSize(512 * 1024);
        mLogConfigurator.setUseFileAppender(true);
        mLogConfigurator.setUseLogCatAppender(true);

        mLogConfigurator.setRootLevel(Level.ERROR);
        mLogConfigurator.setLevel("org.apache", Level.ERROR);
        mLogConfigurator.configure();
    }
}
