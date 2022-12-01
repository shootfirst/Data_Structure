class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> m=new HashSet();
        Set<Integer> ret=new HashSet();
        for(int num:nums1) m.add(num);
        for(int num:nums2) if(m.contains(num)) ret.add(num);
        int[] re=new int[ret.size()];
        int i=0;
        for(int num:ret) re[i++]=num;
        return re;
    }
}