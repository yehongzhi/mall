package io.github.yehongzhi.algorithm;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name QuickSort
 * @date 2020-09-07 21:42
 **/
public class QuickSort extends BaseSort {

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        sort.printNums();
    }

    @Override
    protected void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int star, int end) {
        if (star > end) {
            return;
        }
        int i = star;
        int j = end;
        int key = nums[star];
        while (i < j) {
            while (i < j && nums[j] > key) {
                j--;
            }
            while (i < j && nums[i] <= key) {
                i++;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[star] = nums[i];
        nums[i] = key;
        quickSort(nums, star, i - 1);
        quickSort(nums, i + 1, end);
    }
}
