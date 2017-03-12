package com.alex.impl;

import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.text.DateFormat;
import java.util.*;

@Component
public class CacheWriter extends WriterToFileImpl {
    private int cacheSize;
    private Queue<String> cache;


    public CacheWriter(int cacheSize , Date date, DateFormat df, String fileName) {
        super(date, df, fileName);
        this.cacheSize = cacheSize;
        this.cache = new ArrayDeque<>(cacheSize);
    }
    @PreDestroy
    public void destroy() {
        System.out.println("DESTROY method");
        if ( ! cache.isEmpty()) {
            writeMsgCache();
        }
    }

    @Override
    public void write(String str) {
        cache.add(str);
        if (cache.size() == cacheSize) {
            writeMsgCache();
            cache.clear();
        }
    }

    private void writeMsgCache() {
        while(!cache.isEmpty())
            super.write(cache.poll());

    }

}
