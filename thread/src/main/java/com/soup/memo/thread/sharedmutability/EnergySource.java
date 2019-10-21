package com.soup.memo.thread.sharedmutability;

import lombok.extern.slf4j.Slf4j;

/**
 *
 *
 * @author zhaoyi
 */
@Slf4j
public class EnergySource {

    private final long MAXLEVEL = 100;

    // 成员变量在并发时
    private long level = MAXLEVEL;
    private boolean keepRunning = true;

    public EnergySource() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                replenish();
            }
        }).start();
    }

    public long getUnitsAvailable() {
        return level;
    }

    public boolean useEnergy(final long units) {
        if (units > 0 && level >= units) {
            level -= units;
            return true;
        }
        return false;
    }

    public void stopEnergySource() {
        keepRunning = false;
    }

    private void replenish() {
        while (keepRunning) {
            if (level < MAXLEVEL) {
                level++;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
