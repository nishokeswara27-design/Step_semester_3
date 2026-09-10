package string.assigment_problems;

public class WordReversalEncoder {

    public static String reverseEachWord(String sentence) {
        if (sentence == null) {
            return "";
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder wordSb = new StringBuilder();
            String word = words[i];
            for (int j = word.length() - 1; j >= 0; j--) {
                wordSb.append(word.charAt(j));
            }
            result.append(wordSb);
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        String output = result.toString();
        System.out.println(output);
        return output;
    }

    public static void main(String[] args) {
        reverseEachWord("hello club");
    }
}
