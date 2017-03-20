/**
 * Created by andy on 3/17/17.
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class JumpGame {
    public int jump(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        int max = 0;
        int step = 0;
        int e = 0;
        for(int i = 0; i < nums.length-1; i ++){
            max = Math.max(max, i+ nums[i]);
            if(i == e){
                step ++;
                e = max;
            }
        }
        if(e >= nums.length -1) return step;
        else return -1;
    }



    public void jump2(int[] nums){
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) {
            System.out.println("fail");
            return;
        }
        int target = nums.length;
        int step  = target;
        res.add(step);
        try {
            while (target > 0) {
                for (int i = target - 1; i >= 0; i--) {

                    if(nums[i] < 0){
                        System.out.println("fail");
                        throw new NullPointerException();
                    }

                    if (i + nums[i] >= target) {
                        step = i;
                        //i--;
                    }
                }
                if (step == res.get(res.size() - 1)) {
                    System.out.println("fail");
                    throw new NullPointerException();
                    //return new ArrayList<Integer>();
                }
                res.add(step);
                System.out.println("step: " + step + ", value: " + nums[step]);
                target = step;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        Collections.reverse(res);
        //return res;
        res.remove(res.size() -1);
        System.out.println("Total Step 2: " + (res.size() -1));
        for(int i : res) System.out.print(i + " ");
        System.out.println("out");


    }

    public static void main(String[] args) throws IOException {
        /*
        int[] input0 = new int[]{2,3,1,1,4};
        int[] input1 = new int[]{3,2,1,0,4};
        int[] input2 = new int[]{2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6};

        int[] input3 = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int[] input4 = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1};
        int[] input5 = new int[]{100,99,98,97,96,95,94,93,92,91,90,89,88,87,86,85,84,83,82,81,80,79,78,77,76,75,74,73,72,71,70,69,68,67,66,65,64,63,62,61,60,59,58,57,56,55,54,53,52,51,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,1,0,0};

        int[] input6 = new int[25002];
        for(int i = 0; i < 25000; i++) input6[i] = (25000 - i);
        input6[25000] = 1;
        input6[25001] = 0;

        int[] input7 = new int[30001];
        for(int i = 0; i < 30000; i++) input7[i] = 1;


        int[] input8 = new int[30001];
        for(int i = 0; i < 30000; i++) input8[i] = i+1;

        int[] input9 = new int[]{5,6,0,4,2,4,1,0,0,4};
*/
        int[] input10 = new int[]{5,6,0,4,2,4,1,0,0,4};

        String output = args[0];
        File resultFile = new File(output);
        FileOutputStream outputStream = new FileOutputStream(resultFile);


        //for(int i = 0; i < 30001; i++) outputStream.write((input8[i] + ",").getBytes());
        //int len  = 0;
        try{
            Scanner input = new Scanner("10,6,0,4,2,4,1,0,0,4");
            input.useDelimiter(",");

            List<Integer> numArray = new ArrayList<Integer>();
            while (input.hasNext()){

                int in = input.nextInt();
                if(in < 0) {
                    System.out.println("failure");
                    throw new IllegalArgumentException();
                }
                numArray.add(in);
                //len ++;
                //System.out.println("len: " + len);

            }

            input.close();

            Integer[] numbers = numArray.toArray(new Integer[0]);
            if(numbers.length == 0) throw new IllegalArgumentException();

            int[] number = new int[numbers.length];
            for(int i = 0; i < numbers.length; i++) number[i] = numbers[i].intValue();


            for(int n: numbers) System.out.println(n);

            int[] nums = number;

            JumpGame game = new JumpGame();

            int res = game.jump(nums);
            System.out.println("Total Step: " + res);
            //List<Integer> route = jump2(nums);
            //System.out.println("Total Step 2: " + (route.size() -1));
            //for(int i : route) System.out.print(i + " ");

            game.jump2(nums);

        }catch(Exception e){
            e.printStackTrace();
        }


    }

}


