public class circularTour {
    public static void main(String[] args) {
        System.out.println("Hello");

//        Input:
//        N = 4
//        Petrol = 4 6 7 4
//        Distance = 6 5 3 5
//        Output: 1
//        Explanation: There are 4 petrol pumps with
//        amount of petrol and distance to next
//        petrol pump value pairs as {4, 6}, {6, 5},
//        {7, 3} and {4, 5}. The first point from
//        where truck can make a circular tour is
//        2nd petrol pump. Output in this case is 1
//        (index of 2nd petrol pump).

        int petrol[] = {4, 6, 7, 4};
        int distance[] = {6, 5, 3, 5};
        int startPoint = tour(petrol, distance);
        System.out.println(startPoint);

    }
    static int tour(int petrol[], int distance[])
    {
        for (int i=0 ; i < petrol.length ; i++) {
            if (petrol[i] - distance[i] < 0) {
                i = i+1;
                continue;
            }
         if (isFeasible(petrol, distance, i)) {
             return i;
         }
        }
        return -1;
    }
    static boolean isFeasible(int[] petrol, int[] distance, int startPoint) {
        int surplus = 0;
        int length = distance.length;
        for (int i = startPoint ; i < startPoint + petrol.length ; i++) {
            surplus += petrol[i%length] - distance[i%length];
            if (surplus < 0) {
                return false;
            }
        }
        if (surplus >= 0) {
            return true;
        }
        return false;
    }
    int tourReal(int petrol[], int distance[])
    {
        int sumRemaining = 0; // track current remaining
        int total = 0; // track total remaining
        int start = 0;

        for (int i = 0; i < petrol.length; i++) {
            int remaining = petrol[i] - distance[i];

            //if sum remaining of (i-1) >= 0, continue
            if (sumRemaining >= 0) {
                sumRemaining += remaining;
                //otherwise, reset start index to be current
            } else {
                sumRemaining = remaining;
                start = i;
            }
            total += remaining;
        }

        if (total >= 0){
            return start;
        }else{
            return -1;
        }
    }
}
