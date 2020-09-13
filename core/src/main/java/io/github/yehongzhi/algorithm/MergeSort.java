package io.github.yehongzhi.algorithm;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name MergeSort
 * @date 2020-09-08 23:30
 **/
public class MergeSort extends BaseSort {

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        sort.printNums();
    }

    @Override
    protected void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        //归并排序
        mergeSort(0, nums.length - 1, nums, new int[nums.length]);
    }

    private void mergeSort(int star, int end, int[] nums, int[] temp) {
        if (star >= end) {
            return;
        }
        int mid = star + (end - star) / 2;
        //左边进行归并排序
        mergeSort(star, mid, nums, temp);
        //右边进行归并排序
        mergeSort(mid + 1, end, nums, temp);
        //合并左右
        merge(star, end, mid, nums, temp);
    }

    private void merge(int star, int end, int mid, int[] nums, int[] temp) {
        int index = 0;
        int i = star;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            if (nums[i] > nums[j]) {
                temp[index++] = nums[j++];
            } else {
                temp[index++] = nums[i++];
            }
        }
        while (i <= mid) {
            temp[index++] = nums[i++];
        }
        while (j <= end) {
            temp[index++] = nums[j++];
        }
        if (index >= 0) System.arraycopy(temp, 0, nums, star, index);
    }
}
