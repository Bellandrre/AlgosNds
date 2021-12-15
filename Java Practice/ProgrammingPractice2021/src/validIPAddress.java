public class validIPAddress {

    public static String validAddress(String inputIp){
        return isIPv4(inputIp) ? "IPv4" : isIPv6(inputIp) ? "IPv6" : "Neither";
    }

    public static boolean isIPv4(String inputIp){

        if(inputIp.charAt(inputIp.length() - 1) < 48 || (inputIp.charAt(inputIp.length() - 1) > 57)){
            return false;
        }

        // Rule iPv4
        // 0 <= xi <= 255 and xi cannot contain leading zeros

        // Should have 4 periods
        // x.x.x.x
        String array[] = inputIp.split("\\.");
        if(array.length != 4){
            return false;
        }

        //Should not have leading zeros for each element
        //After converting string to number, it should be between 0 and 255
        for(int i = 0 ; i < array.length; i++){
            String currNumber = array[i];
            if(currNumber.length() > 1 && currNumber.charAt(0) == '0')
                return false;

            //Each number should be between 0 and 255
            try {
                int currNumberInt = Integer.parseInt(currNumber);
                if(currNumberInt < 0 || currNumberInt > 255){
                    return false;
                }
            }catch(NumberFormatException numExp){
                return false;
            }

        }
        return  true;
    }

    public static boolean isIPv6(String inputIp){

        if( (inputIp.charAt(inputIp.length() - 1) < 48 || (inputIp.charAt(inputIp.length() - 1) > 57) )
                && (inputIp.charAt(inputIp.length() - 1) < 65 || (inputIp.charAt(inputIp.length() - 1) > 90))
                && (inputIp.charAt(inputIp.length() - 1) < 97 || (inputIp.charAt(inputIp.length() - 1) > 122))){
            return false;
        }
        //Rule IPv6
        //Should contain 8 parts after split
        String array[] = inputIp.split(":");
        if(array.length != 8){
            return false;
        }

        /*
        1 <= xi.length <= 4
        xi is a hexadecimal string which may contain digits, lower-case English letter ('a' to 'f') and upper-case English letters ('A' to 'F').
        Leading zeros are allowed in xi  */

        for(int i = 0 ; i < array.length ; i++){
            String currentNum = array[i];

            // 1 <= xi.length <= 4
            if(currentNum.length() < 1 || currentNum.length() > 4){
                return false;
            }
            //xi is a hexadecimal string which may contain digits, lower-case English letter ('a' to 'f') and upper-case English letters ('A' to 'F').
            //Leading zeros are allowed in xi

            // Constant running time
            for(int j = 0; j < currentNum.length(); j++){
                char currChar = currentNum.charAt(j);
                if( (currChar < 48 && currChar > 57)
                        || (currChar < 65 && currChar > 90 )
                        || (currChar < 97 && currChar > 122)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validAddress("2001:0db8:85a3:0:0:8A2E:0370:7334."));
    }
}
