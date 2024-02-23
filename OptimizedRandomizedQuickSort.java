import java.util.Random;

public class OptimizedRandomizedQuickSort {
    public static void main(String[] args) {
        int[] array = {9, 7, 5, 11, 12, 2, 14, 3, 10, 6};
        randomizedQuickSort(array, 0, array.length - 1);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void randomizedQuickSort(int[] array, int p, int r) {
        if (p < r) {
            int q = randomizedPartition(array, p, r);
            randomizedQuickSort(array, p, q - 1);
            randomizedQuickSort(array, q + 1, r);
        }
    }

    public static int randomizedPartition(int[] array, int p, int r) {
        Random random = new Random();
        int i = random.nextInt(r - p + 1) + p;
        swap(array, i, r);
        return partition(array, p, r);
    }

    public static int partition(int[] array, int p, int r) {
        int x = array[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (array[j] <= x) {
                i++;
                if (i != j) {
                    swap(array, i, j);
                }
            }
        }
        swap(array, i + 1, r);
        return i + 1;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
