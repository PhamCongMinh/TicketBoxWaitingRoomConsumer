package org.ticketbox.scheduler.timertask;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskExample {
    public static void main(String[] args) {
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("Scheduled task is running");
            }
        };

        timer.schedule(task, 5000, 10000);
    }
}
