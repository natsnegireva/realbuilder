package com.geekbrains.realbuilder.threads;

public class PingPong {
    public static void main(String[] args) {
        PingPong pingPong = new PingPong();
        pingPong.start();
    }

    private void start(){
        Thread ping = new Thread(new WordPP(), "ping");
        ping.start();
        Thread pong = new Thread(new WordPP(), "pong");
        pong.start();
    }
}
