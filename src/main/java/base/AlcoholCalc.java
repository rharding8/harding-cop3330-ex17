/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Ryan Harding
 */

package base;

import java.util.Scanner;

public class AlcoholCalc {
  Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    AlcoholCalc legal = new AlcoholCalc();
    int weight = legal.getWeight();
    double ratio = legal.getGender();
    double alcohol = legal.getAlcohol();
    int last = legal.lastDrink();
    System.out.println(legal.checkLegal(legal.checkBAC(weight, ratio, alcohol, last)));
  }

  public int getWeight() {
    System.out.print("How much do you weigh (lbs)? ");
    String n = input.next();
    try {
      Integer.parseInt(n);
    }
    catch (NumberFormatException e) {
      System.out.println("ERROR: Invalid number provided!");
      return getWeight();
    }
    return Integer.parseInt(n);
  }

  public double getGender() {
    System.out.print("What is your biological gender? ");
    String gender = input.next();
    if (gender.equalsIgnoreCase("male")) {
      return 0.73;
    }
    else if (gender.equalsIgnoreCase("female")) {
      return 0.66;
    }
    else {
      System.out.println("ERROR: Gender entered not a biological gender, try again.");
      return getGender();
    }
  }

  public double getAlcohol() {
    System.out.print("How much total alcohol have you consumed (Oz)? ");
    String n = input.next();
    try {
      Double.parseDouble(n);
    }
    catch (NumberFormatException e) {
      System.out.println("ERROR: Invalid number provided!");
      return getAlcohol();
    }
    return Double.parseDouble(n);
  }

  public int lastDrink() {
    System.out.print("How long has it been since your last drink (Hours)? ");
    String n = input.next();
    try {
      Integer.parseInt(n);
    }
    catch (NumberFormatException e) {
      System.out.println("ERROR: Invalid number provided!");
      return lastDrink();
    }
    return Integer.parseInt(n);
  }

  public double checkBAC(int weight, double gender, double alcohol, int last) {
    return (alcohol * 5.14 / weight * gender) - 0.015 * last;
  }

  public String checkLegal(double content) {
    System.out.printf("Your BAC is %.2f%n", content);
    String legality = content < 0.08 ? " " : " not ";
    return "It is" + legality + "legal for you to drive.";
  }
}
