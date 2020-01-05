package com.rollforinitiative.campaignmgr.exception;

public class UsersNotFoundException extends RuntimeException {
    public UsersNotFoundException(String message) {
        super(message);
    }
}