//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 字符串 
// 👍 339 👎 0

package leetcode.editor.cn;

public class LeetCode415_AddStrings {
    public static void main(String[] args) {
        Solution solution = new LeetCode415_AddStrings().new Solution();
        System.out.println(solution.addStrings("11", "123"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            StringBuffer res = new StringBuffer();
            int i = num1.length() - 1;
            int j = num2.length() - 1;
            int add = 0;
            while (i >= 0 || j >= 0 || add > 0) {
                int x = i >= 0 ? num1.charAt(i) - '0' : 0;
                int y = j >= 0 ? num2.charAt(j) - '0' : 0;
                int r = x + y + add;
                add = r / 10;
                r = r % 10;
                res.append(r);
                i--;
                j--;
            }


            res.reverse();

            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}