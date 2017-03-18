/**
 * Created by andy on 3/17/17.
 */
import java.util.List;
import java.util.ArrayList;
public class Permutaions {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(res, new ArrayList<Integer>(), nums);
        return res;
    }
    public static void dfs(List<List<Integer>> res, List<Integer> list, int[] nums){
        if(list.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
            System.out.print("/*********find one**********/ ");
            for(Integer j : list) System.out.print(j + ", ");
            System.out.println();
            return;
        }
        for(int i : nums){
            if(list.contains(i)) continue;
            list.add(i);
            for(Integer j : list) System.out.print(j + ", ");
            System.out.println();
            dfs(res, list, nums);
            list.remove(list.size() -1);
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4};
        permute(nums);
    }
}
