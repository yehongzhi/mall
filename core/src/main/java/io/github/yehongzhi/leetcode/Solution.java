package io.github.yehongzhi.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name Solution
 * @date 2021-03-09 00:15
 **/
public class Solution {

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int res = solution.longestPalindrome("abccccdd");
        System.out.println(res);
    }

    public int countPrimes(int n) {
        int count = 0;
        boolean[] booleans = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!booleans[i]) {
                for (int j = 2; j * i < n; j++) {
                    booleans[i * j] = true;
                }
                count++;
            }
        }
        return count;
    }

    public int longestPalindrome(String s) {
        int[] hash = new int[128];
        for (char c : s.toCharArray()) {
            hash[c - 'A']++;
        }
        int res = 0;
        for (int count : hash) {
            if (count % 2 != 0) {
                res += (count - 1);
            } else {
                res += count;
            }
        }
        int length = s.length();
        return res == length ? length : (res + 1);
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
            } else {
                return true;
            }
        }
        return false;
    }

    public char findTheDifference(String s, String t) {
        int[] hash = new int[26];
        for (char c : s.toCharArray()) {
            hash[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (hash[c - 'a'] > 0) {
                hash[c - 'a']--;
            } else {
                return c;
            }
        }
        return ' ';
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] hash = new int[101];
        for (int num : nums) {
            hash[num]++;
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = nums[i] - 1; j >= 0; j--) {
                count += hash[j];
            }
            res[i] = count;
        }
        return res;
    }

    public int firstUniqChar(String s) {
        int[] hash = new int[26];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            hash[ch - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (hash[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public int numJewelsInStones(String jewels, String stones) {
        boolean[] bools = new boolean[58];
        for (char j : jewels.toCharArray()) {
            bools[j - 'A'] = true;
        }
        int count = 0;
        for (char s : stones.toCharArray()) {
            boolean bool = bools[s - 'A'];
            if (bool) {
                count++;
            }
        }
        return count;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] twoSum(int[] nums, int target) {
        //map的key是nums[i]的值，value是下标i
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //获取结果值与nums[i]的差值
            int diff = target - nums[i];
            //如果包含的话，返回结果
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
