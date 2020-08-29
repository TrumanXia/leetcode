package parser;

import java.util.Arrays;

/**
 * mybatis GenericTokenParser
 *
 * @author 97994
 * @since 2020-08-09
 */
public class TokenParser {
    public static void main(String[] args) {
        String[] result = parse("this is my content #{name=zhanfei},#{age=13}", "#{", "}");
        String s = Arrays.toString(result);
        System.out.println(s);
    }

    // this is my content #{name=zhanfei},#{age=13}
    // private static String[] parse(String content, String startToken, String endToken) {
    private static String[] parse(String content, String openToken, String closeToken) {
        // 偏移量
        int offset = 0;
        int start = content.indexOf(openToken, offset);
        StringBuilder builder = new StringBuilder();
        String splitToken = ";";
        while (start != -1) {
            // 寻找closeToken
            offset = start;
            int end = content.indexOf(closeToken, offset);
            if (end != -1) {
                builder.append(content, start + openToken.length(), end);
                builder.append(splitToken);
                offset = end;
            } else {
                builder.append(content.substring(start));
            }
            start = content.indexOf(openToken, offset);
        }
        // Array.newInstance()
        return builder.toString().split(splitToken);
    }
}
