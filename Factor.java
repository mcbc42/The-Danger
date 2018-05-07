import java.util.*;

public class Factor {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    FactorList list = new FactorList();

    System.out.println("Enter a number to find its factors: ");
    int h = input.nextInt();
    list.test(h);
    }
  }

class FactorList {
  ArrayList<Integer> answers = new ArrayList<Integer>();

  void test(int x) {
    for (int i = 1; i <= x; ++i) {
    int y = x / i;
    int z = x % i;

    if (z == 0)
      answers.add(y);
    }
    System.out.println(answers);
  }
}
