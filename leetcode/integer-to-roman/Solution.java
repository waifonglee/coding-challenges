class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] numSet = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] digitSet = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", 
                                         "V", "IV", "I"};
        int ind = 0;
        int val = num;
        while (val > 0) {
            if (val < numSet[ind]) {
                ind++;
            } else {
                val -= numSet[ind];
                sb.append(digitSet[ind]);
            }
        }
        
        return sb.toString();
    }
}
