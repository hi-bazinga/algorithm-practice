package sort;

public class ShellSort extends Sorter {

	public ShellSort(int[] data) {
		super(data);
	}

	@Override
	public void sort() {
		int dis = numbers.length / 2;
		while (dis >= 1) {
			shellSort(numbers, dis);
			dis = dis / 2;
		}
	}
	
	private void shellSort(int[] numbers, int dis) {
		for (int i = dis; i < numbers.length; i++) {
			int insertNum = numbers[i];
			int j = i - dis;
			
			while (j >= 0 && insertNum < numbers[j]) {
				numbers[j + dis] = numbers[j];
				j -= dis;
			}
			numbers[j + dis] = insertNum;
		}
	}

}
