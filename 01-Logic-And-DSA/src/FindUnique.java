public class FindUnique {
    public static void main(String[] args){
        int[] arr = {2,3,4,5,4,3,5};
        System.out.println("Unique Element: "+findUnique(arr));
    }

    public static int findUnique(int[] arr){
        int unique = 0;
        for(int n : arr){
            unique ^= n;
        }
        return unique;
    }
}
