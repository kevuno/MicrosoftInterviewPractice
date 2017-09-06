class Solution {

    static private double logBaseTwo(int num){
        return Math.log(num)/Math.log(2);
    }

    /** 
     * Returns whether you can create a palindrom with a given string after rearranging its characters
     **/
    static private boolean isPalindromePermutation(String s){
        int real_size = s.length();
        int no_whitespace_size = real_size;
        int map = 0;
        for(int i = 0; i < real_size; i++){
            int value = (int) s.charAt(i);
            if ((char) value == ' '){
                no_whitespace_size --;
                continue;
            }
            // On even counts it will turn into 1, on odd counts it will turn into 0;
            if((map&(1<<value)) == 0){
                map |= (1 << value);
            }else{
                map &= ~(1 << value);
            }
        }
        // If length is even, check that the whole map is 0, otherwise check that there is only one bit with a 1, which is the same
        // as checking if the number map is a power of two.
        return ((no_whitespace_size % 2) == 0) ? map == 0 : (logBaseTwo(map) % 1) == 0;

    }

    static public void main(String[] args){
        String test_string = "tact coa";
        System.out.println(isPalindromePermutation(test_string));

    }

}