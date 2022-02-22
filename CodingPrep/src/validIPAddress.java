import java.util.List;

public class validIPAddress {
    public static void main(String[] args) {
        System.out.println("Hello");

//        Input:
//        ip = 5555..555
//        Output: 0
//        Explanation: 5555..555 is not a valid
//        ip address, as the middle two portions
//        are missing.

        String givenIpAddress = "67.53.56.29";
        isValid(givenIpAddress);
        System.out.println(isValid(givenIpAddress));
    }

    public static boolean isValid(String s) {

        String[] elements = s.split("\\.");
        if (elements.length != 4) {
            return false;
        }

        if (s.equals("0.0.0.0"))
            return true;
        int countZero = 0;
        for (String ip : elements) {
            int parsedNum = -1;
            if (ip == null || ip.isEmpty()) {
                return false;
            }
            try {
                parsedNum = Integer.parseInt(ip);
                if (parsedNum > 255 || parsedNum < 0) {
                    return false;
                }
            }
            catch (Exception e) {
                return false;
            }
            if (Integer.parseInt(ip) == 0) {
                countZero ++;
                continue;
            }
            if (ip.charAt(0) == '0') {
                return false;
            }
        }
        if (countZero == 4) {
            return false;
        }
        return true;
    }
}
