/**
 * Created by andy on 3/6/17.
 */
import java.util.*;

public class SplitArray {
    public static boolean split4(int[] array){
        if(array.length < 7) return false;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = array.length;
        int sum = 0;
        for(int i = 0; i< len; i++){
            sum += array[i];
            map.put(sum, i);
        }

        int s1 = 0;
        int j = 0;
        int k = 0;
        int l = 0;

        for(int i = 0; i < len - 6; i++){
            s1 += array[i];
            //System.out.println("first segment: " + s1);
            if(!map.containsKey(s1 + array[i+1] + s1)) continue;
            j = map.get(s1 + array[i+1] + s1);
            if(!map.containsKey(s1 + array[i+1] + s1 + array[j+1] + s1)) continue;
            k = map.get(s1 + array[i+1] + s1 + array[j+1] + s1);
            if(!map.containsKey(s1 + array[i+1] + s1 + array[j+1] + s1 + array[k+1] + s1)) continue;
            l = map.get(s1 + array[i+1] + s1 + array[j+1] + s1 + array[k+1] + s1);
            if(l == len -1) return true;
        }
        return false;
    }

    public static void main(String[] args){
        //int[] arr  = new int[]{2,5,1,1,1,1,4,1,7,3,7};
        int[] arr  = new int[]{1,1,1,1,1,1,1,1,1,3};
        System.out.println(split4(arr));
    }
}
