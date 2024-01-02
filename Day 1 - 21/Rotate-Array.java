class Solution {
    public void reverse(int nums[], int s, int e){
        while(s<=e){
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }

    // Method 1: Constant Space 
    public void rotate1(int nums[], int k){
        reverse(nums, 0, nums.length - 1);          // Reverse Array
        reverse(nums, 0, k - 1);                    // Reverse first k elements
        reverse(nums, k, nums.length - 1);          // Reverse the next remaining elements
    }

    // Method 2: Space - O(n)
    public void rotate2(int nums[], int k){
        int temp[] = new int[nums.length];
        int idx = 0;
        for(int i=nums.length - k ; i<nums.length ; i++){       // Put Last 'k' elements in'temp'
            temp[idx] = nums[i];
            idx++;
        }
        for(int i=0 ; i<nums.length - k ; i++){                 // Put starting elements in'temp'
            temp[idx] = nums[i];
            idx++;
        }
        for(int i=0 ; i<nums.length ; i++){                     // Update 'nums'
            nums[i] = temp[i];
        }
    }

    public void rotate(int[] nums, int k) {
        // To prevent Index Out of Bound Error, as after every 'n' swaps, the array comes to it's original state
        // where n = nums.length
        k = k % nums.length;  

        rotate1(nums,k);

        //rotate2(nums,k);
    }
}
