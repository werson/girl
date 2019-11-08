package test;

import org.junit.Test;

import java.util.Random;

public class HeLanFlag {

    @Test
    public void orderArrayTest() {
        int[] array = new int[200];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(3);
        }
        long startTime = System.currentTimeMillis();
        int start = 0;
        int current = 0;
        int end = array.length - 1;
        while (current <= end) {
            if (array[current] == 0) {
                swap(array, current, start);
                start++;
                current++;
            } else if (array[current] == 2) {
                swap(array, current, end);
                end--;
            } else {
                current++;
            }
        }
        long costTime = System.currentTimeMillis() - startTime;
        System.out.println("cost time = " + costTime);
    }

    private void swap(int[] array, int index1, int index2){
        array[index1] = array[index1] + array[index2];
        array[index2] = array[index1] - array[index2];
        array[index1] = array[index1] - array[index2];
    }
}
