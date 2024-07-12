// Coin change problem with greedy approach DAA
import java.util.*;
class Coin_change
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("How much amount do you want to make?");//total value
        int amount=sc.nextInt();
        if(amount<=0)
        {
            System.out.println("Thank you for using application made by (shadaan or kabir) for coin change problem using greedy approach");
            System.exit(0);
        }
            
        System.out.println("How many Number of Coins do you have to generate "+amount+" rupees"); 
        int number_of_coins=sc.nextInt(); // number of coins for generating change 
        int coinsChange[]=new int[number_of_coins];
        for(int i=0;i<number_of_coins;i++)
        {
            System.out.println("Enter amount of coin "+(i+1)+" "); // amount of coins
            coinsChange[i]=sc.nextInt();

        }
        
        // sorting the array of coins in increasing order for optimization

        int n = coinsChange.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (coinsChange[j] < coinsChange[j + 1]) {
                    // Swap coinsChange[j] and coinsChange[j + 1] if they are in the wrong order
                    int temp = coinsChange[j];
                    coinsChange[j] = coinsChange[j + 1];
                    coinsChange[j + 1] = temp;
                }
            }
        }
    
    // bubble sort ends

        int i=0;
        int output=0;
        int remaining_amount=amount;
        System.out.println("Coins used are");
        while(remaining_amount!=0)
        {
            if(remaining_amount >= coinsChange[i]) //if remaning amount is greater then coins, take that coin and subtract it from remaining amount
            {
                output=output+1;
                remaining_amount=remaining_amount-coinsChange[i];
                System.out.println(+coinsChange[i]);
                i=0;
            }
            if(remaining_amount < coinsChange[i] && i==coinsChange.length-1) // if cant generate change...
            {
                System.out.println("Sorry Can't make change using given coins");
                System.out.println("Thank you for using application made by (shadaan or kabir) for coin change problem using greedy approach");
                System.exit(0);
            }
            
            else{i++;}
            
        }
        System.out.println("Number of coins to generate " +amount +" rupees are "+output);
        System.out.println("Thank you for using application made by (shadaan or kabir) for coin change problem using greedy approach");
        System.exit(0);
    }
}