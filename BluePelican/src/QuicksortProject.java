public class QuicksortProject {

    private int[] theArray = {4,2,5,1,3,18,0,9,6};

    private void start() {
        tester();
    }

    private void sort(int[] a, int left, int right) {
        if(left >= right) return;
        int k = left;
        int j = right;
        int pivotValue = a[(left + right) / 2];
        while(k < j) {
            while(a[k] < pivotValue) {
                k++;
            }
            while(pivotValue < a[j]) {
                j--;
            }
            if(k <= j) {
                int temp = a[k];
                a[k] = a[j];
                a[j] = temp;
                k++;
                j--;
            }
        }
        sort(a, left, j);
        sort(a, k, right);
    }

    private void tester() {
        sort(theArray, 0, theArray.length - 1);
        for(int i : theArray) {
            System.out.print(Integer.toString(i) + " ");
        }
    }

    public static void main(String[] args) {
        new QuicksortProject().start();
    }
}