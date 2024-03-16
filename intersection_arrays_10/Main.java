/*
 * array1=[1,2,3,4] / array2=[1,2,2,4,5]
 * return [1,2,4]
 * 
 * アンチパターン：A,Bでfor文をネストして処理する--> O(n^2)
 * 
 * 最適パターン：scan A, B in O(n) , and keep info in map
 * 
 * 
 * step1:Aをループしてmapにカウント情報を設定する
 * for(int num: array1)
 *  map.put(k, 1)
 * 
 * step2:Bをループしてmapのカウント情報を設定する/ keyが存在する場合のみ実施
 * for(int num: array2)
 *  if(map.containsKey(num)) map.put(k, 0)
 * 
 * step3:mapをループしてvalueが0のものを抽出する
 * for(Map.Entry<Integer, Integer> entry: map.entrySet())
 *  if(entry.getValue == 0) result[i] = (int) entry.getKey();
 *  
 * 
 */




package intersection_arrays_10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    Main m = new Main();
    int[] array1 = {1,2,3,4};
    int[] array2 = {1,2,4,5};
    System.out.println(Arrays.toString(m.intersectionArrays(array1, array2)));

  }

  public int[] intersectionArrays(int[] array1, int[] array2) {

    // * step1:Aをループしてmapにカウント情報を設定する
    Map<Integer, Integer> map = new HashMap<>();
    for(int num: array1){
      if(!map.containsKey(num)){
        map.put(num, 1);
      }
    }
    // * step2:Bをループしてmapのカウント情報を設定する/ keyが存在する場合のみ実施
    int numOfIntersections = 0;
    for(int num: array2){
      if(map.containsKey(num) && map.get(num) == 1){
        map.put(num, 0);
        numOfIntersections++;
      }
    }

    // * step3:mapをループしてvalueが0のものを抽出する
    int[] results = new int[numOfIntersections];
    int i = 0;
    for(Map.Entry<Integer,Integer> entry: map.entrySet()){
      if(entry.getValue() == 0){
        results[i] = entry.getKey();
        i++;
      }
    }

    return results;

  }


  
}
