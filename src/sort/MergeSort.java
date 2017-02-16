package sort;

public class MergeSort extends Sorter {

	public MergeSort(int[] data) {
		super(data);
	}

	@Override
	public void sort() {
		processSort(numbers, 0, numbers.length);
	}

	private void processSort(int[] list, int begin, int end){
		if (end - begin <= 1)
			return ;
		
		int mid = (begin + end) / 2;
		processSort(list, begin, mid);
		processSort(list, mid, end);
		merge(list, begin, mid, end);
	}
	
	private void merge(int[] list, int begin, int mid, int end){
		int[] tmpList = new int[end-begin];
		
		int i = begin, j = mid;
		int itr = 0;
		while (i < mid && j < end) {
			if (list[i] <= list[j])
				tmpList[itr++] = list[i++];
			else
				tmpList[itr++] = list[j++];
		}
		
		while (i < mid) tmpList[itr++] = list[i++];
		while (j < end) tmpList[itr++] = list[j++];
		
		for (itr = 0; itr < tmpList.length; itr++){
			numbers[begin + itr] = tmpList[itr];
		}
	}
}
