public class Palindrome {
    private static char[] str_to_array(String s){
        char[] array = new char[s.length()];

        for(int i=0; i<s.length(); i++){
            array[i] = s.charAt(i);
        }
        return array;
    }

    private static boolean is_palindrome(char[] expression) {
        int l = expression.length;
        if(l==0 || l == 1){
            return true;}

            if (expression[0] == expression[l - 1]) {
                char[] _expression = new char[l - 2];

                int j = 0;
                for (int i = 1; i < l-1; i++) {
                    _expression[j] = expression[i];
                    j++;
                }
                return is_palindrome(_expression);
            }else
                return false;
    }
}
