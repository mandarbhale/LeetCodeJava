import java.util.Arrays;

public class find3Sum {

    public static void main(String[] args) {
        System.out.println("Hello");

//        Input:
//        n = 6, X = 13
//        arr[] = [1 4 45 6 10 8]
//        Output:
//        1
//        Explanation:
//        The triplet {1, 4, 8} in
//        the array sums up to 13.
        int array[] = {4, 6, 7, 4, 10};
        find3Numbers(array, 5, 14);
        System.out.println(find3Numbers(array, 5, 14));
    }

    public static boolean find3Numbers(int A[], int n, int x) {

        Arrays.sort(A);
        int l = 0;
        int r = 0;
        for (int i=0; i<n-2; i++) {
            l = i+1;
            r = n-1;
            int temp = A[i] + A[l] + A[r];
            System.out.println(temp);
            if (temp == x) {
                return true;
            }
            while (l<r) {
                temp = A[i] + A[l] + A[r];
                if (temp == x) {
                    return true;
                }
                if (temp > x) {
                    r = r-1;
                }
                else {
                    l = l+1;
                }
            }
        }
        return false;
    }
}

