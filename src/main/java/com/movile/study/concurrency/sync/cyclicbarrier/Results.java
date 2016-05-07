package com.movile.study.concurrency.sync.cyclicbarrier;

/**
 * @author Daniel Panhan (daniel.panhan@movile.com)
 */
public class Results {

    private int data[];

    public Results(int size) {
        data = new int[size];
    }

    public void setData(int position, int value) {
        data[position] = value;
    }

    public int[] getData() {
        return data;
    }

}
