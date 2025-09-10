// Last updated: 10/09/2025, 15:07:56
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int index = 0;
        
        while (index < n) {
            // 1) Determine which words fit on this line
            int totalChars = words[index].length();
            int last = index + 1;
            while (last < n) {
                // +1 for the space between words
                if (totalChars + 1 + words[last].length() > maxWidth) break;
                totalChars += 1 + words[last].length();
                last++;
            }
            
            StringBuilder line = new StringBuilder();
            int numWords = last - index;
            
            // 2) If it's the last line or the line has only one word -> left-justify
            if (last == n || numWords == 1) {
                // Append words with a single space
                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) {
                        line.append(' ');
                    }
                }
                // Pad with spaces at the end
                int remaining = maxWidth - line.length();
                while (remaining-- > 0) {
                    line.append(' ');
                }
            } else {
                // 3) Fully justify: distribute spaces evenly
                int totalSpaces = maxWidth - (totalChars - (numWords - 1)); 
                // totalChars includes the 1-space placeholders, so subtract them
                int spacesBetweenWords = totalSpaces / (numWords - 1);
                int extraSpaces = totalSpaces % (numWords - 1);
                
                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) {
                        // Base spaces
                        for (int s = 0; s < spacesBetweenWords; s++) {
                            line.append(' ');
                        }
                        // Distribute the remainder to the left slots
                        if (extraSpaces > 0) {
                            line.append(' ');
                            extraSpaces--;
                        }
                    }
                }
            }
            
            result.add(line.toString());
            index = last;  // Move to next line
        }
        
        return result;
    }
}