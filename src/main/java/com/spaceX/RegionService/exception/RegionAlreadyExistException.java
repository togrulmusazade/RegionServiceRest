package com.spaceX.RegionService.exception;

public class RegionAlreadyExistException extends RuntimeException {

    public RegionAlreadyExistException(String msg) {
        super(msg);
    }

}
