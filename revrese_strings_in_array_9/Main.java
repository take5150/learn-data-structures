/*
 * 
 *                    s                                        s'
 * ---------------------------------------  --------------------------------------------
 * |_i_|_ _|_a_|_m_|_ _|_t_|_k_|__|         |_i_|_ _|_m_|_a_|_ _|_k_|_t_|__| 
 * 
 * アンチパターン：sをスペースでsplitして配列に格納--> arrayをループしてStringBuilderに反転させて各ワードを格納する（arrayを格納するために無駄なスペースn使ってしまう)
 * 最適パターン:sをtoCharArrayで配列に格納--> スペースを検知したらfront,end-1を反転させる
 * 
 * 
 * step1: linear scan left --> rigth with two indeces, front and end
 * 
 * step2: if s.charAt[end] is whitespace, then reverse(s, front, end -1)
 * 
 * step3: set front to end + 1
 * 
 * 
 * 
 */



package revrese_strings_in_array_9;

public class Main {
  public static void main(String[] args) {
    Main m = new Main();
    System.out.println(m.revreseStrings("I am take"));
  }

  // pre : "I am take"
  // post: "I ma ekat"
  public String revreseStrings(String s){

    int front = 0;
    int end = 0;
    char[] c = s.toCharArray();

    while (end <= s.length() - 1) {
      if (c[end] == ' '){
        reverse(c, front, end - 1);
        front = end + 1;
        end++;
      }else if(end == s.length() - 1) {
        reverse(c, front, end);
      }
      end++;
    }
    return new String(c);
    
  }

  private void reverse(char[] c, int front, int end){
    while(front < end){
      char temp = c[front];
      c[front] = c[end];
      c[end] = temp;
      front++;
      end--;
    }
  }
  
}
