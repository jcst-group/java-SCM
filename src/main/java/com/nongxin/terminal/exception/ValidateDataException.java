package com.nongxin.terminal.exception;

import java.util.Map;

public class ValidateDataException extends RuntimeException{

    private Map<String, StringBuffer> map;

    public ValidateDataException(Map<String, StringBuffer> map){
        super();
        this.map = map;
    }

    public Map<String, StringBuffer> getMap() {
        return map;
    }

    public void setMap(Map<String, StringBuffer> map) {
        this.map = map;
    }
}
