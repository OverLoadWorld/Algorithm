package StackQueueHeap;

import java.util.HashSet;
import java.util.Set;

public class WaterJug {
    Set<Integer> alreadyNum = new HashSet<>();
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) {
            return true;
        }
        if (x + y < z || (x == 0 && y == 0 && z != 0) || ((x == 0 || y == 0) && x + y > z)) {
            return false;
        }
        if (z == 0 || (x != 0 && z % x == 0) || z % y == 0) {
            return true;
        } else {
            if (!alreadyNum.contains(z)) {
                alreadyNum.add(z);

                if (z == x || z == y) {
                    return true;
                }
            } else {
                return false;
            }
            int newzx = z > x ? z - x : x - z;
            int newzy = z > y ? z - y : y - z;
            if (canMeasureWater(x, y, newzx)) {
                System.out.println("x:"+x+".y:"+y+".z:"+z+".");
                return true;
            }
            return canMeasureWater(x , y , newzy);
        }
    }

    public static void main(String[] args) {
        WaterJug waterJug = new WaterJug();
        System.out.println(waterJug.canMeasureWater(3, 5, 4));
//        System.out.println(waterJug.canMeasureWater(2, 6, 5));
//        System.out.println(waterJug.canMeasureWater(0, 0, 1));
//        System.out.println(waterJug.canMeasureWater(0, 2, 1));
//        System.out.println(waterJug.canMeasureWater(0, 0, 0));
        //System.out.println(waterJug.canMeasureWater(1, 0, 0));
    }
}
