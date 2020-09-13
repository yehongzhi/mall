package io.github.yehongzhi.algorithm;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name SelectSort
 * @date 2020-09-06 22:27
 **/
public class SelectSort extends BaseSort {

    public static void main(String[] args) {
        SelectSort sort = new SelectSort();
        sort.printNums();
    }

    @Override
    protected void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = nums[i];
                nums[minIndex] = temp;
                nums[i] = nums[minIndex];
            }
        }
    }
}
