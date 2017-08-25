class Permutations{

    static void permutation(String s, String prefix){
        if (s.length() == 0) {
            System.out.println(prefix);
        }else{
            for(int i = 0; i < s.length(); i ++){
                String rem = s.substring(0,i) + s.substring(i+1);
                permutation(rem, prefix + s.charAt(i));
            }
        }

    }
    static public void main(String[] args){
        String s = "Hello";
        permutation(s,"");

        
    }
}