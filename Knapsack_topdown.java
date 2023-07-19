import java.io.*;
 
class Knapsack_topdown {

    static int max(int a, int b) { return (a > b) ? a : b; }
 
 
    static int knapSack(int W, int wt[], int val[], int n)
    {
        int i, w;
        int K[][] = new int[n + 1][W + 1];
 
        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w]
                        = max(val[i - 1]
                                  + K[i - 1][w - wt[i - 1]],
                              K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        for(int k=0;k<=n;k++){
            for(int l=0;l<=W;l++){
                System.out.print(K[k][l]);
            }
            System.out.println("");
        }
 
        return K[n][W];
    }
 
    // Driver code
    public static void main(String args[])
    {
        int profit[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };
        int W = 10;
        int n = profit.length;
        System.out.println(knapSack(W, weight, profit, n));
    }
}