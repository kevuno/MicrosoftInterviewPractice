public class SolutionMap{
    
    static public boolean isUnique(String myString){
        if (myString != null && myString.length() == 0) return true;
        int str_size = myString.length();
        // Store ascii equivalent of each character in an array
        boolean[] map = new boolean[256];
        for(int i = 0; i < str_size; i++){
            int value = (int) myString.charAt(i);
            if(map[value]){
                return false;
            }
            map[value] = true;
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


