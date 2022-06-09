package BitManipulation;

public class DecodeXORedArray {
/**
 *
 * 0000
 * 0001
 * 0010
 * 0011
 * 0100
 * 0101
 * 0110
 * 0111
 *
 *
 * [1, 0, 2, 1]
 *        ^
 * encoded[i] = arr[i] ^ arr[i+1]
 * [1, 2, 3]
 *        ^
 *  [1, 0, 2, 1]
 *           ^
 *  decoded[i] = encoded[i-1] ^ decoded[i-1]
 *  d
 *  start = 1
 */

    public  static int[] decode(int[] encoded, int first){
        int[] decoded = new int[encoded.length + 1];

        decoded[0] = first;

        for(int i = 1; i < decoded.length; i++){
            decoded[i] = encoded[i-1] ^ decoded[i-1];
        }

        return decoded;
    }

    public static void main(String[] args) {
        int[] input = {6,2,7,3};
        int start = 4;

        int decoded[] = decode(input, start);

        for(Integer i : decoded){
            System.out.print(i + " ");
        }
    }

}
