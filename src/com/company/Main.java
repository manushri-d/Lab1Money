//Goal: Create a data abstraction to represent Money.

package com.company;

public class Main {

    public static void main(String[] args) {
        // This is main where we test!
        System.out.println(moneyToString(10, 8));
        printSum(5,1,5,1);
        System.out.println(biggestMoney(5, 1, 6, 1, 7, 1));
        System.out.println(biggestMoney(5, 1, 5, 2, 5, 3));
        System.out.println(biggestMoney(6, 5, 6, 9, 7, 99));
        System.out.println(biggestMoney(0, 10, 6, 1, 1, 1));
        System.out.println(biggestMoney(5, 1, 5, 1, 9, 1));
        System.out.println(biggestMoney(5, 1, 9, 1, 5, 1));
        System.out.println(biggestMoney(9, 1, 5, 1, 5, 1));
        System.out.println(biggestMoney(5, 9, 6, 1, 5, 1));
        System.out.println(biggestMoney(5, 9, 5, 5, 5, 5));

        printChangeFrom20(3, 91);
    }

    //TASK 1
    public static String moneyToString(int d, int c) {
        if (c < 10)
            return "$" + d + ".0" + c;//because it is less than 10, so cents need to be printed like .09 and not .9
        else return "$" + d + "." + c;
    }//End moneyToString

    //TASK 2
    //Print the sum of monies. Ex, printSum(10,24,3,90)
    public static void printSum(int d1, int c1, int d2, int c2) {
        int dollars = d1 + d2;
        int cents = c1 + c2; // What if above or equal to 100?
        while (cents >= 100) {
            dollars = dollars + 1; //We add 1, because the max cents we really have as stated by assumptions is 99 cents. so 99 cents plus 99 cents is 198, which only adds a dollar at the max.
            cents = cents - 100;
        }
        if (cents < 10)
            System.out.println("$" + dollars + ".0" + cents);

        else {
            System.out.println("$" + dollars + "." + cents);

        }
    }//End printSum

    //TASK 3
    public static int biggestMoney(int d1, int c1, int d2, int c2, int d3, int c3){
        if (d1 == d2 && d2 == d3)//checking all the values
            if (c1 > c2 && c1 > c3)
                return 1;
            else if (c2 > c1 && c2 > c3)
                return 2;
            else {
                return 3;
            }
        else if (d1 == d2 && d3 < d1)
            if (c1 > c2)
                return 1;
            else {
                return 2;
            }
        else if (d2 == d3 && d1 < d2)//double equal cause not setting it--checks if condition is met
            if (c2 > c3)
                return 2;
            else {
                return 3;
            }
        else if (d1 >= d2 && d1 >= d3)
            return 1;
        else if (d2 >= d1 && d2 >= d3)
            return 2;
        else {
            return 3;
        }//End biggestMoney
    }

    //TASK 4
    public static void printChangeFrom20(int d, int c){
        int valueOfDollar = 19 - d; //not 20 because it is always less than that
        int valueOfCents = 100 - c;
        if (valueOfCents == 100)
            System.out.println("$" + valueOfDollar + 1 + ".00");
        else if (valueOfCents < 10)
            System.out.println("$" + valueOfDollar + ".0"+ valueOfCents);
        else {
            System.out.println("$" + valueOfDollar + "."+ valueOfCents);
        }
    }//End printChangeFrom20

}
