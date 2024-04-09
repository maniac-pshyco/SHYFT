
public class Solution {
    //Brute Force: Traversing array every index till we reach -1; Time: O(n);
    public static int search1(int[] arr){
        if (arr[0] == -1) return 0;
        int result = 0;
        while(arr[result] != -1) result++;

        return result - 1;
    }

    //Modified Binary Search: Doubling the index till we reach -1 then taking this index and last index as high and low values ; Time O(log n);
    public static int search2(int[] arr){
        if(arr[0] == -1) return 0;
        int index = 1;
        
        //Because array length is infinite , we can neglect the first condition
        while(index < arr.length && arr[index] != -1){
            index = index * 2;
        }

        int low = index / 2, high = Math.min(index, arr.length - 1);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < 0) high = mid - 1;
             else low = mid + 1;

        }


        return low;
    }
    public static void main(String[] args)
    {
        // int[] arr = new int[];
        int[] arr1 = {3, 4, 1, 2, 7, 8, 20, 33, -1, -1, -1, -1};
        int[] arr2 = {-1, -1, -1, -1};


        System.out.println(search2(arr1)); 

        System.out.println(search2(arr2));  

    }
}