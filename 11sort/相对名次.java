class Solution {
    public String[] findRelativeRanks(int[] score) {
        int [] arr = score.clone();
        shellSort(arr);

        String[] result = Arrays.stream(score).mapToObj(String::valueOf).toArray(String[]::new);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i + 1);
        }


        for (int i = 0; i < arr.length; i++) {
            if (score[i] == arr[0]) result[i] = "Gold Medal";
            else if (score[i] == arr[1]) result[i] = "Silver Medal";
            else if (score[i] == arr[2]) result[i] = "Bronze Medal";
            else result[i] = String.valueOf(map.get(score[i]));

        }

        return result;


    }

    private void shellSort(int[] nums) {
        for (int gap = nums.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < nums.length; i++) {
                int store = nums[i];
                int j = i - gap;
                while (j >= 0 && nums[j] < store) {
                    nums[j + gap] = nums[j];
                    j -= gap;
                }

                nums[j + gap] = store;
            }
        }
    }
}