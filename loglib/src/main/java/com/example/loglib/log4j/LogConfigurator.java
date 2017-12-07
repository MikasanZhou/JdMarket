package com.example.loglib.log4j;

import com.example.loglib.log4j.LogCatAppender;

import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.helpers.LogLog;

import java.io.IOException;

/**
 * @author
 * @version 1.0
 * @date 2017/12/5
 */

public class LogConfigurator {

    private Level rootLevel;

    private String fileName;

    private String filePattern;

    private String logcatPattern;

    private int maxBackSize;

    private long maxFileSize;

    private boolean immediteFlush;

    private boolean useLogcatAppender;

    private boolean useFileAppender;

    private boolean resetCongifurator;

    private boolean interceptDebug;

    public LogConfigurator() {
    }

    public LogConfigurator(Level rootLevel, String fileName) {
        this.rootLevel = rootLevel;
        this.fileName = fileName;
    }

    public LogConfigurator(String fileName) {
        this.fileName = fileName;
    }

    public Level getRootLevel() {
        return rootLevel;
    }

    public void setRootLevel(Level rootLevel) {
        this.rootLevel = rootLevel;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePattern() {
        return filePattern;
    }

    public void setFilePattern(String filePattern) {
        this.filePattern = filePattern;
    }

    public String getLogcatPattern() {
        return logcatPattern;
    }

    public void setLogcatPattern(String logcatPattern) {
        this.logcatPattern = logcatPattern;
    }

    public int getMaxBackSize() {
        return maxBackSize;
    }

    public void setMaxBackSize(int maxBackSize) {
        this.maxBackSize = maxBackSize;
    }

    public long getMaxFileSize() {
        return maxFileSize;
    }

    public void setMaxFileSize(long maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    public boolean isImmediteFlush() {
        return immediteFlush;
    }

    public void setImmediteFlush(boolean immediteFlush) {
        this.immediteFlush = immediteFlush;
    }

    public boolean isUseLogcatAppender() {
        return useLogcatAppender;
    }

    public void setUseLogcatAppender(boolean useLogcatAppender) {
        this.useLogcatAppender = useLogcatAppender;
    }

    public boolean isUseFileAppender() {
        return useFileAppender;
    }

    public void setUseFileAppender(boolean useFileAppender) {
        this.useFileAppender = useFileAppender;
    }

    public boolean isResetCongifurator() {
        return resetCongifurator;
    }

    public void setResetCongifurator(boolean resetCongifurator) {
        this.resetCongifurator = resetCongifurator;
    }

    public boolean isInterceptDebug() {
        return interceptDebug;
    }

    public void setInterceptDebug(boolean interceptDebug) {
        this.interceptDebug = interceptDebug;
    }

    public void setLevel(String fileName, Level level) {
        Logger.getLogger(fileName).setLevel(level);
    }

    public void configure() {
        if (isResetCongifurator()) {
            LogManager.getLoggerRepository().resetConfiguration();
        }

        LogLog.setInternalDebugging(isInterceptDebug());

        if (isUseLogcatAppender()) {
            configuratorUseLogcatAppender();
        }

        if (isUseFileAppender()) {
            configuraUseAppender();
        }
        
        Logger.getRootLogger().setLevel(getRootLevel());
    }

    private void configuraUseAppender() {
        Logger rootLogger = Logger.getRootLogger();
        final Layout layout = new PatternLayout(getFilePattern());
        final RollingFileAppender rollingFileAppender;

        try {
            rollingFileAppender = new RollingFileAppender(layout, getFileName());
        } catch (IOException e) {
            throw new RuntimeException("发生什么异常？");
        }
        rollingFileAppender.setMaxBackupIndex(getMaxBackSize());
        rollingFileAppender.setMaximumFileSize(getMaxFileSize());
        rollingFileAppender.setImmediateFlush(isImmediteFlush());
        rollingFileAppender.setEncoding("utf-8");

        rootLogger.addAppender(rollingFileAppender);
    }

    private void configuratorUseLogcatAppender() {
        Logger rootLogger = Logger.getRootLogger();
        final Layout layout = new PatternLayout(getLogcatPattern());
        final LogCatAppender logCatAppender = new LogCatAppender(layout);
        rootLogger.addAppender(logCatAppender);

    }
}
