package com.lsh.common.manager;

import org.greenrobot.eventbus.EventBus;

public class EventBusManager {
    public static final String EVENT_LOGIN = "EVENT_LOGIN";

    public static void register(Object subscriber) {
        EventBus.getDefault().register(subscriber);
    }

    public static void unregister(Object subscriber) {
        EventBus.getDefault().unregister(subscriber);
    }

    public static void post(String type) {
        post(type, null);
    }

    public static void post(String type, Object object) {
        EventBus.getDefault().post(new MessageEvent(type, object));
    }
}
