package io.github.yehongzhi.lottery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name Main
 * @date 2020-09-13 22:58
 **/
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] prizes = new int[8];
        int count = 0;
        while (true) {
            int prize = main.lottery();
            count++;
            prizes[prize]++;
            if (prize == 1) {
                break;
            }
        }
        System.out.println("总共买了" + count + "次,花了：" + count * 2 + "元");
        System.out.println(Arrays.toString(prizes));
    }

    private int lottery() {
        //选号码
        List<Integer> selectNumbers = new ArrayList<>(Arrays.asList(1, 12, 14, 23, 25, 27));
        //开奖
        List<Integer> drawNumbers = getNumbers();
        //判断中了什么奖
        return isWin(selectNumbers, drawNumbers);
    }

    //判断是否中奖，打印结果到控制台
    private int isWin(List<Integer> selectNumbers, List<Integer> drawNumbers) {
        //中红球的个数
        int redWinCount = 0;
        //中蓝球的个数
        int blueWinCount = 0;
        //选择的特别号码(选的蓝球)
        int selectSpecialNum = selectNumbers.remove(selectNumbers.size() - 1);
        //开奖的特别号码(开奖的蓝球)
        int drawSpecialNum = drawNumbers.remove(drawNumbers.size() - 1);
        //如果相等，中了一个蓝球
        if (selectSpecialNum == drawSpecialNum) {
            //中篮球的个数+1
            blueWinCount++;
        }
        //分别排序，然后一一对比即可
        Collections.sort(selectNumbers);
        System.out.println("选择的号码是：" + selectNumbers + "，特别号码是：" + selectSpecialNum);
        Collections.sort(drawNumbers);
        System.out.println("今晚开奖号码是：" + drawNumbers + "，特别号码是：" + drawSpecialNum);
        for (int i = 0; i < selectNumbers.size(); i++) {
            //如果相等，则中奖的红球个数+1
            if (selectNumbers.get(i).equals(drawNumbers.get(i))) {
                redWinCount++;
            }
        }
        System.out.println("中红球的个数：" + redWinCount + "，中蓝球的个数：" + blueWinCount);
        //根据规则打印结果
        if (redWinCount == 6 && blueWinCount == 1) {
            System.out.println("恭喜你！中了一等奖，获得500万奖金！！！");
            return 1;
        }
        if (redWinCount == 6) {
            System.out.println("恭喜你！中了二等奖，获得100万奖金！！！");
            return 2;
        }
        if (redWinCount == 5 && blueWinCount == 1) {
            System.out.println("恭喜你！中了三等奖，获得3000块奖金！！！");
            return 3;
        }
        if ((redWinCount == 5) || (redWinCount == 4 && blueWinCount == 1)) {
            System.out.println("恭喜你！中了四等奖，获得200块奖金！！！");
            return 4;
        }
        if ((redWinCount == 4) || (redWinCount == 3 && blueWinCount == 1)) {
            System.out.println("恭喜你！中了五等奖，获得10块奖金！！！");
            return 5;
        }
        if (blueWinCount == 1) {
            System.out.println("恭喜你！中了六等奖，获得5块奖金！！！");
            return 6;
        }
        System.out.println("没有中奖，继续努力吧！");
        return 7;
    }

    //投注，选6个红球(1-33选择，不重复)，1个蓝球(特别号码1-16中选择)
    private List<Integer> getNumbers() {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int red = getNum(res, 33);
            res.add(red);
        }
        int blue = new Random().nextInt(16) + 1;
        res.add(blue);
        return res;
    }

    //获取与list中不重复的号码，边界值是bound
    private int getNum(List<Integer> list, int bound) {
        Random random = new Random();
        while (true) {
            int num = random.nextInt(bound) + 1;
            if (!list.contains(num)) {
                return num;
            }
        }
    }
}
