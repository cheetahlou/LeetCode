import java.util.Objects;

/**
 * @author
 * @createTime 2019/4/9 23:04
 * @remark 结果有多种不同组合 先排序
 * @description
 Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:

 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int idx1 = -1, idx2 = -1;
        if (Objects.isNull(nums) || 0 == nums.length) {
            return new int[]{idx1, idx2};
        }

        int tempSubVal = 0;

        for (int i = 0; i < nums.length; i++) {
            tempSubVal = target - nums[i]; //subtract

            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[j] == tempSubVal) {
                    return new int[]{i, j};
                }
            }

        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int target = 9;
        int[] ret = twoSum(arr, target);

        String out = integerArrayToString(ret);

        System.out.print(out);
    }




    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }
}
