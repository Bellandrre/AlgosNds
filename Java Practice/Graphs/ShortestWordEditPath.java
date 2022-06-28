package Graphs;
import java.util.*;
public class ShortestWordEditPath {

    //                     h   i   t                  ---- > cog
    //                     ^
    // Dictionary        ["hot"| "dot","dog","lot","log","cog"]
    //                      ^
    // currentWord hit
    // minimumHops 0
    // candidate  hot

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictionary = new HashSet<>();
        Set<String> wordSeen = new HashSet<>();

        for(String str : wordList){
            dictionary.add(str);
        }

        if(!dictionary.contains(endWord)){
            return 0;
        }

        String currentWord = beginWord;
        int minimumHops = 1;
        while(!currentWord.equals(endWord)){
            Set<String> candidate = new HashSet<>();

            for(String word : dictionary){
                int difference = 0;

                for(int i = 0 ; i < word.length(); i++){
                    if(word.charAt(i) != currentWord.charAt(i))
                        difference++;
                }
                if(difference == 1){
                    candidate.add(word);
                }
            }


            //                     h   o   t                  ---- > cog
            //                     ^
            // Dictionary        ["hot"| "dot","dog","lot","log","cog"]
            //                      ^
            // currentWord hit
            // minimumHops 0
            // candidate  hot

            String nextWord = "";
            // Check the diff with the end word
            for(String candidateWord : candidate){
                int difference = 0;
                int minDiffenence = Integer.MAX_VALUE;
                for(int i = 0; i < candidateWord.length() ;i++){
                    if(candidateWord.charAt(i) != endWord.charAt(i)){
                        difference++;
                    }
                    if(minDiffenence > difference){
                        nextWord = candidateWord;
                        minDiffenence = difference;
                        dictionary.remove(candidateWord);
                    }
                }
            }

            if(nextWord.length() == 0)
                return 0;

            currentWord = nextWord;
            minimumHops++;
        }
        return minimumHops;
    }

    public static void main(String[] args) {
        String words[] = {"hot","dog"};
        List<String> wordList = new ArrayList<>(Arrays.asList(words));

        System.out.println(ladderLength("hot", "dog", wordList));

    }

}
