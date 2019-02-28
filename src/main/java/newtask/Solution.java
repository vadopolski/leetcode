package newtask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    static List<Integer> findSum2(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length) {
            int[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }

        List<Integer> resultArr = new ArrayList<>();

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

        if (other > 0) resultArr.add(other);
        Collections.reverse(resultArr);

        return resultArr;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        long result = nodeToInt(l1) + nodeToInt(l2);
        ListNode node = intToNode(result);

        return node;
    }

    private ListNode intToNode(long result) {
        StringBuilder resultString = new StringBuilder(String.valueOf(result));
        resultString.reverse();

        ListNode next = new ListNode(Integer.valueOf(resultString.charAt(0) + ""));
        ListNode resultNode;

        int i = 1;
        while (i < resultString.length()) {
            resultNode = new ListNode(Integer.valueOf(resultString.charAt(i) + ""));
            resultNode.next = next;
            next = resultNode;
            i++;
        }

        System.out.println(resultString);
        return next;
    }

    private long nodeToInt(ListNode firstNode) {
        String result = "";
        ListNode node = firstNode;

        do {
            result += String.valueOf(node.val);
            node = node.next;
        } while (node != null);

        return Long.valueOf(result);
    }

    private int[] nodeToArr(ListNode firstNode) {
        ArrayList<Integer> result = new ArrayList();
        ListNode node = firstNode;

        do {
            result.add(node.val);
            node = node.next;
        } while (node != null);

        return result.stream().mapToInt(x -> x).toArray();
    }


    public static void main(String[] args) {
        Solution sol = new Solution();

        ListNode node3 = sol.intToNode(3999999999L);
        ListNode node33 = sol.intToNode(0);

        System.out.println(sol.addTwoNumbers(node3, node33));
    }
}