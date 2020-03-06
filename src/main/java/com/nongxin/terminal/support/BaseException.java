package com.nongxin.terminal.support;

public class BaseException extends Exception {
    private static String errorMessage;
    private static int errorCode;

    public BaseException(int errorCode, String errorMessage){
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public static String getErrorMessage() {
        return errorMessage;
    }

    public static int getErrorCode() {
        return errorCode;
    }

    public static void setErrorCode(int errorCode) {
        BaseException.errorCode = errorCode;
    }

    public static void setErrorMessage(String errorMessage) {
        BaseException.errorMessage = errorMessage;
    }

}

