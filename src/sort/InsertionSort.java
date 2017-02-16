package sort;

public class InsertionSort extends Sorter {

	public InsertionSort(int[] data) {
		super(data);
	}

	@Override
	public void sort() {
		for (int i = 1; i < numbers.length; i++){
			int j = i - 1;
			int insertNum = numbers[i];
			
			while (j >= 0 && insertNum < numbers[j]) {
				numbers[j + 1] = numbers[j];
				j--;
			}
			numbers[j + 1] = insertNum;
		}
	}

}
