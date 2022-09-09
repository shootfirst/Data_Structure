class Solution {
    public int[] sortArray(int[] nums) {
        countingSort(nums);
        return nums;
    }

    private void bubbleSort(int [] nums) {
        int len = nums.length;
        boolean swap = false;
        for (int i = 0; i < len; i++) {
            swap = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    swap = true;
                }
            }
            if (!swap) break;
        }
    }

    private void selectionSort(int [] nums) {
        int len = nums.length;
        int min;
        for (int i = 0; i < len; i++) {
            min = i;
            for (int j = i; j < len; j++) {
                if (nums[j] < nums[min])
                    min = j;
            }
            swap(nums, min, i);
        }
    }

    private void insertSort(int [] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int store = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > store){
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = store;
        }
    }

    private void shellSort(int [] nums) {
        int len = nums.length;

        for (int gap = len / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < len; i++) {
                int store = nums[i];

                int j = i - gap;

                while (j >= 0 && nums[j] > store){
                    nums[j + gap] = nums[j];
                    j -= gap;
                }

                nums[j + gap] = store;

            }
        }
    }

    private void heapSort(int [] nums) {
        int len = nums.length;

        PriorityQueue<Integer> q = new PriorityQueue();
        for (int i = 0; i < len; i++) {
            q.add(nums[i]);
        }

        for (int i = 0; i < len; i++) {
            nums[i] = q.poll();
        }
    }

    private void quickSort(int [] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int [] nums, int start, int end) {
        if (start >= end) return;
        int mid = partition(nums, start, end);
        quickSort(nums, start, mid - 1);
        quickSort(nums, mid + 1, end);
    }

    private int partition(int [] nums, int start, int end) {
        int pivot = nums[start];
        int left = start + 1, right = end;

        while (left < right) {
            while (left < right && nums[left] <= pivot) left++;
            while (left < right && nums[right] >= pivot) right--;

            if (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }

        if (left == right && nums[right] > pivot) {
            right--;
        }
        swap(nums, start, right);
        return right;


    }




    private void mergeSort(int [] nums) {
        int [] res = new int [nums.length];
        mergeSort(nums, 0, nums.length - 1, res);
    }

    private void mergeSort(int [] nums, int start, int end, int [] res) {
        if (start == end) return;
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid, res);
        mergeSort(nums, mid + 1, end, res);
        merge(nums, start, end, res);
    }

    private void merge(int [] nums, int start, int end, int [] res) {
        int start1 = start;
        int end1 = (start + end) / 2;
        int sub = end1 + 1;
        int start2 = end1 + 1;
        int end2 = end;

        while (start1 <= end1 && start2 <= end2) {
            if (nums[start1] < nums[start2]) {
                res[start1 + start2 - sub] = nums[start1];
                start1++;
            } else {
                res[start1 + start2 - sub] = nums[start2];
                start2++;
            }
        }

        while (start1 <= end1) {
            res[start1 + start2 - sub] = nums[start1];
            start1++;
        }

        while (start2 <= end2) {
            res[start1 + start2 - sub] = nums[start2];
            start2++;
        }

        for (int i = start; i <= end; i++) {
            nums[i] = res[i];
        }

    }

    private void countingSort(int [] nums) {
        int len = nums.length;
        int min = nums[0], max = nums[0];

        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        int [] cnt = new int [max - min + 1];
        int [] res = new int [len];

        for (int i = 0; i < len; i++) {
            cnt[nums[i] - min]++;
        }

        int pre = 0;
        for (int i = 0; i <= max - min; i++) {
            pre += cnt[i];
            cnt[i] = pre - cnt[i];
        }

        for (int i = 0; i < len; i++) {
            res[cnt[nums[i] - min]] = nums[i];
            cnt[nums[i] - min]++;
        }

        for (int i = 0; i < len; i++) {
            nums[i] = res[i];
        }
    }

    private void radixSort(int [] nums) {
        int len = nums.length;
        int max = Math.abs(nums[0]);
        for (int i : nums) {
            max = Math.max(max, Math.abs(i));
        }

        int maxdig = 0;
        do {
            maxdig++;
            max /= 10;
        } while (max > 0);

        int [] cnt = new int[19];
        int [] res = new int[len];

        int div = 10;
        for (int i = 0; i < maxdig; i++, div *= 10) {
            for (int j : nums) {
                int radix = j / div % 10 + 9;
                cnt[radix]++;
            }

            for (int j = 1; j < 19; j++) {
                cnt[j] += cnt[j - 1];
            }

            for (int j = len - 1; j >= 0; j--) {
                int radix = nums[j] / div % 10 + 9;
                res[--cnt[radix]] = nums[j];
            }

            System.arraycopy(res, 0, nums, 0, len);
            Arrays.fill(cnt, 0);
        }


    }

    private void bucketSort(int [] nums) {

    }



    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}