package com.company.regionservice.exception;

public class RegionAlreadyExistsException extends RuntimeException {
    public RegionAlreadyExistsException(String msg) {
        super(msg);
    }
}
