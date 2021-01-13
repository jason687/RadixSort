public class Radix {
  public static int nth (int n, int col) {
    int exponentVal = 1;
    for (int i = 0; col < length(n) && i < col; i++) {
      exponentVal *= 10;
    }
    return (n / exponentVal) % 10;
  }

  public static int length (int n) {
    return (int) Math.log10(n) + 1;
  }

  public static void main (String [] args) {
    System.out.println(nth(69420, 5));
  }
}
