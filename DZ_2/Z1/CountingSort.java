// Доделать сортировку подсчетом с урока (если нет, реализовать) классическим способом через промежуточный массив (см. последние минут 10 семинара)


import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        int[] arr = { 5, 3, 2, 8, 6, 4, 1, 9, 7 };
        int[] sortedArr = countingSort(arr);
        System.out.println(Arrays.toString(sortedArr));
    }

    public static int[] countingSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;

        int[] count = new int[range];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] output = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }

        return arr;
    }
}