package com.soup.memo.leetcode;

/**
 * 回文数
 *
 * 环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 - 1]
 *
 * @author zhaoyi
 */
public class ReverseInteger {

    public int reverse(int x) {
        String temp = x + "";
        char[] arr = temp.toCharArray();

        char t = arr[0];
        char[] newInt;
        if (t == '-') {
            newInt = new char[arr.length - 1];
        } else {
            newInt = new char[arr.length];
        }

        int j = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != '-') {
                newInt[j] = arr[i];
            }
            j++;
        }
        String resultStr = new String(newInt);
        int result = 0;
        try {
            result = Integer.parseInt(resultStr);
        } catch (NumberFormatException e) {

        }
        if (t == '-') {
            result = 0 - result;
        }

        double max = Math.pow(2, 31);
        if (result > max - 1 || result < -max) {
            return 0;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(1534236469));
    }

}
