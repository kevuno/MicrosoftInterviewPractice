class Solution {
    
    static public int[] products(int[] numbers){
        int len = numbers.length;
        int[] products = new int[len];
        if (len <= 2){
            for(int i = 0; i < len; i++){
                products[i] = numbers[len-i-1];
            }
            return products;
        }
        int[] left = new int[len];
        int[] right = new int[len];
        int left_product = 1;
        int right_product = 1;
        for(int i = 0; i < len; i++){
            int j = len - i - 1;
            if (i == 0){
                left[i] = numbers[i+1];
                right[j] = numbers[j-1];
            }else if (i == len - 1){
                left[i] = left[i-1];
                right[j] = right[j+1];
            }else{
                left[i] = left_product * numbers[i-1];
                right[j] = right_product * numbers[j+1];
                left_product *= numbers[i-1];
                right_product *= numbers[j+1];
            }
        }
        for(int i = 0; i < len; i++){
            products[i] = left[i] * right[i];
        }

        return products;
    }
    static public void main(String[] args){
        int len = args.length;
        int[] values = new int[len];
        for(int i=0; i < len; i++){
            values[i] = Integer.parseInt(args[i]);
            System.out.println(values[i]);
        }
        int[] products = products(values);
        System.out.print("Products are [");
        for(int i=0; i < len; i++){
            if (i == len - 1){
                System.out.print(products[i]);
            }else{
                System.out.print(products[i] + ", ");
            }            
        }
        System.out.print("]. Thanks for coming by!");


    }
}