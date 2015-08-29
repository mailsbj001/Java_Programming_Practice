package com.kashi.udacity.software.testing;

public class MergeSort {

	int[] array;

	MergeSort(int[] array) {
		this.array = array;
	}

	public void sort() {
		System.arraycopy(sort(array), 0, array, 0, array.length);
		return;
	}

	public int[] sort(int[] array) {
		int start = 0;
		int end = array.length - 1;
		if (start > end)
			return array;
		if (start == end)
			return array;
		if (start + 1 == end) {
			if (array[start] > array[end]) {
				int temp = array[start];
				array[start] = array[end];
				array[end] = temp;
				return array;
			}
		}

		int mid = (array.length-1) / 2;

		int[] array1 = new int[mid + 1];
		int len2 =array.length - array1.length;
		int[] array2 = new int[len2];
		System.arraycopy(array, start, array1, start, array1.length);
		System.arraycopy(array, mid + 1, array2, start, array2.length);
		
		
		array1 = sort(array1);
		array2 = sort(array2);
		array = merge(array1, array2);
		
		return array;
	}

	private int[] merge(int[] array1, int[] array2) {
		int[] array = new int[array1.length + array2.length];

		int i = 0, j = 0, k = 0;

		while ((i < array1.length) && (j < array2.length)) {
			if (array1[i] <= array2[j]) {// copy i increment i
				array[k] = array1[i];
				i++;
			} else {// copy j increment j
				array[k] = array2[j];
				j++;
			}
			// increment k
			k++;
		}
		
		if(i<array1.length){ // copy remaining elements in array1 to array
			while(i<array1.length){
				array[k++]= array1[i++];
			}
		}
		else if(j<array2.length){ // copy remaining elements in array2 to array
			while(j<array2.length){
				array[k++]=array2[j++];
			}
		}
		return array;
	}
}
