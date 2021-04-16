//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1563 👎 0

package leetcode.editor.cn;

public class LeetCode14_LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LeetCode14_LongestCommonPrefix().new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"ab","a"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }
            int minLength = Integer.MAX_VALUE;
            String minStr = strs[0];
            for (
                    String str : strs
            ) {
                if("".equals(str)){
                    return "";
                }
                if (str.length() < minLength) {
                    minLength = str.length();
                    minStr = str;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < minLength; i++) {
                char a = minStr.charAt(i);
                boolean flag = true;
                for (int j = 0; j < strs.length; j++) {
                    char b = strs[j].charAt(i);
                    if (a != b) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    sb.append(a);
                } else {
                    return sb.toString();
                }
            }

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}