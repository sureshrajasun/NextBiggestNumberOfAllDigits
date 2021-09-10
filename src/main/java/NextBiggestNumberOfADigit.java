public class NextBiggestNumberOfADigit {

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

    public static void main(String[] args) {
        System.out.println("******** This application is to find the next biggest number of the given digits *******");
        System.out.println("                Please key in 'Stop' or press CTRL + C to Quit.                             ");
        System.out.println("-----------------------------------------------------------------------------------------\n  ");
    }


}
