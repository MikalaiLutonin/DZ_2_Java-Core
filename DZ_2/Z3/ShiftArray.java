
// Написать метод, принимающий на вход массив чисел и параметр n. Метод должен осуществить циклический (последний элемент при сдвиге становится первым) сдвиг всех элементов массива на n позиций;

import java.util.Arrays;

public class ShiftArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int n = 2;

        System.out.println("Исходный массив: " + Arrays.toString(array));

        shiftArray(array, n);

        System.out.println("Сдвинутый массив: " + Arrays.toString(array));
    }

    public static void shiftArray(int[] array, int n) {
        int length = array.length;

        // Сдвигаем элементы массива на n позиций
        for (int i = 0; i < n; i++) {
            int temp = array[length - 1];

            for (int j = length - 1; j > 0; j--) {
                array[j] = array[j - 1];
            }

            array[0] = temp;
        }
    }
}
