import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] arr2 = filterEvenIndexOddValue(arr1);
        printArray(arr2);
        int[] arr3 ={3, 3, 3, 2, 2};
        int[] arr4 = findDominant(arr3);
        printArray(arr4);
        int[] arr5 = {1, 2, 3, 4, 5};
        int[] arr6 = rotateArray(arr5, 2);
        printArray(arr6);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] filterEvenIndexOddValue(int[] array){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0 && array[i] % 2 != 0) {
                list.add(array[i]);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    public static int[] findDominant(int[] arr) {
        int candidate = -1;
        int count = 0;

        for (int num : arr) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for (int num : arr) {
            if (num == candidate) {
                count++;
            }
        }
        return new int[]{(count > arr.length / 2) ? candidate : -1};
    }


    public static int[] rotateArray(int[] array, int positions) {
        int[] result = new int[array.length];
        int n=0;
        for (int i = positions + 1; i < array.length; i++) {
            result[n] = array[i];
            n++;
        }
        return result;
    }

}