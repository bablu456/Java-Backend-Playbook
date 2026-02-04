public class MaxSumWindow {
public static void main(String[] args){
    int[] arr = {2,1,5,1,3,2};
    int k = 3;
    System.out.println("Maximum sum(Brute Force): "+findMaxSumBrute(arr, k));
    System.out.println("Maximum sum(Sliding Window): "+findMaxSumOptimized(arr,k));
    
}

public static int findMaxSumBrute(int[] arr, int k){
    int maxSum = 0;
    for(int i=0;i<=arr.length-k;i++){
        int currentSum = 0;
        for(int j=0;j<k;j++){
            currentSum += arr[i+j];
        }
        maxSum = Math.max(maxSum, currentSum);
    }
    return maxSum;
}

public static int findMaxSumOptimized(int[] arr, int k){
    int maxSum = 0;
    int windowSum = 0;
    int start = 0;

    for(int end = 0; end <arr.length;end++){
        windowSum += arr[end];

        if(end >= k-1){
            maxSum = Math.max(maxSum, windowSum);

            windowSum -= arr[start];
            start++;
        }
    }
    return maxSum;
}
}
