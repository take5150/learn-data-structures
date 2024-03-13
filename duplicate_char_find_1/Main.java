package duplicate_char_find_1;
import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    int[] nums = new int[] {1,2,3,1};
    System.out.println(isContainsDuplicate(nums));
  }
  
  // if dup exist in nums return ture
  // pre: nums[1,2,3,1]
  // post: ture
  public static boolean isContainsDuplicate(int[] nums) {

    // corner; nums.length() <= 1 return false
    if(nums.length <= 1) return false;

    Map<Integer, Boolean> map = new HashMap<>();
  
    // step1: single linear scan left --> right , build hash map as we go
    // step2: if map.containsKey(nums[i]) == ture, dup fuound so return ture
    for(int num: nums) {
      if(map.containsKey(num)) return true;
      map.put(num, true);
    }
    
    // return false
    return false;
    
  }

}

