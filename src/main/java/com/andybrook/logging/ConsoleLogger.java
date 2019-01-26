package com.andybrook.logging;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class ConsoleLogger implements System.Logger {

    private String className;
    public ConsoleLogger(String className) {
        this.className = className;
    }

    @Override
    public String getName() {
        return "ConsoleLogger";
    }

    @Override
    public boolean isLoggable(Level level) {
        return false;
    }

    @Override
    public void log(Level level, ResourceBundle bundle, String msg, Throwable thrown) {
        System.out.printf(className + " [%s]: %s - %s%n", level, msg, thrown);
    }

    @Override
    public void log(Level level, ResourceBundle bundle, String format, Object... params) {
        System.out.printf(className + " [%s]: %s%n", level, MessageFormat.format(format, params));
    }
}