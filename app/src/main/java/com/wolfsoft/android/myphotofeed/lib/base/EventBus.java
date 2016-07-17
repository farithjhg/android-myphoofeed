package com.wolfsoft.android.myphotofeed.lib.base;

/**
 * Created by farithjhg on 28/06/2016..
 */
public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
