import java.util.*;

class Asset {
    String name;
    double returnRate;
    double volatility;

    Asset(String name, double returnRate, double volatility) {
        this.name = name;
        this.returnRate = returnRate;
        this.volatility = volatility;
    }

    public String toString() {
        return name + ":" + returnRate + "%";
    }
}

public class PortfolioReturnSorter {

    static List<Asset> mergeSort(List<Asset> list) {
        if (list.size() <= 1) return list;

        int mid = list.size() / 2;
        List<Asset> left = mergeSort(new ArrayList<>(list.subList(0, mid)));
        List<Asset> right = mergeSort(new ArrayList<>(list.subList(mid, list.size())));

        return merge(left, right);
    }

    static List<Asset> merge(List<Asset> left, List<Asset> right) {
        List<Asset> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).returnRate <= right.get(j).returnRate) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }

        while (i < left.size()) result.add(left.get(i++));
        while (j < right.size()) result.add(right.get(j++));

        return result;
    }

    static void quickSort(List<Asset> list, int low, int high) {
        if (low < high) {
            int pi = partition(list, low, high);
            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }

    static int partition(List<Asset> list, int low, int high) {
        Asset pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list.get(j).returnRate > pivot.returnRate ||
                    (list.get(j).returnRate == pivot.returnRate &&
                            list.get(j).volatility < pivot.volatility)) {
                i++;
                Collections.swap(list, i, j);
            }
        }

        Collections.swap(list, i + 1, high);
        return i + 1;
    }

    public static void main(String[] args) {
        List<Asset> assets = new ArrayList<>();
        assets.add(new Asset("AAPL", 12, 5));
        assets.add(new Asset("TSLA", 8, 9));
        assets.add(new Asset("GOOG", 15, 4));

        List<Asset> mergeSorted = mergeSort(assets);
        System.out.println("Merge Sort (asc): " + mergeSorted);

        List<Asset> quickList = new ArrayList<>(assets);
        quickSort(quickList, 0, quickList.size() - 1);
        System.out.println("Quick Sort (desc): " + quickList);
    }
}