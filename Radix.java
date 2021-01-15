public class Radix {
  public static int nth (int n, int col) {
    if (col >= length(n)) {
      return 0;
    }
    return (int) Math.abs((n / Math.pow(10, col)) % 10);
  }

  public static int length (int n) {
    if (n == -2147483648) {
      n += 1;
    }
    if (n < 0) {
      n = Math.abs(n);
    }
    if (n == 0) {
      return 1;
    }

    return (int) Math.log10(n) + 1;
  }

  public static void merge (SortableLinkedList original, SortableLinkedList [] buckets) {
    for (int i = 0; i < buckets.length; i++) {
      original.extend(buckets[i]);
    }
  }

  public static void radixSortSimple (SortableLinkedList data) {
    SortableLinkedList [] buckets = new SortableLinkedList [10];
    int sizeBig = 1;
    int a = 0;
    for (int i = 0; i < 10; i++) {
      buckets[i] = new SortableLinkedList();
    }
    for (int j = 0; j < sizeBig; j++) {
      while (data.size() != 0) {
        a = data.remove(0);
        if (j == 0 && sizeBig < length(a)) {
          sizeBig = length(a);
        }
        buckets[nth(a, j)].add(a);
      }
      merge(data, buckets);
    }
  }

  public static void radixSort (SortableLinkedList data) {
    SortableLinkedList [] buckets = new SortableLinkedList [19];
    int sizeBig = 1;
    int a = 0;
    for (int i = 0; i < 19; i++) {
      buckets[i] = new SortableLinkedList();
    }
    for (int j = 0; j < sizeBig; j++) {
      while (data.size() != 0) {
        a = data.remove(0);
        if (j == 0 && sizeBig < length(a)) {
          sizeBig = length(a);
        }
        if (a < 0) {
          buckets[9 - nth(a, j)].add(a);
        } else {
          buckets[9 + nth(a, j)].add(a);
        }
      }
      merge(data, buckets);
    }
  }
}
