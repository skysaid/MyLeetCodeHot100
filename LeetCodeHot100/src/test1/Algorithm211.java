package test1;

import java.util.HashMap;
import java.util.Map;

public class Algorithm211 {
    class WordDictionary {
        private class Node{
            public boolean isWord;
            public Map<Character, Node> next;

            public  Node(boolean isWord){
                this.isWord = isWord;
                next=new HashMap<>();
            }
            public Node(){
                this(false);
            }
        }

        private Node root;
        /** Initialize your data structure here. */
        public WordDictionary() {
            root=new Node();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            this.add(root,word,0);
        }
        public void add(Node root, String word,int index){
            if (index==word.length()){
                if (!root.isWord){
                    root.isWord=true;
                }
                return;
            }
            char c=word.charAt(index);
            if (root.next.get(c)==null)root.next.put(c,new Node());
            add(root.next.get(c),word,index+1);
        }
        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return match(root,word,0);
        }

        private boolean match(Node root, String word, int index){
            if (index == word.length())
                return root.isWord;
            char c= word.charAt(index);
            if (c != '.'){
                if (root.next.get(c)==null)return false;
                return match(root.next.get(c),word,index+1);
            }else {
                for (char nextChar : root.next.keySet()){
                    if (match(root.next.get(nextChar),word,index+1))return true;
                }
                return false;
            }
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
