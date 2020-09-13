package io.github.yehongzhi.algorithm;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name InsertSort
 * @date 2020-09-05 22:34
 **/
public class InsertSort extends BaseSort {

    public static void main(String[] args) {
        BaseSort sort = new InsertSort();
        sort.printNums();
    }

    @Override
    protected void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            //当前值
            int curr = nums[i + 1];
            //上一个数的指针
            int preIndex = i;
            while (preIndex >= 0 && curr < nums[preIndex]) {
                nums[preIndex + 1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex + 1] = curr;
        }
    }
}
