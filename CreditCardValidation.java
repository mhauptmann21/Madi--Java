import java.util.Scanner;

public class CreditCardValidation {
    
    public static void main(String[] args) {
        // allow the user to input the credit card number
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a credit card number: ");
        long number = input.nextLong();
        
        // set variables
        int sumEven = sumOfDoubleEvenPlace(number);
        int sumOdd = sumOfOddPlace(number);
        int totalSum = sumEven + sumOdd;
        boolean prefixMatch = prefixMatched(number, 4) || prefixMatched(number, 5) || prefixMatched(number, 37) || prefixMatched(number, 6);
        
        /* Used to debug issues
        System.out.println("Debugging Output:");
        System.out.println("------------------");
        System.out.println("Sum of double even place: " + sumEven);
        System.out.println("Sum of odd place: " + sumOdd);
        System.out.println("Total sum: " + totalSum);
        System.out.println("Prefix matched: " + prefixMatch);
        */
        
        // determines what to print depending on whether the number is valid
        if (isValid(number)) {
            System.out.println(number + " is valid.");
        } else {
            System.out.println(number + " is invalid.");
        }
    }

    // Return true if the card number is valid
    public static boolean isValid(long number) {
        int totalSum = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
        return (getSize(number) >= 13 && getSize(number) <= 16) &&
               (prefixMatched(number, 4) || prefixMatched(number, 5) ||
                prefixMatched(number, 37) || prefixMatched(number, 6)) &&
               (totalSum % 10 == 0);
    }
    //Get the result from Step 2
    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;
        String num = Long.toString(number);
        for (int i = num.length() - 2; i >= 0; i -= 2) {
            int doubled = Character.getNumericValue(num.charAt(i)) * 2;
            int digitSum = getDigit(doubled);
            sum += digitSum;
        }
        return sum;
    }

    //Return this number if it is a single digit, otherwise, return the sum of the two digits
    public static int getDigit(int number) {
        return (number < 10) ? number : number / 10 + number % 10;
    }

    //Return sum of odd-place digits in number
    public static int sumOfOddPlace(long number) {
        int sum = 0;
        String num = Long.toString(number);
        for (int i = num.length() - 1; i >= 0; i -= 2) {
            sum += Character.getNumericValue(num.charAt(i));
        }
        return sum;
    }

    //Return true if the number d is a prefix for number
    public static boolean prefixMatched(long number, int d) {
        return getPrefix(number, getSize(d)) == d;
    }

    //Return the number of digits in d
    public static int getSize(long d) {
        return String.valueOf(d).length();
    }

    /* 
    Return the first k number of digits from number. If the
    number of digits in number is less than k, return number.
     */
    public static long getPrefix(long number, int k) {
        String numStr = String.valueOf(number);
        if (numStr.length() < k) {
            return number;
        }
        return Long.parseLong(numStr.substring(0, k));
    }
}
