package leetcode.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RotatePlateBfs {


    public static void main(String[] args) {
        System.out.println(new RotatePlateBfs().openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
        System.out.println(new RotatePlateBfs().openLock(new String[]{"8888"}, "0009"));
        System.out.println(new RotatePlateBfs().openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888" ,"9888"}, "8888"));
    }

//    寻找这个目标
    private int bfs(String target){
        Queue<String> queue = new LinkedList<>();


        String start = "0000";
        queue.offer(start);

        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String entry = queue.poll();
                for (int j = 0, len = entry.length(); j < len; j++) {
                    String up = plusOne(entry, j);
                    String down = minusOne(entry, j);
                    queue.offer(up);
                    queue.offer(down);
                }
            }
        }
        return 0;
    }

    int openLock(String[] deadEnds, String target){
        Set<String> deads = new HashSet<>();
        for (String deadEnd : deadEnds) {
            deads.add(deadEnd);
        }
        Set<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();

        String start = "0000";
        queue.offer(start);
//        visited.add(start);
        int step = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String entry = queue.poll();

                if (visited.contains(entry)) {
                    continue;
                }
                if (deads.contains(entry)){
                    continue;
                }
                if (entry.equals(target)) {
                    return step;
                }

                visited.add(entry);
                for (int j = 0, len = entry.length(); j < len; j++) {
                    String up = plusOne(entry, j);
                    String down = minusOne(entry, j);
                    queue.offer(up);
                    queue.offer(down);
                }
            }
            step++;
        }
        return -1;
    }

    private String plusOne(String s, int p) {
        char[] chars = s.toCharArray();
        if (chars[p] == '9')
            chars[p] = '0';
        else
//            单个字符可以直接相加
            chars[p] += 1;
        return new String(chars);
    }

    private String minusOne(String s, int p) {
        char[] chars = s.toCharArray();
        if (chars[p] == '0')
            chars[p] = '9';
        else
            chars[p] -= 1;
        return new String(chars);
    }

}
