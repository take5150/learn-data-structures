package two_sum_question_3;

import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    Main main = new Main();
    int[] nums = {11,15,2,7};
    int[] res = main.twoSum(nums);
    System.out.println(res[0] + "," + res[1]);
  }

  // 2要素を足してターゲットの値と同じになるセットのインデックスを返却する。
  // pre: nums[2,7,11,15], target = 9
  // post: [0,1]
  public int[] twoSum(int[] nums) {

    
    Map<Integer, Integer> map = new HashMap<>();
    int target;
    target = 9;

    int[] result = new int[2];
  
    // step1: 配列を左からスキャンし、ハッシュマップのキーに値、バリューにインデックスを挿入
    for(int i=0; i < nums.length; i++) {
      // step2: ハッシュマップ内に"(target - nums[i])に該当するキーが存在すればインデックスを返却する。
      //        X + nums[i] = target --> X = target - nums[i]と考えられる。

      // testcase1: nums[2,7,11,15], target=9, i=0, map[()], target_num=nil
      // testcase2: nums[2,7,11,15], target=9, i=1, map[(2,0)], target_num=7 => return result[0]
      if(map.containsKey(target - nums[i])){
        result[0] = map.get(target - nums[i]);
        result[1] = i;
        return result;
      }else {
        map.put(nums[i], i);
      }
    }
    return result;
  }  
}
