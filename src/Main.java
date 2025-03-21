import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6};
        int[] arr2 = {2,3,4,5,6,7};
        int[] arr3 = {7,8,9,10,11};
        int[] result1 = filterEvenIndexOddValue(arr1);
        System.out.println(Arrays.toString(result1));
        int[] result2 = filterEvenIndexOddValue(arr2);
        System.out.println(Arrays.toString(result2));
        int[] result3 = filterEvenIndexOddValue(arr3);
        System.out.println(Arrays.toString(result3));

        int[] arr4 = {3,3,3,2,2};
        System.out.println(findDominant(arr4));
        int[] arr5 = {1,2,3,4};
        System.out.println(findDominant(arr5));
        int[] arr6 = {5,5,5,5,1};
        System.out.println(findDominant(arr6));

        int[] arr7 = {1,2,3,4,5};
        int[] result7 = rotateArray(arr7,2);
        System.out.println(Arrays.toString(result7));
        int[] arr8 = {1,2,3};
        int[] result8 = rotateArray(arr8,3);
        System.out.println(Arrays.toString(result8));
    }

    public static int[] filterEvenIndexOddValue (int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i+=2) {
            if (arr[i] % 2 != 0) {
                count++;
            }
        }
        int [] result = new int[count];
        int index = 0;
        for (int i = 0; i < arr.length; i+=2) {
            if (arr[i] % 2 != 0) {
                result[index++] = arr[i];
            }
        }
        return result;
    }

    public static Integer findDominant(int[] arr) {
        Map <Integer, Integer> CountMap = new HashMap<>();
        for (int num: arr) {
            CountMap.put(num, CountMap.getOrDefault(num, 0) + 1);
        }
        int threshold = arr.length / 2;
        for (Map.Entry<Integer, Integer> entry : CountMap.entrySet()) {
            if (entry.getValue() > threshold) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static int [] rotateArray(int[] arr, int positions) {
        if (arr.length == 0 || positions == 0) {
            return arr.clone();
        }
        positions = positions % arr.length;
        if (positions < 0) {
            positions += arr.length;
        }
        int [] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[(i + positions) % arr.length] = arr[i];
        }
        return result;
    }
}
