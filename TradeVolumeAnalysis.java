Use this file name:

**TradeVolumeAnalysis.java**

```java id="tva01"
import java.util.*;

class Trade {
    String id;
    int volume;

    Trade(String id, int volume) {
        this.id = id;
        this.volume = volume;
    }

    public String toString() {
        return id + ":" + volume;
    }
}

public class TradeVolumeAnalysis {

    static List<Trade> mergeSort(List<Trade> list) {
        if (list.size() <= 1) return list;

        int mid = list.size() / 2;
        List<Trade> left = mergeSort(new ArrayList<>(list.subList(0, mid)));
        List<Trade> right = mergeSort(new ArrayList<>(list.subList(mid, list.size())));

        return merge(left, right);
    }

    static List<Trade> merge(List<Trade> left, List<Trade> right) {
        List<Trade> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).volume <= right.get(j).volume) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }

        while (i < left.size()) result.add(left.get(i++));
        while (j < right.size()) result.add(right.get(j++));

        return result;
    }

    static void quickSort(List<Trade> list, int low, int high) {
        if (low < high) {
            int pi = partition(list, low, high);
            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }

    static int partition(List<Trade> list, int low, int high) {
        int pivot = list.get(high).volume;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list.get(j).volume > pivot) {
                i++;
                Collections.swap(list, i, j);
            }
        }

        Collections.swap(list, i + 1, high);
        return i + 1;
    }

    static List<Trade> mergeTwoSorted(List<Trade> a, List<Trade> b) {
        return merge(a, b);
    }

    static int totalVolume(List<Trade> list) {
        int sum = 0;
        for (Trade t : list) sum += t.volume;
        return sum;
    }

    public static void main(String[] args) {
        List<Trade> trades = new ArrayList<>();
        trades.add(new Trade("trade3", 500));
        trades.add(new Trade("trade1", 100));
        trades.add(new Trade("trade2", 300));

        List<Trade> mergeSorted = mergeSort(trades);
        System.out.println("Merge Sort (asc): " + mergeSorted);

        List<Trade> quickList = new ArrayList<>(trades);
        quickSort(quickList, 0, quickList.size() - 1);
        System.out.println("Quick Sort (desc): " + quickList);

        List<Trade> merged = mergeTwoSorted(mergeSorted, mergeSorted);
        System.out.println("Merged list: " + merged);

        int total = totalVolume(merged);
        System.out.println("Total Volume: " + total);
    }
}

