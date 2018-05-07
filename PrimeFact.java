import java.util.*;
public class PrimeFact {
  public static void main(String[] args) {
  Scanner input = new Scanner(System.in);
  Factorize factorize = new Factorize();
  ArrayList<Integer> primeSet = new ArrayList<Integer>();
  System.out.println("Enter an integer to find the prime factorization.");
  int p = input.nextInt();
  primeSet = factorize.go(p);
  System.out.println(primeSet);

  }
}


class Factorize {
  ArrayList<Integer> set = new ArrayList<Integer>();
  int[] primeList = new int[] {2,3,5,7,11,13,17,19,23,29,31,
    37,41,43,47,53,59,61,71,73,79,83,89,97,101,103,107,109,113,137,
    139,149,151,157,163,167,173,179,181,191,193,197,199,211,223,227,
    229,233,239,241,251,257,263,269,271,277,281,283,293,307,311,313,317,
    331,337,347,349,353,359,367,373,379,401,409,419,421,431,433,439,443,
    449,457,461,463,467,479,487,491,499,503,509,521,523,541};

  ArrayList<Integer> go(int x) {
    int i = 0;
    int y = primeList[i];
    int div = x / y;
    int mod = x % y;
    //System.out.println("x = " + x + ", i = " + i + ", y = " + y + ", div = " + div + ", mod = " + mod);
    while (x >= y) {
      if(mod == 0) {
        set.add(y);
        y = primeList[i];
        x = div;
      //  System.out.println("x = " + x);
        div = x / y;
        mod = x % y;
      }
      else if(mod != 0) {
        ++i;
        y = primeList[i];
        div = x / y;
        mod = x % y;
      }

    }
   return set;
  }
}
