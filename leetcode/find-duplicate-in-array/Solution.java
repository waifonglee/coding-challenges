class Solution {
    /*
    
    Given an array of integers nums containing n + 1 integers where each
    integer is in the range [1, n] inclusive.
    There is only one duplicate number in nums, return this duplicate number.
    
    Floyd cycle detection algorithm.
    After finding the cycle, the hare and the tortoise are at the same position in the cycle – the meeting point. Now we can define a few things:

    x – distance before entering the cycle.
    y – distance in the loop before the meeting point.
    z – distance between the meeting point and the beginning/end of the loop.
    Having defined these variables we can calculate the following things:

    tortoise distance before the meeting point = x + y
    hare distance before the meeting = (x + y + z) + y = x + 2y + z 
    Hare went through x, was in the loop sooner, therefore had to go through distance y once, 
    then close the loop with distance z, and then again had to go through distance y to the meeting point.
    Now, if the tortoise is at the beginning of the list, and the hare is at the meeting point. 
    How can we know that advancing both at the same speed will make them meet at the beginning of the cycle? 
    The distance covered by hare is twice of that covered by the tortoise. 
    Therefore we can define the following equation:

    2 * tortoise_distance = hare_distance
    2 * (x+y) = x + 2y + z // from the above
    2x + 2y = x + 2y + z
    x = z
    (Hence the second for loop :D)
    the meeting point isnt necessarily the duplicate element, it just shows that there is a duplicate element
    
    */
    public int findDuplicate(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare); 
        
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return tortoise;
        
    }
}