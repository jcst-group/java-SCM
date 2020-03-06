package com.nongxin.terminal.util.enumUtil.config;

public interface BaseEnum<E extends Enum<E>, T> {
    T getValue();
    String getCode();
    String getDisplayName();
}

