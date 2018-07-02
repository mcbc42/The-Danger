import java.util.*;

public class LongDiv {
  public static void main(String[] args) {
    Scanner input1 = new Scanner(System.in);
    Scanner input2 = new Scanner(System.in);
    int divisor = 0, dividend = 0;
    double result = 0.0d;
    Divide div = new Divide();

    System.out.println("Enter the dividend: ");
    dividend = input1.nextInt();
    System.out.println("Enter the divisor: ");
    divisor = input2.nextInt();
    result = div.rip(dividend, divisor);
    System.out.println(dividend + " divided by " + divisor + " is " + result);

  }
}

class Divide {
  ArrayList<Integer> list = new ArrayList<Integer>();
  ArrayList<Integer> numList = new ArrayList<Integer>();
  double result = 0.0d;
  long power = 1L, step1 = 0L, step2 = 0L;


  ArrayList<Integer> convert(int dividend) {
    String num = String.valueOf(dividend);
    for(int i = 0; i < num.length(); ++i) {
      char c = num.charAt(i);
      int x = Character.getNumericValue(c);
      list.add(x);
    }
    return list;
  }

  long ansMake(ArrayList<Integer> list) {
    for(int i = 0; i < list.size()-1; ++i)
      power *= 10;

    for(int i = 0; i <= list.size()-1; ++i) {
      step1 = list.get(i) * power;
      step2 += step1;
      power /= 10;
    }

    return step2;
  }

  double rip(int dividend, int divisor) {
    int temp = 0, sub = 0, count = 0, power = 1,
        first = 0, sec = 0, third = 0;
    ArrayList<Integer> ansList = new ArrayList<Integer>();

    numList.addAll(this.convert(dividend));

    if(divisor > numList.get(0)) {
      first = numList.get(0);
      sec = numList.get(1);
      third = (first * 10) + sec;
      numList.add(0, third);
      numList.remove(1);
      numList.remove(1);
    }

    for(int i = 0; i <= numList.size()-1; ++i) {

      if(i == 0){
        ansList.add(numList.get(i) / divisor);
        sub = numList.get(i) % divisor;
      }

      if(i != 0){
        temp = (sub * 10) + numList.get(i);
        ansList.add(temp / divisor);
        sub = temp % divisor;
     }
    }

    if(sub == 0) {
      result = this.ansMake(ansList);
      return result;
    }

    do{
      temp = sub * 10;
      ansList.add(temp / divisor);
      sub = temp % divisor;
      ++count;
    } while(count < 8 & sub != 0);

    result = this.ansMake(ansList);

    for(int i = 0; i <= count-1; ++i)
      power *= 10;

    result /= power;

    return result;
  }
}
