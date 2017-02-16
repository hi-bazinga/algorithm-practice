package sort;

public class QuickSort extends Sorter {

	public QuickSort(int[] data) {
		super(data);
	}

	@Override
	public void sort() {
		processSort(numbers, 0, numbers.length);
	}
	
	private void processSort(int[] list, int begin, int end){
		if (end - begin <= 1)
			return;
	
		int pivotPos = begin;		// select the first number in list as pivot
		int itr = begin;
		int pivot = list[pivotPos];		
		
		while(++itr < end){
			if (list[itr] < pivot){
				pivotPos++;
				swap(list, itr, pivotPos);
			}
		}
		swap(list, begin, pivotPos);
		
		processSort(list, begin, pivotPos);
		processSort(list, pivotPos+1, end);
		
	}

	private void swap(int[] list, int a, int b){
		int tmp = list[a];
		list[a] = list[b];
		list[b] = tmp;
	}
	
}
