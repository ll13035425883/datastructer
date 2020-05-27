import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] strings = s.split(",");
            int[] arr = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                arr[i] = Integer.parseInt(strings[i]);
            }
            quickSort(arr, 0, arr.length - 1);
            for (int i = 0; i < arr.length; i++) {
                if(i == 0) {
                    System.out.print("[" + arr[i] + ", ");
                } else if(i != arr.length - 1) {
                    System.out.print(arr[i] + ", ");
                } else {
                    System.out.println(arr[i] + "]");
                }
            }
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int temp = arr[low];
        int i = low, j = high;
        while(i < j) {
            while(i < j && temp < arr[j]) {
                j--;
            }
            if(i < j) {
                arr[i] = arr[j];
                i++;
            }
            while(i < j && temp > arr[i]) {
                i++;
            }
            if(i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = temp;
        return i;
    }
}