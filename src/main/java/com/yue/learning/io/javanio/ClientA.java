package com.yue.learning.io.javanio;

public class ClientA {
    public static void main(String[] args) {
        try {
            ChartClient.startClient("xhh");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
