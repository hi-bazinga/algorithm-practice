package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindBiggestSquare {
	
	public static void main(String[] args){
		Scanner sc = null;
		try {
			sc = new Scanner(new File("metric.txt"));
			while (sc.hasNext())
				System.out.println(sc.next());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}
 	
}
