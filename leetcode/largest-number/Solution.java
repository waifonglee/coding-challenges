class Solution {
    /*
    Given a list of non-negative integers nums, arrange them such that they form the largest number.

    Note: The result may be very large, so you need to return a string instead of an integer.
    */
    //sort using custom comparator
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        
        for (int i = 0; i < nums.length; i ++) {
            arr[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(arr, new Comparator<String>() {
                            @Override
                            public int compare(String o1, String o2) {
                                return (o2+o1).compareTo(o1+o2);
                                
                            }
        });
        
        //System.out.println(arr[0]);
        if (arr[0].equals("0")) { //multiple 0s e.g [0, 0] as input
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();      
        for (String s: arr) {
            sb.append(s);
        }
        return sb.toString();
        
    }
}