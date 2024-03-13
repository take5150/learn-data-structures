// 疑似コード

// step1: 配列を先頭と最後尾から中央に向かわせる

// i=0 i=1 i=2
// ===========
//  d | o | g
// -->      <--
// front    end
// 
// int front = 0, end = s.length - 1;
// while(front < end)

// step2: 配列要素をスワップする
// i=0 i=1 i=2
// ===========
//  g | o | d
// -->      <--
// front    end
// 
// char temp = s[front];
// s[front] = s[end];
// s[end] = temp

// step3: 各インデックスを動かす
// i=0 i=1 i=2
// ===========
//  g | o | d
//      ||
// front    end
// 
// fornt++;
// end++;



package reverse_string_4;

public class Main {
  public static void main(String[] args) {

    Main main = new Main();

    char[] s = {'w', 'a', 't', 'a'};
    main.reverseString(s);
  }


  // pre:s[c,a,t] 
  // post:s[t,a,c]
  public void reverseString(char[] s) {

    int front = 0;
    int end = s.length - 1;

    // step1: 配列を先頭と最後尾から中央に向かわせる
    while(front < end) {
      
      // step2: 配列要素をスワップする
      swap(s, front, end);

      // step3: 各インデックスを動かす
      front++;
      end--;
    }

    System.out.print(s);
  }

  private void swap(char[] s, int front, int end) {
    char temp = s[front];
    s[front] = s[end];
    s[end] = temp;
  }
}
