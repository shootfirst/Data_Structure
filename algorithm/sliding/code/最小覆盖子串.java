class Solution {
    public String minWindow(String s, String t) {
        int [] tt=new int[128];
        int [] ss=new int[128];
        int l=0,r=0,cnt=0,fetch=0,min=s.length()+1,right=0,left=0;
        for(int i=0;i<t.length();i++) {
            if(0==tt[t.charAt(i)-'A']) cnt++;
            tt[t.charAt(i)-'A']++;
        }
        while(r<s.length()){
            while(r<s.length()&&fetch<cnt){
                ss[s.charAt(r)-'A']++;
                if(ss[s.charAt(r)-'A']==tt[s.charAt(r)-'A']) fetch++;
                r++;
            }
            if(fetch==cnt){
                while(l<r&&fetch==cnt){
                    ss[s.charAt(l)-'A']--;
                    if(ss[s.charAt(l)-'A']<tt[s.charAt(l)-'A']){
                        fetch--;
                        if(min>r-l){
                            right=r;
                            left=l;
                            min=r-l;
                        }
                    }
                    l++;
                }
            }
        }
        return min==s.length()+1?"":s.substring(left,right);
    }
}