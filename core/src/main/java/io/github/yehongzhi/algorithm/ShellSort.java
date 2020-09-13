package io.github.yehongzhi.algorithm;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name ShellSort
 * @date 2020-09-07 21:06
 **/
public class ShellSort extends BaseSort {

    public static void main(String[] args) {
        ShellSort sort = new ShellSort();
        sort.printNums();
    }

    @Override
    protected void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int length = nums.length;
        int temp;
        //步长
        int gap = length / 2;
        while (gap > 0) {
            for (int i = gap; i < length; i++) {
                temp = nums[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && nums[preIndex] > temp) {
                    nums[preIndex + gap] = nums[preIndex];
                    preIndex -= gap;
                }
                nums[preIndex + gap] = temp;
            }
            gap /= 2;
        }
    }
}
