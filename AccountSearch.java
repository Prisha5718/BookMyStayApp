import java.util.*;

public class AccountSearch {

    static int linearFirst(String[] arr, String target) {
        int comparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear comparisons: " + comparisons);
                return i;
            }
        }
        System.out.println("Linear comparisons: " + comparisons);
        return -1;
    }

    static int linearLast(String[] arr, String target) {
        int comparisons = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear comparisons: " + comparisons);
                return i;
            }
        }
        System.out.println("Linear comparisons: " + comparisons);
        return -1;
    }

    static int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid].equals(target)) {
                System.out.println("Binary comparisons: " + comparisons);
                return mid;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Binary comparisons: " + comparisons);
        return -1;
    }

    static int countOccurrences(String[] arr, String target) {
        int count = 0;
        for (String s : arr) {
            if (s.equals(target)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String[] logs = {"accA", "accB", "accB", "accC"};

        int first = linearFirst(logs, "accB");
        System.out.println("Linear first accB index: " + first);

        int last = linearLast(logs, "accB");
        System.out.println("Linear last accB index: " + last);

        Arrays.sort(logs);

        int index = binarySearch(logs, "accB");
        int count = countOccurrences(logs, "accB");

        System.out.println("Binary accB index: " + index);
        System.out.println("Count of accB: " + count);
    }
}