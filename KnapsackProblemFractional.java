import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class KnapsackProblemFractional {

    public static void main(String[] args) {
        ArrayList<KnapsackItem> itemsArr = createNewArr();
        int weight = 50;
        knapsackSolutionFinder(itemsArr, weight);
    }

    private static void knapsackSolutionFinder(ArrayList<KnapsackItem> itemsArr, int weight) {
        // sort array by weight ratio
        itemsArr.sort(Collections.reverseOrder());
        System.out.println(itemsArr.toString());

        // knapsack to add to
        KnapsackItem[] knapsack = new KnapsackItem[itemsArr.size()];
        int remainingWeight = weight;
        int totalValue = 0;

        // add to knapsack
        // -- add the items from highest ratio to smallest until there is no more room
        //    for a whole item. At the end, add as much of the next item as possible.
        //    This returns the optimal solution to the problem.
        for (int i = 0; i < itemsArr.size(); i++) {
            if (remainingWeight < itemsArr.get(i).getWeight()) {
                // add up until full of this last item
                double val = itemsArr.get(i).getValue()
                        * ((double) remainingWeight / itemsArr.get(i).getWeight());
                double wt = itemsArr.get(i).getWeight()
                        * ((double) remainingWeight / itemsArr.get(i).getWeight());
                knapsack[i] = new KnapsackItem(val, wt);
                totalValue += val;
                break;
            }
            knapsack[i] = itemsArr.get(i);
            remainingWeight -= itemsArr.get(i).getWeight();
            totalValue += itemsArr.get(i).getValue();
        }

        System.out.println("The maximum value possible in a knapsack of weight "
                + weight + " = " + totalValue);
        System.out.println("Items in knapsack are: " + Arrays.toString(knapsack));
    }

    private static ArrayList<KnapsackItem> createNewArr() {
        ArrayList<KnapsackItem> items = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);
        // add items to array
        for(int wt, val;;)
        {
            System.out.println("Enter the Weight of an item: ");
            while (!keyboard.hasNextInt()){
                String resp = keyboard.nextLine();
                if (resp.equalsIgnoreCase("exit")) {
                    return items;
                }
            }
            wt = keyboard.nextInt();
            System.out.println("Enter the Price of an item: ");
            while (!keyboard.hasNextInt()){
                keyboard.nextLine();
            }
            val = keyboard.nextInt();
            items.add(new KnapsackItem(val, wt));
            keyboard.nextLine();
            System.out.println("Finished? Enter: \"exit\"");
        }
    }

}
