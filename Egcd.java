import java.util.*;
public class Egcd {
  public static void main(String[] args) {
  Euclid euclid = new Euclid();
  Scanner input1 = new Scanner(System.in);
  Scanner input2 = new Scanner(System.in);
  System.out.println("Enter two integers to find their GCD.");
  System.out.println("Enter the first integer.");
  int x = input1.nextInt();
  System.out.println("Enter the second integer.");
  int y = input2.nextInt();
  int result = euclid.go(x,y);
  if(result == -1)
   System.out.println("There are no common factors.");
  else
   System.out.println("The GCD is " + result);

  }
}
class Euclid {
  int a = 0;
  int b = 0;

  int go(int x, int y) {
    if(y > x) {
      a = y;
      b = x;
    }
    else {
      a = x;
      b = y;
    }

    int div = a / b;
    int mod = a % b;
    
    while(mod != 0) {
      a = b;
      b = mod;
      div = a / b;
      mod = a % b;
    }
    if(mod == 0 && b > 1) {
      return b;
    }
    else
      return -1;
  }
}
