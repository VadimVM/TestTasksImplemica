package Task3;

import java.math.BigInteger;

public class Task3 {
    //100! this is a very large number, so we will use BigInteger

    public static BigInteger getFactorial(int f) { //   this is the standard recursive algorithm for finding the factorial
        if (f <= 1) {
            return BigInteger.valueOf(1); // we use methods BigInteger to get value
        } else {
            return BigInteger.valueOf(f).multiply(getFactorial(f - 1));
        }
    }

    // in order to find the sum of the digits of the result we turn this value into a string

    public static int summOfNumber(BigInteger factorial) {
        String data = factorial.toString();
        int summ = 0;

 /* cycle over the entire length of the string
  turn elements of a string into char and then converting the values of the char through the ASCII,
  we obtain the desired values int
  */
        for (int i = 0; i < data.length(); i++) {
            int digit = (int) (data.charAt(i) - '0');
            summ = summ + digit; // here we find the sum of the digits
        }
        return summ;
    }

    public static void main(String[] args) {
        int test = 100;
        int result = summOfNumber(getFactorial(test));
        System.out.println(result);
    }
}
