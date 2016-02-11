/**
 * 
 */
/**
 * @author labuser
 *
 */

package sorting;

import java.util.*;


class mergeSort {
	public static int merge(int arr[], int temp[], int left,int mid, int right) {
			
		int i,j,k,inv_count=0;
		i = left;
		j=mid;
		k=left;
		
		while(i <= mid-1 && j <= right) {
			if (arr[i] < arr[j]){
				temp[k++] = arr[i++];				
			} else {
				temp[k++] = arr[j++];
				inv_count = inv_count + mid-i;
			}
		}
		
		while(i<=mid-1) {
			temp[k++] = arr[i++];
		}
		while(j <= right){
			temp[k++] = arr[j++];
		}	
		for (i=left;i<=right;i++)
			arr[i] = temp[i];
		
		return inv_count;
		
	}
	public static int mergeSortMain(int arr[], int temp[],int left,int right) {
		int mid, inv_count=0;
		if (left < right) {
			mid = (left + right)/2;
		inv_count = mergeSortMain(arr,temp,left,mid);
		inv_count += mergeSortMain(arr,temp,mid+1, right);
		
		inv_count += merge(arr,temp,left,mid+1,right);
		}
		return inv_count;
	}
	public static void  main(String args[]) {
		int arr[] = {1,20,6,4,5};
		int temp[] = {0,0,0,0,0};
		int inv = mergeSortMain(arr,temp,0,arr.length-1);
		 System.out.println("No of Inversions are"+ inv);
		
	}
}

