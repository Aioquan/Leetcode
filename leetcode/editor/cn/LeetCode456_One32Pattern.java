//给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足
//：i < j < k 和 nums[i] < nums[k] < nums[j] 。 
//
// 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。 
//
// 
//
// 进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4]
//输出：false
//解释：序列中不存在 132 模式的子序列。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,4,2]
//输出：true
//解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,3,2,0]
//输出：true
//解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 栈 
// 👍 350 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode456_One32Pattern {
    public static void main(String[] args) {
        Solution solution = new LeetCode456_One32Pattern().new Solution();
        System.out.println(solution.find132pattern(new int[]{-2, 1, 2, -2, 1, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean find132pattern(int[] nums) {

            if (nums.length < 3) return false;
            Deque<Integer> stack = new ArrayDeque<>();
            int index = 0;
            while (index < nums.length) {
                stack.clear();
                for (int i = index; i < nums.length; i++) {

                    if (stack.size() == 0) stack.addLast(nums[i]);

                    if (stack.size() == 1 && nums[i] > stack.getLast()) stack.addLast(nums[i]);

                    if (stack.size() == 2 && stack.getLast() < nums[i]) {
                        stack.pollLast();
                        stack.addLast(nums[i]);
                    }
                    if (stack.size() == 2 && (nums[i]) > stack.getFirst() && nums[i] < stack.getLast())
                        return true;
                    
                }
                index++;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}