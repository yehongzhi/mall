package io.github.yehongzhi.algorithm;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name BaseSort
 * @date 2020-09-05 22:36
 **/
public abstract class BaseSort {

    //排序数组长度
    private static int length = 100000;

    public void printNums() {
        int[] nums = new int[length];
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int num = random.nextInt(1000) + 1;
            nums[i] = num;
        }
        System.out.println("排序前：" + Arrays.toString(nums));
        long starTime = new Date().getTime();
        //排序
        sort(nums);
        long endTime = new Date().getTime();
        System.out.println("排序后：" + Arrays.toString(nums));
        System.out.println("耗时：" + (endTime - starTime) + "毫秒");
    }

    protected abstract void sort(int[] nums);
}
