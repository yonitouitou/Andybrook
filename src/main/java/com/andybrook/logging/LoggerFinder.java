package com.andybrook.logging;

public class LoggerFinder extends System.LoggerFinder {

    @Override
    public System.Logger getLogger(String name, Module module) {
        return new ConsoleLogger();
    }
}
