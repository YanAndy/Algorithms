import java.util.HashMap;

/**
 * Created by andy on 2/28/17.
 */
public class Test001 {
    public static int[] twoSum(int[] nums, int target) {
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
        int[] arr =  new int[]{1,2,5,6};
        int target = 7;
        int[] res = twoSum(arr, target);
        System.out.print("pairs:" + res[0] +"," + res[1]);
    }
}
