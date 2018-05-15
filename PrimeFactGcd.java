import java.util.*;
public class PrimeFactGcd {
public static void main(String[] args) {
  Scanner input = new Scanner(System.in);
  Scanner input2 = new Scanner(System.in);
  Tcaf tcaf = new Tcaf();
  System.out.println("Enter two integers to find their GCD.");
  System.out.println("Enter the first integer: ");
  int x = input.nextInt();
  System.out.println("Enter the second integer: ");
  int y = input2.nextInt();

  int gcd = tcaf.ex(x,y);
  if(gcd == -1)
    System.out.println("There are no common factors.");
  else
    System.out.println("The GCD is " + gcd);

 }
}
class Tcaf {
  int[] primeList = new int[] {2,3,5,7,11,13,17,19,23,29,31,
    37,41,43,47,53,59,61,71,73,79,83,89,97,101,103,107,109,113,137,
    139,149,151,157,163,167,173,179,181,191,193,197,199,211,223,227,
    229,233,239,241,251,257,263,269,271,277,281,283,293,307,311,313,317,
    331,337,347,349,353,359,367,373,379,401,409,419,421,431,433,439,443,
    449,457,461,463,467,479,487,491,499,503,509,521,523,541};
    ArrayList<Integer> setX = new ArrayList<Integer>();
    ArrayList<Integer> setY = new ArrayList<Integer>();
    ArrayList<Integer> setXY = new ArrayList<Integer>();
    int i = 0, divX = 0, modX = 0, divY = 0, modY = 0, gcd = 1;


    int ex(int x, int y) {
      int z = primeList[i];
      // Prime Factorization
      do {
        divX = x / z;
        modX = x % z;

        if(modX == 0) {
          setX.add(z);
          x = divX;
          }
        if(modX != 0) {
          ++i;
          z = primeList[i];
          }
        }
      while (x >= z);

      i = 0;
      z = primeList[i];

      do {
        divY = y / z;
        modY = y % z;

        if(modY == 0) {
          setY.add(z);
          y = divY;
        }
        if(modY != 0) {
          ++i;
          z = primeList[i];
          }
        }
      while (y >= z);
      // Compare sets and form setXY
      for(int p : setX) {
          if(setY.contains(p)) {
            setXY.add(p);
            int l = setY.indexOf(p);
            setY.remove(l);
          }
        }

      if(setXY.isEmpty()) {
        return -1;
      }
      // Multiply elements of setXY
      for(int p : setXY) {
        gcd *= p;
      }
      return gcd;
   }
 }
