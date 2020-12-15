import java.util.*;

/*
Given an array of integers nums sorted in ascending order, 
find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

Use binary search to find the element
*/
public class x {
    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int ind = binarysearch(0, nums.length - 1, target, nums);
        //System.out.println(test);
        int left = ind;
        int right  = ind;
        
        while(left - 1 >= 0) {
            if (nums[left - 1] == target) {
                left --;
            } else {
                break;
            }
        }

        while(right + 1 < nums.length) {
            if (nums[right + 1] == target) {
                right ++;
            } else {
                break;
            }
        }

        System.out.println(left + " " + right);
        return new int[]{left, right};
    }
    
    public static int binarysearch(int left, int right, int target, int[] nums) {
        if (left == right) {
            if (nums[left] == target) {
                return left;
            } else {
                return -1;
            }
        }

        if (right < 0) {
            return -1;
        }

        int mid = ((right - left) / 2) + left;
        int midVal = nums[mid];
        //System.out.println("left: " + left + " right: " + right + " mid: " + mid);
        if (midVal == target) {
            return mid;
        }

        if (midVal < target) {
            return binarysearch(mid + 1, right, target, nums);
        } else {
            return binarysearch(left, mid - 1, target, nums);
        }   
        
    }

    public static void main(String[] args) {
        searchRange(new int[]{2,2},1);
    }

}
