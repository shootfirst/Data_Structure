class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret=new ArrayList();
        while(ret.size()<numRows){
            List<Integer> add=new ArrayList();
            for(int i=0;i<ret.size()+1;i++){
                if(i==0||i==ret.size()) add.add(1);
                else add.add(ret.get(ret.size()-1).get(i-1)+ret.get(ret.size()-1).get(i));
            }
            ret.add(add);
        }
        return ret;
    }
}