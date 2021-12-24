public class GetMinFromTable {
    private static int[] findMinValue(int[] tab) {
        int l = tab.length - 1;
        if( l > 0 ) {
            int smaller_of_two_last = Math.min(tab[l], tab[l-1]);
            tab[l-1] = smaller_of_two_last;
            int[] new_tab = new int[l];

            for (int i = 0; i < new_tab.length; i++) {
                new_tab[i] = tab[i];
            }
        return findMinValue(new_tab);
        } else {
            return tab;
        }
    }
}