package sort;

public class BubbleSort extends Sorter {

	public BubbleSort(int[] data) {
		super(data);
	}

	@Override
	public void sort() {
		for (int j = numbers.length - 1; j >= 0; j--) {
			for (int i = 0; i < j; i++){
				if (numbers[i] > numbers[i+1]) {
					int tmp = numbers[i];
					numbers[i] = numbers[i+1];
					numbers[i+1] = tmp;
				}
			}
		}
	}

}
