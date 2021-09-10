import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * Step 1: Traverse the given number from the rightmost digit. Keep traversing till you get a digit which is smaller than the previously traversed digit.
 *
 * Consider if the given input number is “4128765”, Here while traversing from right, stop at 2 because 2 is smaller than next digit 8. If there is no such digit, there is no greater number.
 *
 * Number: 4128765
 *
 * Step 2: Now consider all the digits right side of 2. Find the smallest digit among them. Here smallest digit that resides right side of 2 is 5.
 *
 * Number: 4128765
 *
 * Step 3: Swap the two digits found in the above two steps. (marked in block letters)
 *
 * Number: 4158762
 *
 * Step 4: Sort all the digits right side of 5.
 *
 * Number: 4152678
 *
 * So 4152678 is the next greater number of  4128765 with the same set of digits.
 *
 * Special Cases to Find Next Greater Number with Same Set of Digits:
 * If your digits in the given number are sorted in descending order, there is no greater number with the same set of digits.
 * Example: Suppose the given number is 7432. It is the greatest number in the set of (7, 4, 3, 2). So there is no next greater number.
 * If your digits in the given number are sorted in ascending order, you just need to swap last to digits of a given number.
 * Example: Suppose the given number is 2356. Swap the last to digits, you will get next greater number as 2365.
 *
 * **/

public class NextBiggestNumberOfADigit {
    public static void main(String[] args) {
        NextBiggestNumberOfADigit nextBiggestNumberOfADigit = new NextBiggestNumberOfADigit();
        System.out.print("\033[1;33m");
        System.out.println("******** This application is to find the next biggest number of the given digits *******"    );
        System.out.println("                Please key in 'Stop' or press CTRL + C to Quit.                             ");
        System.out.println("-----------------------------------------------------------------------------------------\n  ");
        System.out.print("\033[0m");
        Scanner in = new Scanner(System.in);
        String wholeNumber = "";
        while (!wholeNumber.equalsIgnoreCase("stop")){
            System.out.print("Please enter a number to find it's next biggest number of it's digits : ");
            wholeNumber = in.nextLine();
            if (isNumeric(wholeNumber)){
                String nextBiggest = nextBiggestNumberOfADigit.getNextBigNumber(wholeNumber);
                if(wholeNumber.equals(nextBiggest)) {
                    System.out.print("\033[1;92m");
                    System.out.print(wholeNumber + " This is the biggest number.");
                    System.out.print("\033[0m");
                }else {
                    System.out.print("The nest biggest number of the whole digit is : ");
                    System.out.println(nextBiggest);
                    System.out.print("\033[1;92m");
                }
            }else{
                if(!wholeNumber.equalsIgnoreCase("stop")) {
                    System.out.print("\033[1;91m");
                    //System.out.print("\033[41m");
                    System.out.println(String.format(" ' %s ' is not a number, Please try again with a number.", wholeNumber));
                    System.out.print("\033[0m");
                }
            }
            System.out.println("\n");
        }
    }

    public String getNextBigNumber(String wholeNumber) {
        int[] nextBiggestNumber = findNextBiggestNumberOfDigits(wholeNumber);
        if(nextBiggestNumber == null){
            return wholeNumber;
        }else {
            Stream<String> numberToString = Arrays.stream(Arrays.stream(nextBiggestNumber)
                    .mapToObj(String::valueOf)
                    .toArray(String[]::new));
            return numberToString.collect(Collectors.joining(""));
        }
    }

    private int[] findNextBiggestNumberOfDigits(String wholeNumber){

        int[] digits = Arrays.stream(wholeNumber.split("")).mapToInt(Integer::parseInt).toArray();

        //Step 1 : If your digits in the given number are sorted in descending order, there is no greater number with the same set of digits.
        if (isSorted (digits, digits.length)) {
            return null;
        }

        //Step 2 : Traverse the given number from the rightmost digit. Keep traversing till you get a digit which is smaller than the previously traversed digit.
        int firstSmallest = findFirstSmallestFromRight(digits);

        //Step 3 :Swap the two digits found in the above step.
        int[] swapped = swapArrayElements(digits, firstSmallest, digits.length - 1);

        //Step 4 : Sort all the digits right side of the number that found in Step 2.
        Arrays.sort(swapped, firstSmallest + 1, swapped.length);

        return swapped;

    }

    public static boolean isNumeric(String str) {
        return str != null && str.matches("[-+]?\\d*\\.?\\d+");
    }

    private boolean isSorted (int[] digits, int index) {
        if (digits == null || digits.length <= 1 || index == 1) {
            return true;
        }
        if (digits[index - 1] > digits[index - 2]) {
            return false;
        }
        return isSorted(digits, index - 1);
    }

    private int findFirstSmallestFromRight(int[] digits){
        for (int i = digits.length-1; i >= 0; i--) {
            if(i > 1 && (digits[i] > digits[i-1]) ){

                return i - 1;
            }
        }
        return 0;
    }


    public int[] swapArrayElements(int[] A, int from, int to){
        int temp = A[from];
        A[from] = A[to];
        A[to] = temp;
        return A;
    }
}
