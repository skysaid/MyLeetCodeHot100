package test1;

import java.util.HashMap;
import java.util.HashSet;

public class Algorithm03 {
    public int lengthOfLongestSubstring1(String s) {
        int index=0,i=0,j=0;
        if(s.equals(""))return index;
        HashSet<Character> set=new HashSet<>();        ;
        while(j<s.length()){
            if(set.contains(s.charAt(j))){
                set.remove(s.charAt(i++));
            }else{
                set.add(s.charAt(j++));
                index=Math.max(j-i,index);
            }
        }
        return index;
    }
    public int lengthOfLongestSubstring(String s) {
        int index=0,i=0,j=0;
        if(s.equals(""))return index;
        HashMap<Character,Integer> map =new HashMap<>();
        for (;j<s.length();j++){
            if(map.containsKey(s.charAt(j))){
                i=Math.max(map.get(s.charAt(j)),i);
            }
            index=Math.max(index,j-i+1);
            map.put(s.charAt(j),j+1);
        }
        return index;
    }
}
