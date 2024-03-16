/*
 * 
 *                    s                                        t
 * ---------------------------------------  --------------------------------------------
 * |_b_|_a_|_s_|_e_|_b_|_a_|_l_|_l_|         |_b_|_s_|_e_|_l_|_l_|_a_|_b_|_a_|
 * 
 * 2つのStringが同じ文字で構成されていることを検証 
 * 
 * 
 * アンチパターン１：s,tをソートする(2nlogn)
 * 
 * 最適パターン：sを左から右に１度スキャンし、mapに出現回数を記録。tを左から右にスキャンし、mapの出現回数を引き算していく(3N)->mapがすべて0であればtrue
 * 
 * for(char c: s.toCharArray())
 *  map.put(k, map.get((int)c) + 1)
 * 
 * for(char c: t.toCharArray())
 *  map.put(k, map.get((int)c)-1)
 * 
 * for(Map.Entry<Integer, Integer> entry : map.entrySet())
 *  if (entry.getValue() != 0) return false
 *  
 * return ture
 * 
 * 
 * エッジケース
 * 
 * 
 * 
 * 
 */




package Anagram_string_8;

import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    Main m = new Main();
    System.out.println(m.isAnagram("dog", "god"));
  }

  // pre  :s=dog, t=god
  // post :true
  public boolean isAnagram(String s, String t) {

    // corner case: if s and t is null, return false
    if(s==null || t== null) return false;

    // if s and t are both empty, return ture
    if(s.isEmpty() && t.isEmpty()) return true;

    // if s and t length is different, return false
    if(s.length() != t.length()) return false;

    // step1: add chars is s to hashmap and keep count
    // testcase1: c=d | map(d=1)
    // testcase2: c=o | map(d=1, o=1)
    // testcase3: c=g | map(d=1, o=1, g=1)
    Map<Integer, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()){
      if(!map.containsKey((int)c)){
        map.put((int)c, 1);
      }else {
        map.put((int)c, map.get((int)c) + 1);
      }
    }
    
    // step2: linear scan left->right of t, subtract 1 from key`s
    // 
    // testcase4: c=g | map(d=1, o=1, g=0)
    // testcase5: c=o | map(d=1, o=0, g=0)
    // testcase6: c=d | map(d=0, o=0, g=0)
    for(char c: t.toCharArray()){
      if(map.containsKey((int)c)){
        map.put((int)c, map.get((int)c) - 1);
      }else{
        return false;
      }
    }

    // step3: loop map and check all value is zero, return ture
    for(Map.Entry<Integer,Integer> entry: map.entrySet()){
      if((int)entry.getValue() != 0){
        return false;
      }
    }
    return true;

  }

  
}
