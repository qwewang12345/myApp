package com.example.demo.service.struct.sort;

/**
 * @author gaonan1
 * @date 2021/8/4 9:52
 **/
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {5, 4, 7, 8, 10, 3};
        quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    /**
     * 快排递归逻辑，算法导论版本，更好理解
     * @param nums
     * @param left 左边界
     * @param right 右边界
     */
    public static void quickSort1(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        // 基准值默认选了左边，这个地方可以优化
        int key = nums[left];
        int i = left;
        int j = right;
        while (i < j) {
            // 右边大于key，直接左移
            while (nums[j] >= key && i < j) {
                j--;
            }
            // 上面中断，且i<j,说明nums[j]为小于key，换到左边
            // 这个地方直接换，不用考虑i原有的值，原有的值都是大于key的，除了初始值left
            if (i < j) {
                nums[i++] = nums[j];
            }
            // 左边值小于等于key，直接右移
            while (nums[i] <= key && i < j) {
                i++;
            }
            // 这个和上面一样，直接换到j的位置，因为上面j的位置是小于key的
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        // 将key放到重合处，左边都小于等于，右边都大于等于
        nums[i] = key;
        // 继续递归左边，因为数组上直接操作，所以不存在合并
        quickSort(nums, left, i - 1);
        // 继续递归右边
        quickSort(nums, i + 1, right);
    }

    /**
     * 快排递归过程，这个是另一种解法
     * @param nums
     * @param left
     * @param right
     */
    public static void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int key = nums[left];
        int i = left;
        int j = right;
        while (i < j) {
            // 右边大于等于key，一直移动到不满足
            while (nums[j] >= key && i < j) {
                j--;
            }
            // 左边小于等于key，一直移动到不满足
            while (nums[i] <= key && i < j) {
                i++;
            }
            // i还小于j,交换上面位置的元素
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        // 这里重合的地方为什么肯定小于等于key呢，因为先判断的是右边是否大于key，
        // 这个如果跳出，就应该是小于key的
        nums[left] = nums[i];
        // key放到重合处，没什么争议
        nums[i] = key;
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }
}
