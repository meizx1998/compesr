/*
 * Main.java
 * Copyright 2021 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Function: 
 * @date 2021/9/22
 * @author youju
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] booksCount = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                booksCount[i] = sc.nextInt();
            } else {
                booksCount[i] = sc.nextInt() + booksCount[i - 1];
            }
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int b = sc.nextInt();
            int floor = 1;
            int count = 0;
            int left = 0;
            int right = n - 1;
            int mid;
            while (left != right&&Math.abs(left-right)>1) {
                mid = (left + right) / 2;
                if (booksCount[mid] > b) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            System.out.println(right);
        }
    }

    public int minEffort(ArrayList<Integer> cases) {
        // write code here
        cases.sort(Comparator.comparingInt(a -> a));
        int sum=0;
        int flag=0;
        int res=0;
        for (final Integer aCase : cases) {
            if (flag==0){
                res+=aCase;
                flag=1;
            }
            else {
                flag=0;
                res+=aCase;
                sum=sum*2+res;
                res=0;
            }
        }
        sum+=res;
        return sum;
    }
}
