package com.yue.learning.algorithm.string;

public class StringSum {

    public static void main(String[] args) {
        System.out.println(sum("999","2"));
    }

    private static String sum(String a, String b) {

        int i = 0;
        StringBuilder builder = new StringBuilder();
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        int aIndex = aArr.length - 1;
        int bIndex = bArr.length - 1;
        char sum;
        do {
            int aNumber = aIndex>=0?(aArr[aIndex] - '0'):0;
            int bNumber = bIndex>=0?(bArr[bIndex] - '0'):0;
            sum = (char) (((i+aNumber + bNumber) % 10 + '0'));
            builder.append(sum);
            i = (i+aNumber + bNumber) / 10;
            aIndex--;
            bIndex--;
        }while (aIndex >= 0 || bIndex >= 0 || i > 0);

        char[] arr = builder.toString().toCharArray();
        int m = 0;
        int n = arr.length - 1;
        while (m < n) {
            swap(arr, m, n);
            m++;
            n--;
        }
        return String.valueOf(arr);
    }

    private static void swap(char[] arr, int m, int n) {
        char temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }
}
