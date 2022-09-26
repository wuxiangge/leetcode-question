/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= nums.length <= 10⁴
 * -10⁹ <= nums[i] <= 10⁹
 * -10⁹ <= target <= 10⁹
 * 只会存在一个有效答案
 * <p>
 * <p>
 * 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？
 * <p>
 * Related Topics 数组 哈希表 👍 15428 👎 0
 */

package cn.com.cedar.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length == 1) {
                return new int[]{-1, -1};
            }

            // current --> index
            Map<Integer, Integer> curIndexMap = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int another = target - nums[i];
                if (curIndexMap.containsKey(another)) {
                    return new int[]{curIndexMap.get(another), i};
                } else {
                    curIndexMap.put(nums[i], i);
                }
            }
            return new int[]{-1, -1};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}