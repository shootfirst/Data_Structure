class Solution {
    public String reverseWords(String s) {
        StringBuilder s1=new StringBuilder();
        int l=0,r=0;
        ArrayList <String> arr=new ArrayList();
        int len=s.length();
        while(r<len){
            while(r<len&&s.charAt(r)==' ') r++;
            if(r==len) break;
            l=r;
            while(r<len&&s.charAt(r)!=' ') r++;
            arr.add(s.substring(l,r));
        }
        for(int i=arr.size()-1;i>=0;i--){
            s1.append(arr.get(i)+" ");
        }
        return s1.toString().substring(0,s1.length()-1);
    }
}