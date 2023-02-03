package com.example.demo.service.struct.sort;

/**
 * @author gaonan
 * @date 2022/7/12 下午10:03
 */
public class QuickSort1 {

    public static void main(String[] args) {
        int[] arr = {4,3,6,5,11,2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(arr);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int temp = arr[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && temp <= arr[right]) {
                right--;
            }
            if (left < right) {
                arr[left++] = arr[right];
            }
            while (left < right && temp >= arr[left]) {
                left++;
            }
            if (left < right) {
                arr[right--] = arr[left];
            }
        }
        arr[left] = temp;
        quickSort(arr, start, left - 1);
        quickSort(arr, left + 1, end);
    }
}
