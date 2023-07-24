import java.util.*;
//for ex the array is 




class subsetwithdiff{
    void subset(int[] arr,int[][]dp,int sum){
        int n=arr.length;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j-arr[i-1]]+dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
                
        }
    }
    
    public int minimumdifference(int[] nums,int diff) {

        
        int sum=0;
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
        }
          int sum2=(diff+sum)/2;
        int dp[][]=new int[n+1][sum2+1];
        System.out.println(sum2);


        
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }

        for(int j=1;j<=sum2;j++){
            dp[0][j]=0;
        }

      
        subset(nums,dp,sum2);

        return dp[n][sum2];



        
    }

    public static void main(String args[])
    {
        int set[] = { 1,1,2,3 };
      

        subsetwithdiff obj=new subsetwithdiff();
        int s=obj.minimumdifference(set,1);
        System.out.println(s);

        
    }
}