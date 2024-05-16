class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int val=target-nums[i];
            if(mp.containsKey(val)){
                return new int[]{mp.get(val),i};
            }
            mp.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}
