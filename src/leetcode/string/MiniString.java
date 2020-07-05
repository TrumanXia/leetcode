package leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class MiniString {

    public static void main(String[] args) {
//        "ADOBECODEBANC"
//"ABC"

//        "cabwefgewcwaefgcf"
//        "cae"
        System.out.println(new MiniString().minWindow("cabwefgewcwaefgcf", "cae"));
//        System.out.println(new MiniString().minWindow("ADOBECODEBANC", "ABC"));
    }
    public String minWindow(String s, String t) {
        Map<Character, Integer> needs = new HashMap<Character, Integer>();
        Map<Character, Integer> window = new HashMap<Character, Integer>();
        for(char letter : t.toCharArray()){
            needs.put(letter, needs.getOrDefault(letter, 0) + 1);
        }

        int left = 0,  right = 0;
        int length = s.length();
        int valid = 0;
        // 最小子串的起始和长度
        int start = left;
        int min = Integer.MAX_VALUE;

        while (right < length) {
            if (needs.get(s.charAt(right)) != null) {
                window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
                if (window.get(s.charAt(right)).intValue() == needs.get(s.charAt(right)).intValue()){
                    valid ++;
                }
            }
            while (valid == needs.keySet().size()) {

//                只有小的时候，才更新！！！
                if (right - left + 1 < min) {
                    start = left;
                    min = right - left + 1;
                }
                if (needs.get(s.charAt(left)) != null) {
//
                    window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                    if (window.get(s.charAt(left)).intValue()
                        < needs.get(s.charAt(left)).intValue()) {
                        valid --;
//                        break;
                    }
                }
                left++;

            }
            right ++;

        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);

    }
}
