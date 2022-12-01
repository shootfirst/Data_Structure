class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret=new ArrayList();
        int [] cnt=new int[26];
        int c=0;
        for(int i=0;i<p.length();i++) if(0==cnt[p.charAt(i)-'a']++) c++;
        int left=0,right=0,f=0;
        int [] fet=new int[26];
        while(right<s.length()){
            if(cnt[s.charAt(right)-'a']==++fet[s.charAt(right++)-'a']) f++;
            if(right-left==p.length()&&f==c){
                ret.add(left);
                if(cnt[s.charAt(left)-'a']==fet[s.charAt(left++)-'a']--) f--;
            }
            if(right-left==p.length()&&f<c)
                if(cnt[s.charAt(left)-'a']==fet[s.charAt(left++)-'a']--) f--;
        }
        return ret;
    }
}