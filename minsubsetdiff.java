import java.util.*;
//very nice question done by Pratham Goel




class minsubsetdiff{
    void subset(int[] arr,boolean[][]dp,int sum){
        int n=arr.length;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
                
        }
    }
    
    public int minimumDifference(int[] nums) {

        ArrayList<Integer> arr=new ArrayList<Integer>();
        int sum=0;
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
        }

        boolean dp[][]=new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }

        for(int j=1;j<=sum;j++){
            dp[0][j]=false;
        }

        subset(nums,dp,sum);

        int mid=sum/2;

        for(int i=0;i<=mid;i++){
            if(dp[n][i]==true){
                arr.add(i);
            }

        }

        int min=Integer.MAX_VALUE;

        for(int i=0;i<arr.size();i++){
            min=Math.min(min,sum-2*arr.get(i));
        }

       

        return min;



        
    }

    public static void main(String args[])
    {
        int set[] = { 1,6,11,5 };

        minsubsetdiff obj=new minsubsetdiff();
        int s=obj.minimumDifference(set);
        System.out.println(s);

        
    }
}