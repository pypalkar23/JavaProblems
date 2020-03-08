/*42. Trapping Rain Water*/
package leetcode;

import java.util.Stack;

class TrappingRainWater {

   public static void main(String[] args) {
      TrappingRainWater t = new TrappingRainWater();
      int rainwater[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
      System.out.println(t.trap2(rainwater));
   }

   // DP
   public int trap(int[] height) {
      if (height == null)
         return 0;
      int ans = 0;
      int len = height.length;
      int left_max[] = new int[len];
      int right_max[] = new int[len];

      left_max[0] = height[0];
      for (int i = 1; i <= len - 1; i++) {
         left_max[i] = Math.max(height[i], left_max[i - 1]);
      }

      right_max[len - 1] = height[len - 1];
      for (int i = len - 2; i >= 0; i--) {
         right_max[i] = Math.max(height[i], right_max[i + 1]);
      }

      for (int i = 1; i < len - 1; i++) {
         ans += Math.min(left_max[i], right_max[i]) - height[i];
      }

      return ans;
   }

   public int trap1(int[] height) {
      // Stack
      if (height == null)
         return 0;
      int len = height.length;
      int current = 0;
      int ans = 0;
      Stack<Integer> stack = new Stack<Integer>();
      while (current < len) {
         while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
            int top = stack.pop();
            if (stack.isEmpty())
               break;
            int distance = current - stack.peek() - 1;
            int boundedHeight = Math.min(height[current], height[stack.peek()]) - height[top];
            ans += distance * boundedHeight;
         }
         stack.push(current++);
      }
      return ans;
   }

   public int trap2(int[] height) {
      if (height == null) {
         return 0;
      }

      int left = 0, right = height.length - 1, ans = 0;
      int left_max = 0, right_max = 0;
      while (left < right) {
         if (height[left] < height[right]) {
            if (height[left] >= left_max)
               left_max = height[left];
            else
               ans += left_max - height[left];
            left++;
         } else {
            if (height[right] >= right_max)
               right_max = height[right];
            else
               ans += right_max - height[right];
            right--;
         }
      }
      return ans;
   }
}