public class Radix {
  public static int nth (int n, int col) {
    int exponentVal = 1;
    if (col >= length(n)) {
      return 0;
    }
    for (int i = 0; col < length(n) && i < col; i++) {
      exponentVal *= 10;
    }
    return (n / exponentVal) % 10;
  }

  public static int length (int n) {
    if (n < 0) {
      n = Math.abs(n);
    }
    if (n == 0) {
      return 1;
    }
    return (int) Math.log10(n) + 1;
  }

  public static void main (String [] args) {
    System.out.println(length(-100));
  }

  public static void merge (SortableLinkedList original, SortableLinkedList [] buckets) {
    for (int i = 0; i < buckets.length; i++) {
      original.extend(buckets[i]);
      // System.out.println(original);
    }
  }

  public static void radixSortSimple (SortableLinkedList data) {
    SortableLinkedList [] buckets = new SortableLinkedList [10];
    int sizeBig = 1;
    for (int i = 0; i < 10; i++) {
      buckets[i] = new SortableLinkedList();
    }
    for (int j = 0; j < sizeBig; j++) {
      for (int i = 0; i < data.size(); i++) {
        if (j == 0 && data.get(i) > sizeBig) {
          sizeBig = length(data.get(i));
        }
        buckets[(nth(data.get(i), j))].add(data.get(i));
      }
      for (int i = 0; i < data.size(); ) {
        data.remove(0);
      }
      merge(data, buckets);
    }
  }

  public static void radixSort (SortableLinkedList data) {
    
  }
}
