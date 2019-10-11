package gshar.algoNds.array;

/**@author gauravsharma
 */
public class MaxProfitBuySellStock {

	/* Uses 2 passes.
	 * First pass to find min(left to right) and max(right to left).
	 * (Yes, both are done in single pass as `i` and `size - i`.)
	 * Second pass to find difference of min and max.
	 * */
	public int maxProfit1(int[] prices) {
        int size = prices.length;
        if(size<=1)
            return 0;
        int[] min = new int[size];
        int[] max = new int[size];
        int res=0;
        min[0]=prices[0];
        max[size-1]=prices[size-1];

        for(int i=1;i<size;i++){
            if(prices[i]<min[i-1])
                min[i]=prices[i];
            else
                min[i]=min[i-1];
            if(prices[size-i-1]>max[size-i])
                max[size-i-1] = prices[size-i-1];
            else
                max[size-i-1] = max[size-i];
        }
        for(int i=0;i<size;i++){
            int current=max[i]-min[i];
            if(current>res)
                res=current;
        }
        return res;
    }
	
	/* This does the same in single pass.
	 * Just calculate the minimum, so far, and subtract it from current price of stock.
	 * */
	public int maxProfit2(int[] prices) {
        int size = prices.length;
        if(size<=1)
            return 0;
        
        int min=prices[0];
        int res=0,curr=0;
        
        for(int i=1;i<size;i++){
            if(prices[i]<min)
                min=prices[i];
            
            curr=prices[i]-min;
            if(curr>res)
                res=curr;
        }
        return res;
    }
}
