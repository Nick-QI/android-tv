package com.nickboomboom.tv.main;

import java.util.Arrays;

public class ChannelBean {
    private String  title;
    private  String[] list;

    public ChannelBean(String title, String[] list) {
        this.title = title;
        this.list = list;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getList() {
        return list;
    }

    public void setList(String[] list) {
        this.list = list;
    }


    @Override
    public String toString() {
        return "Channel{" +
                "title='" + title + '\'' +
                ", list=" + Arrays.toString(list) +
                '}';
    }
}
