import jdk.internal.jshell.tool.resources.l10n;

class Solution {
    /*
    Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

    Each element in the array represents your maximum jump length at that position.

    Determine if you are able to reach the last index.

    */
    //MAXIMUM JUMP LENGTH -> dp qns / dfs / bfs
    int[] canReach; // 1 true 2 false
    public boolean canJump(int[] nums) {
        canReach = new int[nums.length];
        return helper(nums, 0);
        
    }
    
    public boolean helper(int[] nums, int start) { //this is top down approach 960 ms
        if (start >= nums.length) {
            return false;
        }
        if (start == nums.length - 1) {
            return true;
        }
        
        if (canReach[start] != 0) {
            return canReach[start] == 1 ? true : false;
        }
        
        int num = nums[start];
        if (num == 0) {
            return false;
        }
        
        boolean able = false;
        for (int i = 1; i <= num; i ++) {
            if (helper(nums, start + i)) {
                able = true;
                break;
            }
        }
        
        if (able) {
            canReach[start] = 1;
        } else {
            canReach[start] = 2;
        }
        
        return able;
    }
}

//bottom up approach is to start from the back and eliminate recursion  240ms

public boolean canJump(int[] nums) {
    int[] memo = new int[nums.length];
    memo[nums.length - 1] = 1;

    for (int i = nums.length - 2; i >= 0; i--) {
        int jump = Math.min(nums[i] + i, nums.length - 1); //take into account if nums[i] + i exceed length
        for (int j = i + 1; j <= jump; j ++) {
            if (memo[j] == 1) {
                memo[i] = 1;
                break;
            }
        }
    }
    return memo[0] == 1;
}

//Greedy O(n) just need to see if we can reach the least index tt can reach the end 0ms.
public boolean canJump(int[] nums) {
    int leastIndex = nums.length - 1;
    for (int i = nums.length - 2; i >= 0; i --) {
        if (i + nums[i] >= leastIndex) {
            leastIndex = i;
        }
    }
    return leastIndex == 0; 
}