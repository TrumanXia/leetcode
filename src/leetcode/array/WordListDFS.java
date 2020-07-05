package leetcode.array;

import java.util.*;

/**
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordListDFS {
    public static void main(String[] args) {
        System.out.println(new WordListDFS().findLadders("hit", "cog",
            Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (wordList.indexOf(endWord) == -1) {
            return Collections.emptyList();
        }
        // 可以使用的字母
        Set<Character> baseChars = new HashSet<>();
        int len = beginWord.length();
        for (String word : wordList) {
            for (int i = 0 ; i < len; i++){
                baseChars.add(word.charAt(i));
            }
        }

        int size = baseChars.size();

        boolean[][] memo = new boolean[len][size];

        List<List<String>> paths = new ArrayList<>();
        List<String> path = new ArrayList<>();
        List<Character> options = new ArrayList<Character>(baseChars);
        traverse(paths, path, beginWord, endWord, memo, options);
        return paths;
    }

    void traverse (List<List<String>> paths, List<String> path, String currentWord, String endWord, boolean[][] memo, List<Character> options) {
        if (path.indexOf(currentWord) != -1) {
            return;
        }
        path.add(currentWord);
        if (currentWord.equals(endWord)) {
            if (paths.isEmpty()) {
                paths.add(new ArrayList<>(path));
            } else {
                if (path.size() < paths.get(0).size()) {
                    paths.clear();
                    paths.add(new ArrayList<>(path));
                } else if (path.size() == paths.get(0).size()) {
                    paths.add(new ArrayList<>(path));
                }
            }
            return;
        }

        if (allTraversed(memo)) {
            return;
        }
        System.out.println(currentWord);

        int len = currentWord.length();
        for(int m = 0; m < len; m++) {
            for (int n = 0; n < options.size(); n++) {
                if (memo[m][n]) {
                    continue;
                }
                memo[m][n] = true;
                String nextWord = currentWord.replace(currentWord.charAt(m), options.get(n));
                traverse(paths, path, nextWord, endWord, memo, options);
                memo[m][n] = false;
            }
        }


    }

    private boolean allTraversed(boolean[][] memo) {
        for (int i = 0 ; i < memo.length; i++) {
            for (int j = 0 ; j < memo[0].length; j++) {
                if (!memo[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
