Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

Notice that you may not slant the container.
  Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
Example 3:

Input: height = [4,3,2,1,4]
Output: 16
Example 4:

Input: height = [1,2,1]
Output: 2
  
  A simple brute force algorithm is what you can start with.

public int maxArea(int[] height) {
	int max = 0;
	int l = height.length;
	
	for (int i=0; i<l; i++) {
		for (int j=i+1; j<l; j++) {
			int area = (j-i) * Math.min(height[i], height[j]);
			if (area > max) {
				max = area;
			}
		}
	}
	
	return max;
}

Algorithm-2
Lets think of optimizing this computation. What if we start with max range, and move either left or right. Since, lower height determines the area. And, we can move greedily towards point with high height. And, compare the area.

We can start with left and right pointer, calculate area. Then we can move towards point with higher height. i.e. the side which is having less height, we should move that pointer. Example: If left pointer value is less, move it right. Similarly, if right pointer value is less than right, move it left.

public int maxArea(int[] height) {
	int l = height.length;
	int result = 0;
	int i=0;
	int j = l-1;

	while (i < j) {
		int area = (j-i) * Math.min(height[i], height[j]);
		if (result < area) {
			result = area;
		}

		if (height[i] < height[j]) {
			i++;
		}
		else j--;
	}

	return result;
}
