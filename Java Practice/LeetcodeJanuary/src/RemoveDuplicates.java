public class RemoveDuplicates {

    public static int removeDups(int[] nums){
        int fwdPtr = 0;
        int bckPtr = 0;
        int length = nums.length;

        while(fwdPtr < length){
            if(nums[fwdPtr] == nums[bckPtr]) {
                fwdPtr++;
            }else{
                nums[bckPtr + 1] = nums[fwdPtr];
                bckPtr++;
                fwdPtr++;
            }
        }

        return bckPtr +1;
    }

    public static void main(String[] args) {
        int nums[] = {0,0,1,1,1,2,2,3,5,6,6,8};
        System.out.println(removeDups(nums));
    }

}
