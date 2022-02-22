import java.util.Arrays;

public class tripletInRange {
    public static void main(String[] args) {
        System.out.println("Hello");
//
//        7
//        9 4 6 1 2 3 8
//        3 14
//        {1,2,3,4,6,8,9}

        int[] Arr = {9,4,6,1,2,3,8};
        int L = 3, R = 14 ;

//        N = 5
//        Arr = {5, 1, 4, 3, 2}  I I I I I
//        L = 2, R = 7

        int ans = countTripletsModified(Arr,7, L, R);
        System.out.println(ans);
    }

    static int countTriplets(int Arr[], int N, int L, int R) {

        int ans;

        ans = tripletsLessThan(Arr, N, R) - tripletsLessThan(Arr, N, L - 1);

        return ans;
    }

    public static int tripletsLessThan(int []arr,int n, int val)
    {
        Arrays.sort(arr);
        int c = 0, j, k;
        // Variable to store sum of triplets
        int s;

        // Fix the first element
        for (int i = 0; i < n - 2; i++) {

            // Initialize other two elements as corner elements of subarray
            // arr[j+1..k]
            j = i + 1;
            k = n - 1;

            // Using Meet in the Middle concept
            while (j != k) {
                s = arr[i] + arr[j] + arr[k];

                // If triplet sum is greater,reduce it by decreasing k
                if (s > val)
                    k--;

                    // If sum is less than or equal to given value, then add possible
                    // triplets (k-j) to result
                else {
                    c += (k - j);
                    j++;
                }
            }
        }

        return c;
    }

    static int countTripletsModified(int Arr[], int N, int L, int R) {

        int answer = 0;
        Arrays.sort(Arr);
        for (int num : Arr) {
            System.out.print(num + " ");
        }
        System.out.println("");
        int l = 0;
        int r = N-1;
        int tempSum = 0;
        for (int i =0; i<N ; i++) {
            l = i+1;
            r = N-1;
            for (int j = l ; j < r ; j++) {
                tempSum = Arr[i] + Arr[j] + Arr[r];
                if (tempSum >= L && tempSum <=R) {
                    answer++;
                    System.out.println("Triplet is :: " + Arr[i] + " " + Arr[l] + " " + + Arr[r]);
                    r--;
                }
                if (tempSum < L) {
                    l++;
                }
                if(tempSum > R) {
                    r--;
                }
            }
        }
        return answer;
    }


    }
