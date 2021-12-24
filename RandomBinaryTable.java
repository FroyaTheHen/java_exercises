import java.util.Random;

public class RandomBinaryTable {
    private final static int DIMENSION_SIZE = 4;

    public static void main(String[] args){
        Random random = new Random();
        int[][] random_binary_tab =
                new int[RandomBinaryTable.DIMENSION_SIZE]
                        [RandomBinaryTable.DIMENSION_SIZE];

        int zeros_in_last_row = 0;
        int max_zero_row_index = 0;
        int number_of_max_zeros = 0;

        int ones_in_last_row = 0;
        int max_ones_row_index = 0;
        int number_of_max_ones = 0;

            for(int i=0; i<RandomBinaryTable.DIMENSION_SIZE; i++){

                for(int j=0; j<RandomBinaryTable.DIMENSION_SIZE; j++){
                    random_binary_tab[i][j] = random.nextInt(2);
                    System.out.print(random_binary_tab[i][j]);
                    System.out.print("     ");

                    if(random_binary_tab[i][j]==0)
                        zeros_in_last_row++;
                    else
                        ones_in_last_row++;
                    }

                System.out.println("");
                if(zeros_in_last_row>number_of_max_zeros){
                    max_zero_row_index=i;
                    number_of_max_zeros=zeros_in_last_row;
                }
                if(ones_in_last_row>number_of_max_ones){
                    max_ones_row_index=i;
                    number_of_max_ones=ones_in_last_row;
                }
                zeros_in_last_row=0;
                ones_in_last_row=0;
                }

            System.out.println("max zeros in row index: "+ max_zero_row_index
                    + ", max zeros number = " +number_of_max_zeros);
            System.out.println("max ones in row index: "+ max_ones_row_index
                    + ", max ones number = " +number_of_max_ones);
            }
}

