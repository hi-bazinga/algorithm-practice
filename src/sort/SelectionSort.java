package sort;

public class SelectionSort extends Sorter {

	public SelectionSort(int[] data) {
		super(data);
	}

	@Override
	public void sort() {
		for (int i = 0; i < numbers.length; i ++) {
			int minIndex = i;
			for (int j = i + 1; j < numbers.length; j ++) {
				if (numbers[j] < numbers[minIndex])
					minIndex = j;
			}
			int tmp = numbers[i];
			numbers[i] = numbers[minIndex];
			numbers[minIndex] = tmp;
		}
	}
}
