import java.util.*;
public class SRoot {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    ArrayList<Integer> workList = new ArrayList<Integer>();
    float result = 0f;

    System.out.println("Enter an integer to find the square root: ");
    String sqrt = input.nextLine();
    Root root = new Root();

    workList.addAll(root.extract(sqrt));
    result = root.work(workList);

   System.out.println("The square root is: " + result);
  }
}

class Root {
  ArrayList<Character> charList = new ArrayList<Character>();
  ArrayList<Integer> workList = new ArrayList<Integer>();
  ArrayList<Integer> ansList = new ArrayList<Integer>();

  ArrayList<Integer> extract(String stg) {
   for(int i = 0; i < stg.length(); ++i) {
     char f = stg.charAt(i);
     charList.add(f);
   }
   if (charList.size() == 1) {
   char a = charList.get(0);
   int b = Character.getNumericValue(a);
   workList.add(b);
 }
   if(charList.size() % 2 == 0) {
     do {
       char a = charList.get(0);
       char b = charList.get(1);
       charList.remove(0);
       charList.remove(0);
       int c = Character.getNumericValue(a);
       int d = Character.getNumericValue(b);
       int e = (c * 10) + d;
       workList.add(e);
     }
     while(charList.size() >= 2);
  }
   if(charList.size() % 2 != 0 && charList.size() > 1) {
    char a = charList.get(0);
    int b = Character.getNumericValue(a);
    workList.add(b);
    charList.remove(0);
    do {
      char e = charList.get(0);
      char f = charList.get(1);
      charList.remove(0);
      charList.remove(0);
      int g = Character.getNumericValue(e);
      int h = Character.getNumericValue(f);
      int i = (g * 10) + h;
      workList.add(i);
    }
    while(charList.size() >= 2);
   }
   return workList;
  }

  int rootFind(int src) {
   int check = 0;
   int sq = 0;

   if(src == 1){
     ansList.add(1);
     return 1;
   }
   for(int i = 1; check <= src; ++i){
     check = i * i;
     sq = i;
    }
    --sq;
    ansList.add(sq);
    check = sq * sq;
    return check;
  }

  int subFind(int a, int b) {

    int z = (a-b) * 100;

    return z;
  }

  int multFind(int next, int a) {
    int ans = a * 20;
    int guess = 0;
    int b = 0;

    for(int i = 0; guess <= next; ++i) {
     ans = a * 20;
     guess = (ans + i) * i;
     b = i;
    }
    --b;
    ans = a * 20;
    guess = (ans + b) * b;
    ansList.add(b);
    return guess;
  }

   int ansFind(ArrayList<Integer> list){
     ArrayList<Integer> tempList = new ArrayList<Integer>();
     ArrayList<Integer> addStep = new ArrayList<Integer>();
     int power = 1;
     int a = 0;
     int rst = 0;
     int add = 0;
     tempList.addAll(list);

     int size = tempList.size();



     if(size == 1)
       return tempList.get(0);

     for(int i = size-1; i > 0; --i)
       power *= 10;


     while(!(tempList.isEmpty())){
       a = tempList.get(0);
       rst = a * power;
       addStep.add(rst);
       power /= 10;
       tempList.remove(0);
       }

     for(int i : addStep)
       add += i;

     return add;
   }

   float work(ArrayList<Integer> exList) {
     int check = 0;
     int next = 0;
     int ans = 0;
     int x = 0;
     float y = 0f;

     if(exList.size() == 1) {
       check = this.rootFind(exList.get(0));
       next = this.subFind(exList.get(0), check);
       if(next == 0){
         y = (float)ansList.get(0);
         return y;
       }
     x = this.multFind(next, ansList.get(0));
     y = (float)this.ansFind(ansList);
     y /= 10;
     return y;
     }

     for(int i = 0; i <= exList.size()+2; ++i){
       if(i == 0) {
         check = this.rootFind(exList.get(i));
         next = this.subFind(exList.get(i), check);
         next += exList.get(i+1);
       }
       if(!(i == 0)) {
        ans = this.ansFind(ansList);
        check = this.multFind(next, ans);
        next = this.subFind(next, check);
        if(exList.size() > i+1)
          next += exList.get(i+1);
       }
     }

     y = (float)this.ansFind(ansList);
     y /= 1000;
     return y;
   }
}
