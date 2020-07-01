package jvm.heap;

import java.util.ArrayList;
import java.util.Random;

public class OOMTest {
    public static void main(String[] args) {
        ArrayList<Pic> picArrayList = new ArrayList<>();
        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            picArrayList.add(new Pic(new Random().nextInt(1024 * 1024)));
        }
    }
}

class Pic {
    private byte[] poxels;

    public Pic(int length) {
        this.poxels = new byte[length];
    }
}
