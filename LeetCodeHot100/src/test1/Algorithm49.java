package test1;

import java.util.*;

public class Algorithm49 {
    //通过计算char的和来进行映射：不通过
    public List<List<String>> groupAnagrams1(String[] strs) {

        int[] nums=new int[strs.length];
        for (int i=0;i<strs.length;i++){
            String s=strs[i];
            for (int j=0;j<s.length();j++){
                nums[i]+=s.charAt(j);
            }
        }
        Map<Integer, ArrayList<String>> map =new HashMap<>();
        for (int i=0;i<strs.length;i++){
            int key=nums[i];
            if (key==0)continue;
            if (map.containsKey(key)){
                map.get(key).add(strs[i]);
            }else {
                map.put(key,new ArrayList<>());
                map.get(key).add(strs[i]);
            }
        }
        List<List<String>> res=new LinkedList<>();

        for ( int i:map.keySet()){
                res.add(map.get(i));
        }
        return res;
    }

//把字符串按顺序排列后当键，通过
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, ArrayList<String>> map =new HashMap<>();
        for (int i=0;i<strs.length;i++){
            char[] temp=strs[i].toCharArray();
            Arrays.sort(temp);
            String key=String.valueOf(temp);

            if (map.containsKey(key)){
                map.get(key).add(strs[i]);
            }else {
                map.put(key,new ArrayList<>());
                map.get(key).add(strs[i]);
            }
        }
        List<List<String>> res=new LinkedList<>();

        for ( String s :map.keySet()){
            res.add(map.get(s));
        }
        return res;
    }

//-----------------------------------------------
    //统计字符出现的次数
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, ArrayList<String>> map = new HashMap<>();
        int[] count = new int[26];

        for (String str : strs) {
            Arrays.fill(count, 0);
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i : count) {
                sb.append(i);
                sb.append("#");
            }
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);

        }

        return new ArrayList<>(map.values());
    }
    }