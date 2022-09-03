class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] s=new int[26];
        int left=0,right=0,n=p.length();
        while(right<n){
            int v=(p.charAt(right)-'a')%26;
            if(left==right||v==(p.charAt(right-1)-'a'+1)%26){
                // 防止出现相同子串，此处取最大的以p.charAt(right)结尾的所有子串数量
                s[p.charAt(right)-'a']=Math.max(right+1-left,s[p.charAt(right)-'a']);
                right++;
            }else{
                left=right;
            }
        }
        int cnt=0;
        for(int i:s) cnt+=i;
        return cnt;
    }
}