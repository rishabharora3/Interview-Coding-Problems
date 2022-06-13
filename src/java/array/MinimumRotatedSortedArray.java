package java.array;

public class MinimumRotatedSortedArray {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length -1;
        while (start < end){
            int mid = (start+end)/2;
            if(mid> 0 && nums[mid]<nums[mid-1])
                return nums[mid];
            if(nums[mid] >= nums[start] && nums[mid] > nums[end]){
                start = mid +1;
            }else{
                end = mid - 1;
            }
        }
        return nums[start];
    }
}
