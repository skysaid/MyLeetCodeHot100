package test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Algorithm438 {
    //暴力解，遍历一次字符串各个位置，判断是否符合要求
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> list =new ArrayList<>();
        boolean flag=true;
        int slen=s.length();
        int plen=p.length();
        if(s.length()==0||s.equals(""))return list;
        char[] compare=p.toCharArray();
        Arrays.sort(compare);


        for (int i=0;i<=s.length()-plen;i++){
            flag=true;
            char[] candidate=s.substring(i,plen+i).toCharArray();
            Arrays.sort(candidate);
            for (int j=0;j<plen;j++){
                if (candidate[j]!=compare[j]){
                    flag=false;
                    break;
                }
            }
            if (flag)list.add(i);
        }
        return list;
    }

    //滑动窗口（双指针法）
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list =new ArrayList<>();
        int slen=s.length();
        int plen=p.length();
        if(slen==0||s.equals(""))return list;
        int[] need=new int[26];
        for(char ch : p.toCharArray()){
            need[ch - 'a'] ++;
        }
        int[] window=new int[26];
        int total=plen,left=0,right=0;
        while(right<slen){
            char temp=s.charAt(right);
            int index=temp-'a';
            if (need[index]>0){
                window[index]++;
                if (window[index]<=need[index])
                total--;
            }
            while(total==0){
                if (right-left+1==plen)list.add(left);
                char l=s.charAt(left);
                int lindex=l-'a';
                if (need[lindex]>0){
                    window[lindex]--;
                    if (window[lindex]<need[lindex])
                        total++;
                }
                left++;
            }
            right++;

        }
        return list;
    }

    public static void main(String[] args) {
        int index='b'-'a';
        System.out.println(index);
    }
}
