package com.array;

public class StockBuy {

    public static void main(String args[]) {

        int[] prices= {10,1,5,6,7,1};


        int profit1= getProfitBruteForce1(prices);
        System.out.println(profit1);

        int profit= getProfitBruteForce(prices);
        System.out.println(profit);
        int profit2= getProfit(prices);
        System.out.println(profit2);

        int profit3= getProfitDP(prices);
        System.out.println(profit3);



    }

    private static int getProfitDP(int[] prices) {

       int maxP=0;
       int  minBuy=prices[0];

        for (int sell : prices){

            maxP =Math.max(maxP, sell - minBuy);
            minBuy = Math.min(minBuy, sell);

        }
        return maxP;

    }

    private static int getProfit(int[] prices) {


        int b = 0, s = 1, profit = 0;


        while (s < prices.length) {
            if (prices[s] < prices[b]) {
                b = s;

            } else{
                profit = Math.max(profit, prices[s] - prices[b]);
            }

            s++;


        }
        return profit;
    }


    private static int getProfitBruteForce(int[] prices) {


        int profit=0;
        for (int i=0; i< prices.length;i++){
            int buy = prices[i];
            for (int j=i+1; j< prices.length;j++){
                int sell = prices[j];
                profit = Math.max(profit, sell-buy);
            }
        }
        return profit;

    }

    private static int getProfitBruteForce1(int[] prices) {

        int buyIndex=0;
        int sellIndex=0;
        for (int i=0; i< prices.length;i++){
            if (prices[i]<prices[buyIndex]) buyIndex=i;

        }

        sellIndex = buyIndex;
        for (int j=buyIndex+1; j< prices.length;j++){

            if (prices[j]>prices[sellIndex]) sellIndex= j;

        }

        return prices[sellIndex] - prices[buyIndex];

    }
}
