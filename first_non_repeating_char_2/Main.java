package first_non_repeating_char_2;

import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    System.err.println(getNotDuplicate("leetcode"));
  }

  // 重複箇所のインデックスを返却するメソッド
  // pre: s = "leetcode"
  // post : 0
  public static int getNotDuplicate(String string) {

    // corner case: string.length() <= 1のとき、return 0
    if (string.length() <= 1) return 0;

    Map<Integer, Integer> map = new HashMap<>();

    // step1: 文字列を左からスキャンし、ハッシュマップに挿入する。登場回数をカウントに保持する
    // testcase1: s="leetcode", i=0, map[]
    // testcase1: s="leetcode", i=1, map[(l,1)]
    // testcase1: s="leetcode", i=2, map[(l,1),(e,1)]
    // testcase1: s="leetcode", i=3, map[(l,1),(e,2)]
    for (char c: string.toCharArray()){
      if(!map.containsKey((int)c)){
        map.put((int) c, 1);
      }else {
        map.put((int) c, map.get((int)c) + 1);
      }
    }

    // step2: 再度文字列を左からスキャンし、valueが1のデータがあれば文字列のインデックスを返却する
    for(int i = 0; i < string.length(); i++) {
      if (map.get((int)string.charAt(i)) == 1) {
        return i;
      }
    }

    // return -1
    return -1;
    
  }

  
}
