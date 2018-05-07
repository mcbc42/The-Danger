import java.util.*;
public class Gcd {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Scanner input2 = new Scanner(System.in);
    Machine machine = new Machine();
    System.out.println("Enter two integers to find their GCD.");
    System.out.println("Enter the first integer:");
    int x = input.nextInt();
    System.out.println("Enter the second integer:");
    int y = input2.nextInt();
    int result = machine.doIt(x,y);
    if(result == 0)
     System.out.println("There are no common factors.");
    else
     System.out.println("The GCD is " + result);
  }
}
class Machine {
  int c = 0;
  int d = 0;
  ArrayList<Integer> set1 = new ArrayList<Integer>();
  ArrayList<Integer> set2 = new ArrayList<Integer>();
  ArrayList<Integer> set3 = new ArrayList<Integer>();

  int doIt(int a, int b) {

    if (b > a) {
      c = b;
      d = a;
    }
    else {
      c = a;
      d = b;
    }

    for(int x = 1; x < c; ++x) {
      int l = c / x;
      int m = c % x;
      if (m == 0)
        set1.add(l);
    }

    for(int x = 1; x < d; ++x) {
      int l = d / x;
      int m = d % x;
      if (m == 0)
        set2.add(l);
    }

    for(int x = 0; x < set1.size(); ++x) {
      int g = set1.get(x);
      if(set2.contains(g))
       set3.add(g);
    }

    if(set3.isEmpty())
      return 0;
    else
      return set3.get(0);
  }
}
