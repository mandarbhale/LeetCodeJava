import java.util.*;
public class MaxDepthBinaryTree {
    static List<List<Integer>> res;
    public static void subsets(int[] nums,int index,List<Integer> list){
        if(index==nums.length-1){
            res.add(new ArrayList<Integer>(list));
            list.add(nums[index]);
            res.add(new ArrayList<Integer>(list));
            System.out.print("Removing this element :: " + list.get(list.size()-1));
            System.out.print("\n");
            list.remove(list.size()-1);
            return;
        }
        subsets(nums,index+1,list);
        list.add(nums[index]);
        subsets(nums,index+1,list);
        list.remove(list.size()-1);
    }
    public static void main(String[] args) {
        res = new ArrayList<>();
        int[] nums={2, 3, 4};
        List<Integer> list = new ArrayList<Integer>();
        subsets(nums, 0, list);
        for(List<Integer> subset:res){
            for(int i: subset){
                System.out.print(i+", ");
            }
            System.out.println();
        }
    }
}
