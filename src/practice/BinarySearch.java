package practice;

/**
 * 二分查找及其变种
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 8, 9, 9};
        int index = search(nums, 4);
        System.out.println("index: " + index);

        int[] nums1 = {1, 2, 4, 4, 4, 4, 8, 8, 9, 9};
        System.out.println("first -> equal: " + searchFirstEqual(nums1, 9));
        System.out.println("last -> equal: " + searchLastEqual(nums1, 4));
        System.out.println("last -> equal or less than: " + searchLastEqualOrLessThan(nums1, 5));
        System.out.println("last -> less than: " + searchLastLessThan(nums1, 5));
        System.out.println("first -> equal or greater than: " + searchFirstEqualOrGreaterThan(nums1, 5));
        System.out.println("first -> greater than: " + searchFirstGreaterThan(nums1, 5));
    }

    /**
     * 0. 普通二分查找
     */
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 1. 数组可能有重复值，查找第一个与target相等的元素
     */
    public static int searchFirstEqual(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // 如果nums为空，left为0会出错
        if (left < nums.length && nums[left] == target) {
            return left;
        }

        return -1;
    }

    /**
     * 2. 数组可能有重复值，查找最后一个与target相等的元素
     */
    public static int searchLastEqual(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // 如果nums为空，right为-1会出错
        if (right >= 0 && nums[right] == target) {
            return right;
        }

        return -1;
    }

    /**
     * 3. 查找最后一个等于或者小于target的元素
     */
    public static int searchLastEqualOrLessThan(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    /**
     * 3. 查找最后小于target的元素
     */
    public static int searchLastLessThan(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    /**
     * 4. 查找第一个等于或者大于key的元素
     */
    public static int searchFirstEqualOrGreaterThan(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     * 5. 查找第一个大于key的元素
     */
    public static int searchFirstGreaterThan(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

}
