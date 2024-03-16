

/*   
 * step1: linear scan left -> right while runnerIndex < nums.length
 * | 0 | 1 | 0 | 12 | 0 | 16 |
 *   ^                     ^
 *   |                     |
 *   |                     |
 *   0...runnerIndex...> nums.length-1
 * 
 * int nonZeroLast = 0;
 * int runnerIndex = 0;
 * while(runnerIndex < nums.length)
 * 
 * 
 * step2:split array into two sections, non-zero and zero sections using two indeces
 * 
 *   nonZeroLast
 *         |
 * non-zero| zero-section
 *         |
 *         x
 *       | 0 | 1 | 0 | 12 | 0 | 16 |
 *         ^                     ^
 *         |                     |
 *         |                     |
 *         0...runnerIndex...> nums.length-1
 * 
 * 
 * 
 * step3: if nums[runnerIndex] != 0, then swap(nums[nonZeroLast], nums[runnerIndex])
 * runnerIndex = 1
 * 
 *   nonZeroLast
 *         |
 * non-zero| zero-section
 *         |
 *         x
 *       | 0 | 1 | 0 | 12 | 0 | 16 |
 *             ^                 ^
 *             |                 |
 *             |                 |
 *             0...runnerIndex...> nums.length-1
 *     
 * 
 * after swap, runner = 2, zero skip
 *       nonZeroLast
 *             |
 *     non-zero| zero-section
 *             |
 *             x
 *       | 1 | 0 | 0 | 12 | 0 | 16 |
 *                 ^             ^
 *                 |             |
 *                 |             |
 *                 0...runnerIndex...> nums.length-1
 * 
 * 
 * after zero skip, runner = 3
 *       nonZeroLast
 *             |
 *     non-zero| zero-section
 *             |
 *             x
 *       | 1 | 0 | 0 | 12 | 0 | 16 |
 *                      ^        ^
 *                      |        |
 *                      |        |
 *                      0...runnerIndex...> nums.length-1
 * 
 * swap(nums[nonZeroLast], nums[runnerIndex])
 * 
 * 
 */

package move_zero_in_array_5;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Main main = new Main();
    int[] nums = {0,1,0,12,0,16};
    main.moveZeroes(nums);
  }

  // pre : nums[0,1,0,12,0,16]
  // post: nums[1,12,16,0,0,0]
  public void moveZeroes(int[] nums) {

    // step1: linear scan left -> right while runnerIndex < nums.length
    // testcase1: nums[0,1,0,12,0,16], nonZeroLastIndex = 0, runnerIndex=0
    // testcase2: nums[0,1,0,12,0,16], nonZeroLastIndex = 0, runnerIndex=1
    // testcase3: nums[1,0,0,12,0,16], nonZeroLastIndex = 1, runnerIndex=2
    // testcase4: nums[1,0,0,12,0,16], nonZeroLastIndex = 1, runnerIndex=3
    int nonZeroLastIndex = 0;
    int runnerIndex = 0;
    while(runnerIndex < nums.length - 1){
      // step2:split array into two sections, non-zero and zero sections using two indeces
      // step3: if nums[runnerIndex] != 0, then swap(nums[nonZeroLast], nums[runnerIndex])
      if(nums[runnerIndex] != 0) {
        swap(nums, nonZeroLastIndex, runnerIndex);
        nonZeroLastIndex++;
        runnerIndex++;
        // testcase2: nums[1,0,0,12,0,16], nonZeroLastIndex = 1, runnerIndex=1
        // testcase4: nums[1,12,0,0,0,16], nonZeroLastIndex = 2, runnerIndex=3
      }else {
        runnerIndex++;
        // testcase1: nums[0,1,0,12,0,16], nonZeroLastIndex = 0, runnerIndex=1
        // testcase3: nums[1,0,0,12,0,16], nonZeroLastIndex = 1, runnerIndex=2
        swap(nums, nonZeroLastIndex, runnerIndex);
      }
    }
    System.out.print(Arrays.toString(nums));
  }

  private void swap(int[] nums, int nonZeroLast, int runnerIndex){

    int temp = nums[nonZeroLast];
    nums[nonZeroLast] = nums[runnerIndex];
    nums[runnerIndex] = temp;
  }
} 
