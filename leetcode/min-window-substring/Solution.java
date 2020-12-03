class Solution {
    public String minWindow(String s, String t) {
        int[] arr = new int[128];
        int start = 0;
        int end = 0;
        int minStart = 0;
        int minLength = Integer.MAX_VALUE;
        int count = t.length();
        
        //initialise array of characters in t
        for(int i = 0; i < t.length(); i++) { 
            arr[t.charAt(i)] ++;
        }
        
        while (end < s.length()) {
           
            //when the number of this char is > 0, it is in t
            if (arr[s.charAt(end)] > 0) { 
                count --;
            }
            
            arr[s.charAt(end)] --;
            end++;
            
            //what this loop does is that if there is a smaller window than the min window, 
            //it will replace the minStart with the start of the smaller window, 
            //then it will try to find the next position where the char is in t.
            while (count == 0) {
                if ((end - start) < minLength) {
                    minLength = end - start;
                    minStart = start;
                }
                
                arr[s.charAt(start)] ++;
                
                //only after adding, if it is more than 0, it is in t, otherwise it would be <= 0
                if (arr[s.charAt(start)] > 0) {
                    count ++;
                }
                start ++;
            }
        }
        
        if (minLength == Integer.MAX_VALUE) {
            return "";
        } else {
            System.out.println(minStart);
            System.out.println(minLength);
            return s.substring(minStart, minStart + minLength);
        }
        
    }
}