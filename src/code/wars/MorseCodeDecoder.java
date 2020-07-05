//package code.wars;
//
//public class MorseCodeDecoder {
////    空格的正则表达式
//    private static final String WORD_SEPRATOR = " {3}";
//    private static final String LETTER_SEPRATOR = " ";
//    public static String decode(String morseCode) {
//        // your brilliant code here, remember that you can access the preloaded Morse code table through MorseCode.get(code)
//        String[] morseWords = morseCode.split(WORD_SEPRATOR);
//        for (int i = 0, len = morseWords.length; i < len; i++) {
//            morseWords[i] = morseWords[i].trim();
//        }
//        StringBuilder builder = new StringBuilder();
//        for (String morseWord : morseWords) {
//            for (String letter : morseWord.split(LETTER_SEPRATOR)) {
//                builder.append(MorseCode.get(letter));
//            }
//        }
//        return builder.toString();
//    }
//}