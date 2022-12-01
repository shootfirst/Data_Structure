class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if(target>=letters[letters.length-1]) return letters[0];
        int l=0,h=letters.length-1,m;
        while(l<h){
            m=l+((h-l)>>2);
            if(letters[m]<=target) l=m+1;
            else h=m;
        }
        return letters[l];
    }
}