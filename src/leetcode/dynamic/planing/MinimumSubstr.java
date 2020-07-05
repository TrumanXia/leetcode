package leetcode.dynamic.planing;

import java.util.HashMap;
import java.util.Map;

public class MinimumSubstr {
    public static void main(String[] args) {
        System.out.println(new MinimumSubstr().minSubstr("ADC","ABC"));
        System.out.println(new MinimumSubstr().minSubstrV2("ADCNBC","ABCC"));
//        System.out.println(new MinimumSubstr().minSubstr("ADOBECODEBANC","ABC"));
//        System.out.println(new MinimumSubstr().minSubstrV2("ADOBECODEBANC","ABC"));
    }

    private String minSubstr(String source, String target){
        String minSubstr = "";
        int minLen = Integer.MAX_VALUE;
        for (int m = 0, len = source.length(); m < len - 1; m++){
            for (int n = m + 1; n < len; n++){
                String substr = source.substring(m, n + 1);
                if (contains(substr, target) && minLen > substr.length()){
                    minLen = substr.length();
                    minSubstr = substr;
                }
            }
        }
        return minSubstr;
    }

    private boolean contains(String source, String target){
        char[] chars = target.toCharArray();
        boolean result = true;
        for (int i = 0; i < chars.length; i++){
            if (!source.contains(String.valueOf(chars[i]))){
                result = false;
                break;
            }
        }
        return result;
    }
// 如果子串中，有重复子字符串
    private String minSubstrV2(String source, String target) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
//        初始化窗口
        for (int i = 0, len = target.length(); i < len; i++){
            char key = target.charAt(i);
            need.put(key, need.getOrDefault(key, 0) + 1);
        }
//        左闭右开区间
        int left = 0, right = 0;
        int valid = 0;
//        最小长度子串
        int start = 0, len = Integer.MAX_VALUE;

        while (right < source.length()) {
            char c = source.charAt(right);
            right++;
            if(need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
//                通过valid来控制，防止数量加了超过需要的数目
                if (window.get(c) == need.get(c)) {
                    valid++;
                }
            }
// valid已经包含了
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
//                注意先取值，再更新数值。
                char firstLeft = source.charAt(left);
                left++;
                if (need.containsKey(firstLeft)){
                    if (need.get(firstLeft) == window.get(firstLeft)) {
                        valid --;
                    }
                    window.put(firstLeft, window.get(firstLeft) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "": source.substring(start, start + len);
    }

}
