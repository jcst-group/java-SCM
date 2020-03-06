package com.nongxin.terminal.config;

import java.util.ArrayList;

public class FilterTableFactory {

    /**
     3      * 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例
     4      * 没有绑定关系，而且只有被调用到才会装载，从而实现了延迟加载
     5      */
    private static class SingletonHolder{
        private static ArrayList<String> filterTables = new ArrayList();
  }

}
