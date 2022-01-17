import java.math.BigInteger;

public class BinDecCalc {
    public static void main(String[] args) {

        String s1 = "1010100110"; //678
        String s2 = "1010"; //10
        String s3 = "1110010110110"; //7350
        String s4 = "10"; //2

        // convert
        System.out.println(s1 + " in decimal system is "+ binary_to_decimal(s1));
        System.out.println(s2 + " in decimal system is "+ binary_to_decimal(s2));
        System.out.println(s3 + " in decimal system is "+ binary_to_decimal(s3));
        System.out.println(s4 + " in decimal system is "+ binary_to_decimal(s4));

        // add
        String helper = add_binary(s1, s2);
        System.out.println(s1+" + "+s2+" = "+helper+
                "and equals decimal: "+ binary_to_decimal(helper));
        helper = add_binary(s3, s4);
        System.out.println(s3+" + "+s4+" = "+helper+
                "and equals decimal: "+ binary_to_decimal(helper));

        // multiply
        helper = multiply(s1, s2);
        System.out.println(s1+" x "+s2+" = "+helper+
                "and equals decimal: "+ binary_to_decimal(helper));
        helper = multiply(s3, s4);
        System.out.println(s3+" x "+s4+" = "+helper+
                "and equals decimal: "+ binary_to_decimal(helper));
    }

    private static String binary_to_decimal(String a){
        int power = 0;
        BigInteger decimal_number = new BigInteger("0");
        BigInteger two = new BigInteger("2");

        for (int i=a.length()-1; i>=0; i--) {
            if (a.charAt(i) == '1') {
                decimal_number = decimal_number.add(two.pow(power));
            }
            power++;
        }
        return String.valueOf(decimal_number);
    }

    private static String add_binary(String a, String b){
        String shorter;
        String longer;
        String addZeros = "";
        String forward = "0";
        String total = "";
        String join;

        if (a.length() > b.length()){
            longer = a;
            shorter = b;
        } else {
            longer = b;
            shorter = a;
        }

        longer = "0"+longer;
        for(int i=longer.length()-shorter.length(); i>0; i--){
            addZeros = addZeros + "0";
        }   shorter = addZeros+shorter;

        for (int i=longer.length()-1; i>=0; i--){
            join = String.valueOf(shorter.charAt(i))
                    + String.valueOf(longer.charAt(i))
                    + forward;

            switch (join){

                case "000":
                    total = "0"+total;
                    forward="0";
                    break;

                case "001": case "010": case "100":
                    total = "1"+total;
                    forward = "0";
                    break;

                case "110": case "101": case "011":
                    total = "0"+total;
                    forward = "1";
                    break;

                case "111":
                    total = "1"+total;
                    forward = "1";
                    break;
                }
        }
    return total;
    }

    private static String multiply(String a, String b){

        int i = b.length()-1;
        String total = "0";
        String innerProduct = "0";
        String addZeros = "";

        for(int j=0; j<b.length(); j++){
            if(b.charAt(i)=='1'){
                for(int k=j; k>0; k--){
                    addZeros = addZeros + "0";
                }
                innerProduct = a+addZeros;
                addZeros = "";
            }else
                innerProduct = "0";
            i--;
            total = add_binary(total, innerProduct);
        }
        return total;
    }
}
