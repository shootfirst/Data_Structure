class Solution {
    public String reverseVowels(String s) {
        int n=s.length();
        if(n<2) return s;
        char[] c=s.toCharArray();
        int left=0,right=n-1;
        while(left<right){
            while(left<right&&!checkVowels(c[left])) left++;
            while(left<right&&!checkVowels(c[right])) right--;
            if(left== right) break;
            swap(c,left,right);
            left++;
            right--;
        }
        return new String(c);
    }
    public void swap(char[] c,int a,int b){
        char swap=c[a];
        c[a]=c[b];
        c[b]=swap;
    }

    public boolean checkVowels(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U') return true;
        else return false;
    }
}