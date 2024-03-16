

/*   
 * step1: linear scan left -> right while runnerIndex < nums.length
 * | 3 | 2 | 2 | 3 |
 *   ^           ^
 *   |           |
 *   |           |
 *   0...runnerIndex...> nums.length-1
 * 
 * val = 3
 * int nonValLastIndex = 0;
 * int runnerIndex = 0;
 * while(runnerIndex < nums.length)
 * 
 * 
 * step2:split array into two sections, non-val and val sections using two indeces
 * 
 *   nonValLast
 *         |
 * non-val | val
 *         |
 *         x
 *       | 3 | 2 | 2 | 3 |
 *         ^           ^
 *         |           |
 *         |           |
 *         0...runnerIndex...> nums.length-1
 * 
 * 
 * 
 * step3: if nums[runnerIndex] != val, then swap(nums[nonValLast], nums[runnerIndex])
 * runnerIndex = 1
 * 
 *   nonZeroLast
 *         |
 * non-zero| zero-section
 *         |
 *         x
 *       | 3 | 2 | 2 | 3 |
 *             ^       ^
 *             |       |
 *             |       |
 *             0...runnerIndex...> nums.length-1
 *     
 * 
 * after swap, runner = 2, zero skip
 *       nonZeroLast
 *             |
 *     non-zero| zero-section
 *             |
 *             x
 *       | 2 | 3 | 2 | 3 |
 *                 ^   ^
 *                 |   |
 *                 |   |
 *                 0...runnerIndex...> nums.length-1
 * 
 * 
 */

package remove_integer_from_array_6;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Main main = new Main();
    int target = 3;
    int[] nums = {3,2,2,3};
    System.out.println(main.removeElement(nums, target));
  }

  public int removeElement(int[] nums, int target) {

    int nonValLastIndex = 0;
    int runnerIndex = 0;
    while(runnerIndex < nums.length -1) {
      if(nums[runnerIndex] != target) {
        swap(nums, nonValLastIndex, runnerIndex);
        nonValLastIndex++;
        runnerIndex++;
      }else{
        runnerIndex++;
      }
    }
    System.out.println(Arrays.toString(nums));
    return nonValLastIndex;
  }

  private void swap(int[] nums, int nonValLastIndex, int runnerIndex){
    int temp = nums[nonValLastIndex];
    nums[nonValLastIndex] = nums[runnerIndex];
    nums[runnerIndex] = temp;
  }
} 
