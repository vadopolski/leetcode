package newtask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class GFG {

    static List<Integer> findSum2(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length) {
            int[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }

        List<Integer> resultArr = new ArrayList<Integer>();

        int diff = arr2.length - arr1.length;
        int sum = 0;
        int other = 0;

        for (int i = arr1.length - 1; i >= 0; i--) {
            sum = arr1[i] + arr2[i + diff] + other;
            resultArr.add(sum%10);
            other = (arr1[i] + arr2[i + diff])/10;
        }

        for (int i = arr2.length - arr1.length - 1; i >= 0; i--) {
            sum = arr2[i] + other;
            resultArr.add(sum % 10);
            other = sum / 10;
        }

        if (other > 0)
            resultArr.add(other);

        Collections.reverse(resultArr);

        return resultArr;
    }

    // Function for finding sum of larger numbers
    static String findSum(String str1, String str2) {
        // Before proceeding further, make sure length
        // of str2 is larger.
        if (str1.length() > str2.length()) {
            String t = str1;
            str1 = str2;
            str2 = t;
        }

        // Take an empty String for storing result
        String str = "";

        // Calculate lenght of both String
        int n1 = str1.length(), n2 = str2.length();
        int diff = n2 - n1;

        // Initialy take carry zero
        int carry = 0;

        // Traverse from end of both Strings
        for (int i = n1 - 1; i >= 0; i--) {
            // Do school mathematics, compute sum of
            // current digits and carry
            int sum = ((int) (str1.charAt(i) - '0') +
                    (int) (str2.charAt(i + diff) - '0') + carry);
            str += (char) (sum % 10 + '0');
            carry = sum / 10;
        }

        // Add remaining digits of str2[]
        for (int i = n2 - n1 - 1; i >= 0; i--) {
            int sum = ((int) (str2.charAt(i) - '0') + carry);
            str += (char) (sum % 10 + '0');
            carry = sum / 10;
        }

        // Add remaining carry
        if (carry > 0)
            str += (char) (carry + '0');

        // reverse resultant String
        return new StringBuilder(str).reverse().toString();
    }

    // Driver code
    public static void main(String[] args) {
        String str1 = "564";
        String str2 = "1000000000000000000000000000001";

        int[] arr1 = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        int[] arr2 = {5, 6, 4};

        System.out.println(findSum(str1, str2));
        System.out.println(findSum2(arr1, arr2));
    }
}