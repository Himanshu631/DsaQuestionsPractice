package strings;

// You are given a list of words and a maxWidth (line width). You need to format the text so that:
//
//Each line has exactly maxWidth characters.
//
//Words are fully justified:
//
//Spaces are distributed evenly.
//
//Extra spaces (if any) go to the leftmost gaps.
//
//The last line is left-justified and no extra space is inserted between words.

import java.util.*;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> justifiedLines = new ArrayList<>();
        int currentWordIndex = 0;

        while (currentWordIndex < words.length) {
            int lineWordLength = words[currentWordIndex].length();
            int nextWordIndex = currentWordIndex + 1;

            // Find how many words can fit into the current line
            while (nextWordIndex < words.length &&
                    lineWordLength + words[nextWordIndex].length() + (nextWordIndex - currentWordIndex) <= maxWidth) {
                lineWordLength += words[nextWordIndex].length();
                nextWordIndex++;
            }

            int numberOfWordsInLine = nextWordIndex - currentWordIndex;
            int totalSpaces = maxWidth - lineWordLength;
            StringBuilder lineBuilder = new StringBuilder();

            // If it's the last line or only one word, left-justify
            if (nextWordIndex == words.length || numberOfWordsInLine == 1) {
                for (int i = currentWordIndex; i < nextWordIndex; i++) {
                    lineBuilder.append(words[i]);
                    if (i < nextWordIndex - 1) lineBuilder.append(" ");
                }

                // Fill remaining spaces at the end
                int remainingSpaces = maxWidth - lineBuilder.length();
                while (remainingSpaces-- > 0) {
                    lineBuilder.append(" ");
                }

            } else {
                int spacesBetweenWords = totalSpaces / (numberOfWordsInLine - 1);
                int extraSpacesToLeft = totalSpaces % (numberOfWordsInLine - 1);

                for (int i = currentWordIndex; i < nextWordIndex; i++) {
                    lineBuilder.append(words[i]);
                    if (i < nextWordIndex - 1) {
                        int spacesToApply = spacesBetweenWords + (i - currentWordIndex < extraSpacesToLeft ? 1 : 0);
                        lineBuilder.append(" ".repeat(Math.max(0, spacesToApply)));
                    }
                }
            }

            justifiedLines.add(lineBuilder.toString());
            currentWordIndex = nextWordIndex;
        }

        return justifiedLines;
    }

    public static void main(String[] args) {
        TextJustification formatter = new TextJustification();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;

        List<String> result = formatter.fullJustify(words, maxWidth);
        for (String line : result) {
            System.out.println("\"" + line + "\"");
        }
    }
}

