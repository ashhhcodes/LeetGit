class Solution {
    public int missingMultiple(int[] nums, int k) {
        
        HashSet<Integer>elements = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % k == 0) {
                elements.add(nums[i]);
            }
        }

        int multiple = k;

        while (elements.contains(multiple)) {
            multiple += k;
        }

        return multiple;
    }
}