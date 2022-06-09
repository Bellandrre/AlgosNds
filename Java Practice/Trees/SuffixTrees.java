package Trees;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SuffixTrees {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        public void populateSuffixTrieFrom(String str) {
            populateSuffixTrieFromHelper(str, 0, root);
        }

        /*
        *  root --> {b : [a : [b : [c : [* []]]]]}
        *  b a b c
        *          ^
        *          4
        */
        private void populateSuffixTrieFromHelper(String str, int index, TrieNode node){

            if(str.length() == index){
                node.children.put(endSymbol, new TrieNode());
                return;
            }else{

                node.children.put(str.charAt(index), new TrieNode());
                TrieNode next = node.children.get(str.charAt(index));
                index++;
                populateSuffixTrieFromHelper(str, index, next);
            }
        }

        /*
        *  root --> {b : [a : [b : [c : [* []]]]]}
        *  node --> {* []]]]]}
        *  b a b c
        *          ^
        *          4
        */
        public boolean contains(String str) {
            TrieNode node = root;
            if(node != null){
                char[] currChars = str.toCharArray();

                for(int i = 0 ; i < currChars.length; i++){
                    if(node.children.containsKey(currChars[i])){
                        node = node.children.get(currChars[i]);
                    }else{
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {

        SuffixTrie trie = new SuffixTrie("babc");
        trie.populateSuffixTrieFrom("abc");
        trie.populateSuffixTrieFrom("abckarthik");
        System.out.println(trie.contains("babc"));
        System.out.println(trie.contains("abc"));
        System.out.println(trie.contains("abckarthif"));
    }
}
