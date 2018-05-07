import java.util.*;

public class Factorial {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Fact fact = new Fact();
    System.out.println("Enter a number to factorialize: ");
    long f = in.nextLong();
    fact.go(f);
  }
}

class Fact{
  ArrayList<Long> set = new ArrayList<Long>();

  void go(long x) {
    for (long i = x; i >= 1; --i) {
      set.add(i);
    }
    long result = set.get(set.size()-1);
    for (int y = set.size()-1; y >= 0; --y) {
      long w = set.get(y);
      result = w * result;
    }
    System.out.println(result);
 }
}
