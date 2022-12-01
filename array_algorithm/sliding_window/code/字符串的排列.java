class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int cnt=0,fet=0;
        int[] c=new int[26];
        int[] f=new int[26];
        for(int i=0;i<s1.length();i++) if(0==c[s1.charAt(i)-'a']++) cnt++;
        for(int i=0;i<s1.length();i++) if(c[s2.charAt(i)-'a']==++f[s2.charAt(i)-'a']) fet++;
        if(fet==cnt) return true;
        for(int i=0;i<s2.length()-s1.length();i++){
            if(c[s2.charAt(i)-'a']==f[s2.charAt(i)-'a']--) fet--;
            if(c[s2.charAt(i+s1.length())-'a']==++f[s2.charAt(i+s1.length())-'a']) fet++;
            if(fet==cnt) return true;
        }
        return false;
    }
}