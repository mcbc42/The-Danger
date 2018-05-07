import java.util.Scanner;
public class Calc {
  public static void main(String[] args) {
  Perform perform = new Perform();
  Scanner input = new Scanner(System.in);
  Scanner input1 = new Scanner(System.in);
  Scanner input2 = new Scanner(System.in);

  System.out.println("Enter the first number: ");
  double num1 = input.nextDouble();
  System.out.println("Enter the operator: ");
  char op = input1.next().charAt(0);
  System.out.println("Enter the second number: ");
  double num2 = input2.nextDouble();

  perform.go(num1, num2, op);
  }
}

class Perform {
  double answer = 0.0;
  Add add = new Add();
  Sub sub = new Sub();
  Div div = new Div();
  Mult mult = new Mult();

  void go(double a, double b, char c) {
    if (c == '+') {
      answer = add.go(a, b);
      System.out.println("The answer is: " + answer);
    } else if (c == '-') {
      answer = sub.go(a, b);
      System.out.println("The answer is: " + answer);
    } else if (c == '*') {
      answer = mult.go(a, b);
      System.out.println("The answer is: " + answer);
    } else if (c == '/') {
      answer = div.go(a, b);
      System.out.println("The answer is: " + answer);
    } else
    System.out.println("Error");
  }
}

class Function {
  double go(double a, double b) {
    double x = 0;
    return x;
  }
}

class Add extends Function {
     double go(double a, double b) {
      double x = a + b;
      return x;
  }
}

class Sub extends Function {
  double go(double a, double b) {
    double x = a - b;
    return x;
  }
}

class Div extends Function {
  double go(double a, double b) {
    double x = a / b;
    return x;
  }
}

class Mult extends Function {
  double go(double a, double b) {
    double x = a * b;
    return x;
  }
}
