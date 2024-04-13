
package com.pluralsight;

import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which Calculator would you Like to use?");
        System.out.println("Enter 1 for Mortgage Calculator");
        System.out.println("Enter 2 for Future value Calculator");
        System.out.println("Enter 3 for Present Value Calculator");
        int command = scanner.nextInt();
        if (command == 1) {
            mortgageCalculator();
        } else if (command == 2) {
            futureValueCalculator();
        } else if (command == 3) {
            presentValueCalculator();
        } else {
            System.out.println("Invalid");
        }
    }
    public static void mortgageCalculator() {
        Scanner input = new Scanner(System.in);
        //double loanLength = 0;
        //double principal = 0;
       // double interestRate = 0;

        System.out.println("what is your principal");
        double principalAmt = input.nextDouble();
        System.out.println("What is your interest rate");
        double interestRateAmt = input.nextDouble();
        System.out.println("What is your loan Length");
        double loanLengthAmt = input.nextDouble();
        //Calculate monthly interest rate
        double monthlyInterestRate = interestRateAmt / 1200;
        double monthlyTotalMonth = loanLengthAmt * 12;
        double monthlyPayment = (principalAmt * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, monthlyTotalMonth)) / (Math.pow(1 + monthlyInterestRate, monthlyTotalMonth) - 1));
        double totalInterest = monthlyPayment * monthlyTotalMonth - principalAmt;
        //Display the results
        System.out.println("Your expected monthly payment is: " + String.format("%.2f", monthlyPayment));
        System.out.println("total interest paid = " + String.format("%.2f", totalInterest));

    }
    public static void futureValueCalculator() {
        Scanner value = new Scanner(System.in);
        System.out.println("If you deposit ");
        double initialDeposit = value.nextDouble();
        System.out.println("What is your interest rate ");
        double annualInterestRate = value.nextDouble();
        System.out.println("Enter number of the years: ");
        double termsOfYear = value.nextDouble();
        //Calculate future value using interest formula
        double interset = annualInterestRate / 100;
        double matures = initialDeposit * Math.pow(1 + interset / 365, 365 * termsOfYear);
        double totalInterestEraned = matures - initialDeposit;
        //Display the results
        System.out.println("CD yearly balance is: " + String.format("%.2f", matures));
        System.out.println(" Annual the total interest earned of = " + String.format("%.2f", totalInterestEraned));
    }
        public static void presentValueCalculator() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("The accept monthly payout is ");
            double monthlyPayOut = scanner.nextDouble();
            System.out.println("The earns an expected interest rate ");
            double expectedInterestRate = scanner.nextDouble();
            System.out.println("Enter number of the years: ");
            double yearsPayOut = scanner.nextDouble();
            //Calculate monthly interest rate
            double intresetMonthly = expectedInterestRate / 1200;
            //Calculate total number of payment
            double totalMonthly = yearsPayOut * 12;
            //Calculate today value
            double todayValue = monthlyPayOut * (1 - Math.pow(1 + intresetMonthly, -totalMonthly)) / intresetMonthly;
            //Display the results
            System.out.printf("You will invest $" + String.format("%.2f", todayValue));


        }
    }