package com.example.demo.service.struct.sort;

import java.util.Arrays;

/**
 * @author gaonan1
 * @date 2021/10/10 15:53
 **/
public class HeapSort {

    public static void main(String[] args) {
        int[] nums = {15, 13, 1, 5, 20, 11, 18};
        // 测试建堆
        buildHeap(nums);
        System.out.println(Arrays.toString(nums));
        // 测试直接将新元素替换堆顶，并进行下沉
        nums[0] = 7;
        siftDown(nums, 0, nums.length - 1);

        // 建堆以后可以进行排序
        int tail = nums.length - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = nums[tail];
            nums[tail] = nums[0];
            nums[0] = temp;
            siftDown(nums, 0, --tail);
        }
        // 倒序
        for (int i = nums.length - 1; i >= 0; i--) {
            System.out.print(nums[i] + " ");
        }
        System.out.print("\n");

        // 删除元素
        delete(nums, nums.length - 1);
        delete(nums, nums.length - 2);
        System.out.println(Arrays.toString(nums));

        // 插入元素
        insert(nums, nums.length - 3, 8);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 构建堆
     *
     * @param nums
     */
    public static void buildHeap(int[] nums) {
        // 从最后一个节点的父节点，往前面遍历
        for (int i = (nums.length - 2) / 2; i >= 0; i--) {
            siftDown(nums, i, nums.length - 1);
        }
    }

    /**
     * 删除
     *
     * @param nums
     * @param tail 末尾下标
     */
    public static void delete(int[] nums, int tail) {
        nums[0] = nums[tail];
        siftDown(nums, 0, tail - 1);
    }

    /**
     * 插入
     *
     * @param nums
     * @param tail 末尾下标
     * @param val  插入值
     */
    public static void insert(int[] nums, int tail, int val) {
        nums[tail + 1] = val;
        siftUp(nums, val, tail + 1);
    }


    /**
     * 上浮，插入元素时使用
     *
     * @param nums 存放数据的数组
     * @param val  插入元素值
     * @param k    插入位置
     */
    public static void siftUp(int[] nums, int val, int k) {
        while (k > 0) {
            int parent = (k - 1) / 2;
            // 父元素小于当前元素，不用调整
            if (nums[parent] <= val) {
                break;
            }
            nums[k] = nums[parent];
            k = parent;
        }
        nums[k] = val;
    }

    /**
     * 下沉，用于删除元素，以及建堆时使用
     *
     * @param nums 存放数据的数组
     * @param k    调整的位置，删除时为0，建堆时为最后一个节点的父节点依次往前
     * @param tail 调整到的末尾
     */
    public static void siftDown(int[] nums, int k, int tail) {
        int temp = nums[k];
        int son = k * 2 + 1;
        while (son <= tail) {
            if (son + 1 <= tail && nums[son + 1] < nums[son]) {
                son++;
            }
            // 调整值小于子节点，不用调整了
            if (temp <= nums[son]) {
                break;
            }
            nums[k] = nums[son];
            k = son;
            son = 2 * k + 1;
        }
        nums[k] = temp;
    }
}
