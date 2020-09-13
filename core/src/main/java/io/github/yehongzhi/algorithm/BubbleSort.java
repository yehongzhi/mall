package io.github.yehongzhi.algorithm;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name BubbleSort
 * @date 2020-09-05 21:38
 **/
public class BubbleSort extends BaseSort {

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        sort.printNums();
    }

    @Override
    protected void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}
