package com.example.demo.service.struct;

/**
 * @author gaonan1
 * @date 2021/8/30 9:50
 **/
public class Struct215 {

    public int findKthLargest(int[] nums, int k) {
        buildHeap(nums);
        int len = nums.length;
        int temp = nums[0];
        for (int i = 0; i < k; i++) {
            len = len - i;
            // 交换首个元素到末尾
            temp = nums[0];
            nums[0] = nums[len - 1];
            nums[len - 1] = temp;
            // 对首个元素进行调整
            adjustHeap(nums,0, len);
        }
        return temp;
    }

    /**
     * 构造大顶堆
     * @param nums
     */
    private void buildHeap(int[] nums) {
        int length = nums.length;
        // 从最后一个非叶节点开始调整，向下调整，一直调整到根节点
        for (int i = length / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, length);
        }
    }

    /**
     * 调整大顶堆，向下调整
     * @param nums 数组
     * @param i 要调整的节点
     * @param length 调整到的末尾位置
     */
    private void adjustHeap(int[] nums, int i, int length) {
        int temp = nums[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            // 找出两个子节点中较大的值
            if (k + 1 < length) {
                if (nums[k + 1] > nums[k]) {
                    k = k + 1;
                }
            }
            if (nums[k] > nums[i]) {
                nums[i] = nums[k];
                i = k;
            } else {
                break;
            }
        }
        nums[i] = temp;
    }
}
