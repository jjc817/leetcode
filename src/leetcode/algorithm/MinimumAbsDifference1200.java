package leetcode.algorithm;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsDifference1200 {
    public static void main(String[] args) {
        List<List<Integer>> lists = myMinimumAbsDifference(new int[]{6,1,3,8});
        System.out.println(lists);
    }
    public static List<List<Integer>> myMinimumAbsDifference(int[] arr) {

        List<List<Integer>> minimumAbsLists = new ArrayList<>();
        Arrays.sort(arr);
        int min =arr[1]-arr[0];
        for (int i =0; i < arr.length - 1; i++) {

            if(arr[i + 1]-arr[i] < min){
                min = arr[i + 1]-arr[i];
                minimumAbsLists.clear();
                List<Integer> pair = Arrays.asList(arr[i],arr[i+1]);
                minimumAbsLists.add(pair);
            }else if(arr[i + 1] - arr[i] == min){
                List<Integer> pair = Arrays.asList(arr[i],arr[i+1]);
                minimumAbsLists.add(pair);
            }

        }
        return minimumAbsLists;
    }
    //官方源码
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        int best = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < n - 1; ++i) {
            int delta = arr[i + 1] - arr[i];
            if (delta < best) {
                best = delta;
                ans.clear();
                List<Integer> pair = new ArrayList<Integer>();
                pair.add(arr[i]);
                pair.add(arr[i + 1]);
                ans.add(pair);
            } else if (delta == best) {
                List<Integer> pair = new ArrayList<Integer>();
                pair.add(arr[i]);
                pair.add(arr[i + 1]);
                ans.add(pair);
            }
        }

        return ans;
    }


}
