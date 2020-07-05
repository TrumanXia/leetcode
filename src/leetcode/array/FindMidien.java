package leetcode.array;

import leetcode.backtrace.FindPath;

public class FindMidien {

    public static void main(String[] args) {
        System.out.println(new FindMidien().findMedianSortedArrays(new int[]{1, 2}, new int[]{3,4}));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int total = nums1.length + nums2.length;

        if (total % 2 == 1) {
            // 从0 开始的索引，需要 + 1， 表示位数
            return findKthElement(nums1, nums2, total / 2 + 1);
        } else {
            return (findKthElement(nums1, nums2, total / 2) + findKthElement(nums1, nums2, total / 2 + 1)) / 2.0;
        }

    }

    private int findKthElement(int[] nums1, int[] nums2, int k) {

        int index1 = 0, index2 = 0;
        int length1 = nums1.length, length2 = nums2.length;
        while (true) {
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1,
                newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 < pivot2) {
                // 更新k 计算很重要，更新几个数
                k -= newIndex1 - index1 + 1;
                index1 = newIndex1 + 1;
            } else {
                k -= newIndex2 - index2 + 1;
                index2 = newIndex2 + 1;
            }
        }

    }


}
