class Solution {
    public void reverseString(char[] s) {
        char tmp;
        int i=0,j=s.length-1;
        while(ij){
            tmp=s[i];
            s[i]=s[j];
            s[j]=tmp;
            i++;
            j--;
        }
    }
}