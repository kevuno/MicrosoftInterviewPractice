public class SolutionBitVector{
    
    static public boolean isUnique(String myString){
        if (myString != null && myString.length() == 0) return true;
        int str_size = myString.length();
        // Store ascii equivalent of each character in an array
        int checker = 0;
        for(int i = 0; i < str_size; i++){
            int value = (int) myString.charAt(i);
            if((checker &(1 << value)) > 0){
                return false;
            }
            checker |= (1 << value);
        }
        return true;

    }

    static public void main(String[] args){
        // Get and check Strings
        for(String s: args){
            System.out.println(isUnique(s));
        }

        
        
    }
}


