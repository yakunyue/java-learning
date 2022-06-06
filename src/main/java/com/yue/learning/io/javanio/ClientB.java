package com.yue.learning.io.javanio;

public class ClientB {
    public static void main(String[] args) {
        try {
            ChartClient.startClient("yyk");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
