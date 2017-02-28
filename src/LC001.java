import java.util.HashMap;

/**
 * Created by andy on 2/28/17.
 *
 * HashMap: store and search keys
 * O(n) time, o(n) space
 *
 */
public class LC001 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> pair=new HashMap<>();
        int result[] = new int[2];
        for(int i=0;i<nums.length;i++){
            if(pair.containsKey(nums[i])){
                result[0]=pair.get(nums[i]);
                result[1]=i;
                return result;
            }
            else pair.put(target-nums[i], i);
        }
        return result;
    }

    public static void main(String[] args){
        System.out.print("test001");
    }
}