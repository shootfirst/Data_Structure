class Solution {
    public int arrayPairSum(int[] nums) {
        radixSort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result+=nums[i];
        }
        return result;
    }

    public static void radixSort(int[] arr) {
        if (arr == null) return;

        int max = 0;
        for (int value : arr) {
            if (Math.abs(value) > max) {
                max = Math.abs(value);
            }
        }

        int maxDigitLength = 0;
        while (max != 0) {
            maxDigitLength++;
            max /= 10;
        }

        int[] counting = new int[19];
        int[] result = new int[arr.length];
        int dev = 1;
        for (int i = 0; i < maxDigitLength; i++) {
            for (int value : arr) {

                int radix = value / dev % 10 + 9;
                counting[radix]++;
            }
            for (int j = 1; j < counting.length; j++) {
                counting[j] += counting[j - 1];
            }

            for (int j = arr.length - 1; j >= 0; j--) {

                int radix = arr[j] / dev % 10 + 9;
                result[--counting[radix]] = arr[j];
            }

            System.arraycopy(result, 0, arr, 0, arr.length);

            Arrays.fill(counting, 0);
            dev *= 10;
        }
    }
}