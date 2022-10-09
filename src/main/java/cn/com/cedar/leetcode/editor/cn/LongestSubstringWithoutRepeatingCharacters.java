/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= s.length <= 5 * 10⁴
 * s 由英文字母、数字、符号和空格组成
 * <p>
 * <p>
 * Related Topics 哈希表 字符串 滑动窗口 👍 8209 👎 0
 */

package cn.com.cedar.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            // 滑动窗口 char --> index
            Map<Character, Integer> charIndexMap = new HashMap<>(s.length());
            int left = 0;
            // 最大的结果
            int max = 0;

            for (int right = 0; right < s.length(); right++) {
                if (charIndexMap.containsKey(s.charAt(right))) {
                    left = Math.max(left, charIndexMap.get(s.charAt(right)) + 1);
                }
                // 覆盖原来的值
                charIndexMap.put(s.charAt(right), right);
                max = Math.max(max, right - left + 1);
            }
            return max;
        }
    }

    class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            Set<Character> set = new HashSet<>(s.length());
            int rightPoint = -1;
            int ans = 0;
            for (int leftPoint = 0; leftPoint < s.length(); leftPoint++) {
                if (leftPoint != 0) {
                    set.remove(s.charAt(leftPoint - 1));
                }
                while (rightPoint + 1 < s.length() && !set.contains(s.charAt(rightPoint + 1))) {
                    set.add(s.charAt(rightPoint + 1));
                    rightPoint++;
                }
                ans = Math.max(ans, rightPoint - leftPoint + 1);
            }
            return ans;
        }
    }

    class Solution3 {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            Set<Character> set = new HashSet<>(s.length());

            int left = 0;
            int right = 0;
            int ans = 0;

            for (; right < s.length(); right++) {
                char ch = s.charAt(right);
                while (set.contains(ch)) {
                    set.remove(s.charAt(left));
                    left++;
                }

                set.add(ch);
                ans = Math.max(ans, right - left + 1);
            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}