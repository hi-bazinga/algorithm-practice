package sort;


public abstract class Sorter {
	protected int[] numbers;
	
	public Sorter(int[] data){
		numbers = data;
	}
	
	public abstract void sort();
	
	public void execute(){
		long startTime = 0, endTime = 0;
		
		startTime = System.currentTimeMillis();
		sort();
		endTime = System.currentTimeMillis();
		
		for (int num : numbers)
			System.out.println(num);
		System.out.printf("%s Finished! time used: %d ms", getClass().getSimpleName(), endTime - startTime);
	}
}
