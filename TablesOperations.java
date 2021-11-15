import java.util.Arrays;

public class TablesOperations {
    public static void main(String[] args){
        // demo variables
        int[][] example_variables = {
                {1, 2, 3, 4, 5, 6, 7},
                {-5, -98, 1000, 1024, 0, 49, -15},
                {0, 0, 0, 23, 25, -3, 0},
                {4},
                {},
                {37, 37, 37},
                {45, -7},
        };
        // performing demo
        for (int i = 0; i < example_variables.length; i++) {
            print(example_variables[i]);
            try{
                int min_value = min(example_variables[i]);
                int max_value = max(example_variables[i]);
                int min_value_index = minIndex(example_variables[i]);
                int max_value_index = maxIndex(example_variables[i]);
                int sum_of_all = sum(example_variables[i]);
                int total_product = prod(example_variables[i]);
                int[] smooth_tab = smooth(example_variables[i]);

                System.out.println("Minimum value within the table is: " + min_value + ".");
                System.out.println("Maximum value within the table is: " + max_value + ".");
                System.out.println("Minimum value index is: " + min_value_index + ".");
                System.out.println("Maximum value index is: " + max_value_index + ".");
                System.out.println("Sum of all table values is: " + sum_of_all + ".");
                System.out.println("Product of all table values is: " + total_product + ".");
                System.out.println("Performing Smooth results in: ");
                print(smooth_tab);

            } catch(ArrayIndexOutOfBoundsException e){
                System.err.println("Cannot perform demo - The table is empty.");
            }
        }
    }

    private static void print(int[] table){
        System.out.println(Arrays.toString(table));
    }

    private static int min(int[] table){
        int min = table[0];
        for(int i = 0; i < table.length; i++) {
            if (table[i] < min) {
                min = table[i];
            }
       }
        return min;
    }

    private static int max(int[] table) {
        int max = table[0];
        for (int i = 0; i < table.length; i++) {
            if (table[i] > max) {
                max = table[i];
            }
        }
        return max;
    }

    private static int minIndex(int[] table){
        int min_value_index = 0;
        for(int i = 0; i < table.length; i++){
            if(table[i]<table[min_value_index]){
                min_value_index = i;
            }
        }
        return min_value_index;
    }

    private static int maxIndex(int[] table){
        int max_value_index = 0;
        for(int i = 0; i < table.length; i++){
            if(table[i]>table[max_value_index]){
                max_value_index = i;
            }
        }
        return max_value_index;
    }

    private static int sum(int[] table){
        int sum = 0;
        for(int i = 0; i < table.length; i++){
            sum = sum + table[i];
        }
        return sum;
    }

    private static int prod(int[] table){
        int product = 1;
        for(int i = 0; i < table.length; i++){
            product = product * table[i];
        }
        return product;
    }

    private static int[] smooth(int[] table){
        int[] new_table = new int[table.length];

        if (table.length == 1) {
            new_table = table;

        } else if (table.length == 2) {
            new_table[0] = (table[0] + table[1])/2;
            new_table[1] = new_table[0];

        } else {
            for (int i = 0; i < table.length; i++) {
                if (i == 0) {
                    new_table[i] = (table[i] + table[i + 1])/2;
                } else if (i == table.length - 1) {
                    new_table[i] = (table[i - 1] + table[i])/2;
                } else {
                    new_table[i] = (table[i - 1] + table[i] + table[i + 1])/3;
                }
            }
        }
        return new_table;
    }

}


