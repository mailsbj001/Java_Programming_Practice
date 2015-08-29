package com.kashi.udacity.software.testing;

public class QuickSort {

	int[] array;

	QuickSort(int[] array) {
		this.array = array;
	}

	public void sort() {
		sort(0, array.length - 1);
	}

	private void sort(int start, int end) {

		if (start > end)
			return;

		if (start == end)
			return;

		int pivot = array[start];

		// index = find right place for pivot
		int index = findIndex(pivot, start, end);
		// swap pivot with index
		array[start] = array[index];
		array[index] = pivot;
		// sort(start,index-1);
		sort(start, index - 1);
		// sort(index+1,end)
		sort(index + 1, end);
		return;
	}

	// index of pivot is always 0
	// start - start index of array
	// end = end index of array
	private int findIndex(int pivot, int start, int end) {
		int i = start + 1;
		int j = end;
		while (true) {
			while ((i <= end) && (array[i] < pivot))
				i++;
			while ((j >= start) && (array[j] > pivot))
				j--;
			if (i < j) {// swap array[i],array[j]
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			} else
				break;
		}
		return j;
	}

}
