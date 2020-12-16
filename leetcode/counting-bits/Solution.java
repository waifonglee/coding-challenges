class Solution {
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i < bits.length; i ++) {
            bits[i] = bits[i >> 1] + (i & 1); 
            /*
            i>>1 to get i / 2, since the number of 1s in a num excluding last digit is the same as 
            its i/2. i & 1 = i % 2 to find out whether its odd or even, even = 0, odd = 1. 
            e.g 8 = 1000, 4 = 100
            */
        }
        return bits;
    }
}


