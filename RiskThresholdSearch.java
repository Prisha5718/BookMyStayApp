import java.util.*;

public class RiskThresholdSearch {

    static int linearSearch(int[] arr, int target) {
        int comparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear comparisons: " + comparisons);
                return i;
            }
        }
        System.out.println("Linear comparisons: " + comparisons);
        return -1;
    }

    static int floor(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid] <= target) {
                ans = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Binary comparisons (floor): " + comparisons);
        return ans;
    }

    static int ceiling(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid] >= target) {
                ans = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println("Binary comparisons (ceiling): " + comparisons);
        return ans;
    }

    static int insertionPoint(int[] arr, int target) {
        int low = 0, high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < target) low = mid + 1;
            else high = mid;
        }

        return low;
    }

    public static void main(String[] args) {
        int[] risks = {10, 25, 50, 100};

        int lin = linearSearch(risks, 30);
        System.out.println("Linear search result: " + lin);

        int f = floor(risks, 30);
        int c = ceiling(risks, 30);
        System.out.println("Floor: " + f + ", Ceiling: " + c);

        int pos = insertionPoint(risks, 30);
        System.out.println("Insertion point for 30: " + pos);
    }
}