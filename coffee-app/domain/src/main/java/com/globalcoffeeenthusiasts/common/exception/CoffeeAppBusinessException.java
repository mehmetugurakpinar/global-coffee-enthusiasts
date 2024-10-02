package com.globalcoffeeenthusiasts.common.exception;

public class CoffeeAppBusinessException extends RuntimeException {
    private final String key;
    private final String[] args;

    public CoffeeAppBusinessException(String key) {
        super(key);
        this.key = key;
        this.args = new String[0];
    }

    public CoffeeAppBusinessException(String key, String... args) {
        super(key);
        this.key = key;
        this.args = args;
    }

    public String getKey() {
        return this.key;
    }

    public String[] getArgs() {
        return this.args;
    }
}
