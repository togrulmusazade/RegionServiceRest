package com.company.regionservice.exception;

public class RegionNotFoundException extends RuntimeException{
    public RegionNotFoundException(String msg) {
        super(msg);
    }
}
