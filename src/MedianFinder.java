/**
 * Created by andy on 3/8/17.
 */
import java.util.List;
import java.util.ArrayList;
public class MedianFinder {

    /** initialize your data structure here. */
    //int n;
    List<Integer> list;
    public MedianFinder() {
        list = new ArrayList<Integer>();
        //n = 0;
    }

    public void addNum(int num) {
        int i = 0, j = list.size() -1;
        while(i <= j){
            int mid = i + (j-i) /2;
            if(list.get(mid) == num) {
                i = mid;
                break;
            }
            if(list.get(mid) > num) j = mid -1;
            else i = mid + 1;
        }/*
        if(i == 0){
            if(list.isEmpty() || list.get(0) > num) list.add( 0, num);
            else list.add(i+1, num);
        }
        else if(list.get(i) <  num) list.add(i+1, num);
        else list.add(i, num);*/
        list.add(i, num);
        //n++;
        for(int n : list){
            System.out.print(n + ", ");
        }
        System.out.println();

    }

    public double findMedian() {
        int n = list.size();
        if(n == 0) return 0;
        if(n % 2 == 1) return list.get((n - 1)/2);
        else return (list.get(n/2) + list.get((n-1)/2))* 0.5;
    }

    public static void main(String[] args){
        MedianFinder obj = new MedianFinder();
        //[[],[6],[],[10],[],[2],[],[6],[],[5],[],[0],[],[6],[],[3],[],[1],[],[0],[],[0],[]];
        double m = 0;
        obj.addNum(6);
        m = obj.findMedian();
        System.out.println("Median: " + m);
        obj.addNum(10);
        m = obj.findMedian();
        System.out.println("Median: " + m);
        obj.addNum(2);
        m = obj.findMedian();
        System.out.println("Median: " + m);
        obj.addNum(6);
        m = obj.findMedian();
        System.out.println("Median: " + m);
        obj.addNum(5);
        m = obj.findMedian();
        System.out.println("Median: " + m);
        obj.addNum(0);
        m = obj.findMedian();
        System.out.println("Median: " + m);
        obj.addNum(6);
        m = obj.findMedian();
        System.out.println("Median: " + m);
        obj.addNum(3);
        m = obj.findMedian();
        System.out.println("Median: " + m);
        obj.addNum(1);
        m = obj.findMedian();
        System.out.println("Median: " + m);
        obj.addNum(0);
        m = obj.findMedian();
        System.out.println("Median: " + m);
        obj.addNum(0);
        m = obj.findMedian();
        System.out.println("Median: " + m);



        //double param_2 = obj.findMedian();


    }
}
