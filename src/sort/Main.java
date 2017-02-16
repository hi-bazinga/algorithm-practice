package sort;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static int[] data;
	
	public static void main(String[] args) {
		loadData();
		Sorter sorter = new SelectionSort(data);
		sorter.execute();
		
	}
	
	private static void loadData(){
		List<Integer> numList = new ArrayList<Integer>();
		try {
			File f = new File("resources/numbers-100000.txt");
			BufferedReader reader = new BufferedReader(new FileReader(f));
			
			String str = null;
			while ((str = reader.readLine()) != null)
				numList.add(Integer.parseInt(str));
			reader.close();

			data = new int[numList.size()];
			for (int i = 0; i < numList.size(); i++)
				data[i] = numList.get(i);
		
		} catch (IOException e) {
			e.printStackTrace();
		} 
		System.out.println("Total numbers : " + data.length);
	}

}
