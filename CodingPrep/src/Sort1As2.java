import java.util.*;

public class Sort1As2 {
    public static void main(String[] args) {
        System.out.println("Hello");
//        int N = 11;
//        int M = 4;
//        int A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
//        int A2[] = {99, 22, 444, 56};
        int N = 11;
        int M = 4;
        int A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int A2[] = {2, 1, 8, 3};
//        Output:
//        2 2 1 1 8 8 3 5 6 7 9
        sortA1ByA2(A1 ,N , A2, M);
    }

    public static int[] sortA1ByA2(int A1[], int N, int A2[], int M)
    {
        Set<Integer> firstArray = new TreeSet<>();
        Map<Integer,Integer> countMap = new HashMap<>();

        for (int i = 0 ; i < N ; i++) {
            firstArray.add(A1[i]);
            if(countMap.containsKey(A1[i])) {
                countMap.put(A1[i],countMap.get(A1[i])+1);
            }
            else {
                countMap.put(A1[i],1);
            }
        }

        System.out.println(countMap);
        System.out.println(firstArray);

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0 ; i < M ; i++) {
            if(firstArray.contains(A2[i])) {
                while (countMap.get(A2[i]) != 0) {
                    list.add(A2[i]);
                    countMap.put(A2[i],countMap.get(A2[i])-1);
                }
                firstArray.remove(A2[i]);
            }
            else
                continue;
        }

        for(Integer num : firstArray){
            while(countMap.get(num) != 0) {
                list.add(num);
                countMap.put(num,countMap.get(num)-1);
            }
        }
        System.out.println(list);
        int[] arr = list.stream().mapToInt(i -> i).toArray();
        System.out.println(arr);
        return arr;
    }
}
