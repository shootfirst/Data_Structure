class Solution {
    public int maxVowels(String s, int k) {
        int cnt=0;
        for(int i=0;ik;i++)
            if(ifVowels(s.charAt(i))) cnt++;
        int max=cnt;
        for(int i=k;is.length();i++){
            if(ifVowels(s.charAt(i-k))) cnt--;
            if(ifVowels(s.charAt(i))) cnt++;
            max=Math.max(max,cnt);
        }
        return max;
    }

    public boolean ifVowels(char c){
        return c=='a'c=='e'c=='i'c=='o'c=='u';
    }

}