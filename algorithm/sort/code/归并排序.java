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