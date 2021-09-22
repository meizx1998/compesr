/*
 * QuickSort.java
 * Copyright 2021 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

import java.util.Arrays;

/**
 * Function: 
 * @date 2021/9/22
 * @author youju
 */
public class QuickSort {
    public static void sort(int[] a,int low,int high){
        int i,j,index;
        if (low>high) {
            return;
        }
        i=low;
        j=high;
        index=a[i];
        while (i<j){
            while (i<j&&a[j]>=index){
                j--;
            }
            if (i<j)
                a[i++]=a[j];
            while (i<j&&a[i]<index)
                i++;
            if (i<j){
                a[j--]=a[i];
            }
        }
        a[i]=index;
        sort(a,low,i-1);
        sort(a,i+1,high);
    }

    public static void main(String[] args) {
        int[] a={1,3,2,7,2,11,6};
        sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
