//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3289 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15_ThreeSum {
    public static void main(String[] args) {
        Solution solution = new LeetCode15_ThreeSum().new Solution();
        System.out.println(

//                solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4})
                solution.threeSum(new int[]{0, 0, 0, 0})

        );
    }

    /**
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            int len = nums.length;
            if (nums == null || len < 3) {
                return ans;
            }
            Arrays.sort(nums);
            for (int i = 0; i < len; i++) {
                if (nums[i] > 0) {
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int k = i + 1;
                int p = len - 1;
                while (k < p) {
                    int sum = nums[i] + nums[k] + nums[p];
                    if (sum == 0) {
                        ans.add(Arrays.asList(nums[i], nums[k], nums[p]));
                        while (k < p && nums[k] == nums[k + 1]) {
                            k++;
                        }
                        while (k < p && nums[p] == nums[p - 1]) {
                            p--;
                        }
                        k++;
                        p--;
                    } else if (sum < 0) {
                        k++;
                    } else if (sum > 0) {
                        p--;
                    }
                }
            }


            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}