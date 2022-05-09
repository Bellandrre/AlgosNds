package BitManipulation;

public class NotUsingTemporaryVariable {


    public static void main(String[] args) {
        /**
         * 0 - 0000
         * 1 - 0001
         * 2 - 0010
         * 3 - 0011
         * 4 - 0100
         */

        System.out.println(Integer.toBinaryString(4 & 3)); // removing LSB - n & (n-1).
        System.out.println(Integer.toBinaryString(3 & 2).equals(0)); // check if perfect power of 2. Perfect power of 2 will always have LSB as 0.
        System.out.println(Integer.toBinaryString(3 & (1 << 1))); // check bit value at a particular position. n & (1 << k) where k is the bit at which we wish to determine the current bit value.
        //System.out.println(Integer.toBinaryString());
    }
}
