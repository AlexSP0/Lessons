package com.company;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private int bandwidth;
    private Semaphore tonnelBandwidth;
    public Tunnel(int bandwidth) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.bandwidth = bandwidth;
        tonnelBandwidth = new Semaphore(bandwidth);
    }
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                tonnelBandwidth.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                tonnelBandwidth.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
