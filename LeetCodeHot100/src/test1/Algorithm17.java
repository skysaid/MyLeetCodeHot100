package test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Algorithm17 {
        Map<String, String> map = new HashMap<String, String>() {{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};
        List<String> list =new ArrayList<>();
        private void helper(String sb,String digits){
            if (digits.length()==0){
                list.add(sb);
            }else
            {
            String index=digits.substring(0,1);
            String text=map.get(index);
            for(int i=0;i<text.length();i++){
                String temp=text.charAt(i)+"";
                helper(sb+temp,digits.substring(1));
            }
            }
        }

    public List<String> letterCombinations(String digits) {
        if (digits.length()==0)return list;
        String sb="";
        helper(sb,digits);
        return list;
    }
}
