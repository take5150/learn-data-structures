/*
 * 
 * step1 : add items in nums to hashmap and keep count
 * 
 * nums
 * [3,2,3]
 * key:count
 * map(3:2, 2:1)
 * 
 * for(int num: nums)
 *  if(!map.containsKey(num)) map.push(num, 1)
 *  else map.push(num, (map.get(num)+1))
 * 
 * 
 * step2: for each item in map, return the key of count which is > n
 * 
 * array size = 3
 * ceiilng(3/2) = ceiling(1.5) = 2
 * 2 >= cilling(n/2)
 * 
 * for(Map.Entry entry : map.entrySet())
 * 
 * 
 */





package majority_element_problem_7;

import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) {

    Main main = new Main();
    int[] nums = {3,2,3};
    System.out.println(main.majorityElement(nums));
    
  }
  

  // pre: nums[3,2,3]
  // post:3
  public  int majorityElement(int[] nums) {

    // corner case: nums guaranteed to be non-empty

    //  step1 : add items in nums to hashmap and keep count
    Map<Integer, Integer> map = new HashMap<>();
    for(int num: nums) {
      if(!map.containsKey(num)){
        map.put(num, 1);
      }else{
        map.put(num, (map.get(num) + 1));
      }
    }
    
    // step2: for each item in map, return the key of count which is > n
    int majorityNum = nums[0];
    for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if(entry.getValue() >= Math.ceil(nums.length / 2)){
        System.out.println(Math.ceil((double)nums.length / 2));
        return majorityNum = entry.getKey();
      }
    }

    return majorityNum;

  }
}
