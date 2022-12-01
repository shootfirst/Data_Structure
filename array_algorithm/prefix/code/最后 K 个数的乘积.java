class ProductOfNumbers {
    private int[] product = new int[40001];
    private int[] nums = new int[40000];
    private int len = 0;

    public ProductOfNumbers() {
        product[0] = 1;
    }

    public void add(int num) {
        product[len + 1] = num * product[len];
        nums[len] = num;
        len++;
    }

    public int getProduct(int k) {
        if (product[len - k] == 0) {
            int ans = 1;
            for (int i = len - k; i < len; i++) {
                ans *= nums[i];
            }
            return ans;
        }
        else return product[len] / product[len - k];
    }
}