/*
 * input: N K
 *        A1 A2 ..... AN
 * 
 * 差がK以下になるような選び方は何パターン存在？
 * 
 * 
 * 
 */


package competitive_programings;

public class Main {
  public static void main(String[] args) {
    int K = 10;
    int[] array = {11,12,16,22,27,28,31};
  
    Main main = new Main();
    System.out.println(main.getClosePairCount(array, K));
    
  }

  public int getClosePairCount(int[] array,int K) {
    int head = 0;
    int run = 1;
    int result = 0;
    int last = array.length -1;

    while (head != last) {

      if(array[run] - array[head] <= K){
        result += 1;
        run++;
      }else{
        head++;
        run = head + 1;
      }

      if(run > last){
        head++;
        run = head + 1;
      }

    }
    return result;
  }

}