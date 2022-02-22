import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class longestSubsequence {

    public static void main(String[] args) {
        System.out.println("Hello");

//        Input:
//        N = 7
          int A[] = {1,2,3,4,5};
//        Output:
//        6
//        Explanation:
//        The consecutive numbers here
//        are 1, 2, 3, 4, 5, 6. These 6
//        numbers form the longest consecutive
//        subsquence.

        findLongestConseqSubseq(A, 5);
        System.out.println(findLongestConseqSubseq(A, 5));
    }



    static int findLongestConseqSubseq(int arr[], int N)
    {
        Set<Integer> treeSet = new TreeSet<Integer>();
        for(int num : arr) {
            treeSet.add(num);
        }
        int answer = 0;

        Integer[] array = treeSet.stream().toArray(Integer[]::new);
        int temp = 0;
        for (int i =1; i<array.length ; i++){

            if(array[i] == array[i-1] + 1) {
                ++temp;
            }
            else {
                answer = Math.max(temp, answer);
                temp = 0;
            }
        }
        answer = Math.max(temp, answer);
        if (answer == 0) {
            return 0;
        }
        return answer + 1;
    }

}
