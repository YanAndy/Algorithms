/**
 * Created by andy on 3/8/17.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RemoveDuplicates{
    /**
     * remove duplicate from unsorted array
     * Using HashSet, O(n) time, O(n) space
     * @param array
     * @return
     */
    public static List<Integer> removeDuplicatesI(int[] array){
        List<Integer> res = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < array.length; i++){
            if(!set.contains(array[i])){
                res.add(array[i]);
                set.add(array[i]);
            }
        }
        return res;
    }

    /**
     * Inplace modification
     * @param array
     */
    public static void removeDuplicatesII(int[] array){
        int k = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < array.length; i++){
            if(!set.contains(array[i])){
                array[k++] = array[i];
                set.add(array[i]);
            }
        }
        for(int j = k; j < array.length; j++) array[j] = Integer.MIN_VALUE;
    }
    public static void main(String[] args){
        //RemoveDuplicates r = new RemoveDuplicates();
        int[] array = new int[]{1,5,2,6,8,9,1,1,10,3,2,4,1,3,11,3};
        List<Integer> result = removeDuplicatesI(array);
        for(int n : result){
            System.out.print(n + ", ");
        }
        System.out.println();

        removeDuplicatesII(array);

        for(int i : array){
            if(i == Integer.MIN_VALUE) break;
            System.out.print(i + ", ");
        }
    }
}
