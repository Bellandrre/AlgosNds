package LeetcodeProblems;
import java.util.*;

public class MinimumWindowSubstring {

    public String minWindow(String searchString, String t) {

        // Creating Map for storing the frequency
        Map<Character, Integer> requiredCharacters = buildMappingOfCharactersToOccurrences(t);
        Map<Character, Integer> windowCharacterMapping = new HashMap<Character, Integer>();

        int left = 0;
        int right = 0;

        int totalCharFrequenciesToMatch = requiredCharacters.size();
        int charFrequenciesInWindowThatMatch = 0;

        // This will store the minimum length of valid substring
        int minWindowLengthSeenSoFar = Integer.MAX_VALUE;

        // It will store the actual substring
        String minWindow = "";

        // Here we calculate the ans using 2 pointer's approach
        while (right < searchString.length()) {
            char characterAtRightPointer = searchString.charAt(right);
            addCharacterToHashtableMapping(windowCharacterMapping, characterAtRightPointer);

            boolean rightCharIsARequirement = requiredCharacters.containsKey(characterAtRightPointer);
            if (rightCharIsARequirement) {
                boolean requirementForCharacterMet = requiredCharacters.get(characterAtRightPointer)
                        .intValue() == windowCharacterMapping.get(characterAtRightPointer).intValue();

                if (requirementForCharacterMet) {
                    charFrequenciesInWindowThatMatch++;
                }
            }

            while (charFrequenciesInWindowThatMatch == totalCharFrequenciesToMatch && left <= right) {
                char characterAtLeftPointer = searchString.charAt(left);
                int windowSize = right - left + 1;

                if (windowSize < minWindowLengthSeenSoFar) {
                    minWindowLengthSeenSoFar = windowSize;
                    minWindow = searchString.substring(left, right + 1);
                }

                windowCharacterMapping.put(characterAtLeftPointer, windowCharacterMapping.get(characterAtLeftPointer) - 1);

                boolean leftCharIsARequirement = requiredCharacters.containsKey(characterAtLeftPointer);
                if (leftCharIsARequirement) {
                    boolean characterFailsRequirement = windowCharacterMapping.get(characterAtLeftPointer)
                            .intValue() < requiredCharacters.get(characterAtLeftPointer).intValue();

                    if (characterFailsRequirement) {
                        charFrequenciesInWindowThatMatch--;
                    }
                }

                left++;
            }

            right++;
        }

        return minWindow;
    }

    // Helper function for computing the character's frequency of a string
    private Map<Character, Integer> buildMappingOfCharactersToOccurrences(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            int occurrencesOfCharacter = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), occurrencesOfCharacter + 1);
        }

        return map;
    }

    // Helper function to insert a character in the map
    private void addCharacterToHashtableMapping(Map<Character, Integer> map, Character c) {
        int occurrences = map.getOrDefault(c, 0);
        map.put(c, occurrences + 1); 
    }

}
