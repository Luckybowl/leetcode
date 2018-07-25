package Blockchain;

import java.util.HashMap;
import java.util.Map;

public class Blockchain {

    public static Map<Float,Float> blockChain(float nums,int days){
        Map<Float,Float> map = new HashMap<>();
        float sum = 0;
        float z = 0;
        if(days <= 0){
            throw new IllegalArgumentException("days must > 0!");
        }
        for(int i = 0; i < days; i++){
            z += nums * 3/1000;
            nums = nums - nums * 3/1000;
        }
        System.out.println(z * days);
        System.out.println(nums);
        map.put(z * days, nums);
        return map;
    }
    public static void main(String[] args){
        blockChain(1000.45f,10);

    }
}
