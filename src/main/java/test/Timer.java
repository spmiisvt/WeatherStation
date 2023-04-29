package test;

import api.ClockListener;

public class Timer extends Thread {
    private ClockListener listener;
    private long delay;
    Timer(long delay, ClockListener listener) {
        this.delay = delay;
        this.listener = listener;
    }
    @Override
    public void run() {
        try {
            for(;;)  {
                listener.tic();
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            return;
        }
    }
}
