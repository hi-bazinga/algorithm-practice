package practice;

import java.math.BigInteger;


public class MyBigInteger {

	public static void main(String[] args) {
		int[] a = {9,9,9,9,9,9,4,5,6,2,2};
		int[] b = 			  {8,5,1,6,9};
		
		MyBigInteger bi = new MyBigInteger();
		int[] result = bi.add(a, b);
		bi.showResult(result);
	}
	
	public int[] add(int[] x, int[] y) {
		// ensure that x is the longer number
		if (x.length < y.length) {
			int[] tmp = x;
			x = y;
			y = tmp;
		}
		
		int[] result = new int[x.length];
		int xIndex = x.length;
		int yIndex = y.length;
		int carry = 0;
		
		while (xIndex > 0) {
			int yDigit = yIndex > 0 ? y[--yIndex] : 0;
			int tmpSum = x[--xIndex] + yDigit + carry;
			result[xIndex] = tmpSum % 10;
			carry  = tmpSum / 10;
		}
		
		if (carry > 0) {
			int bigger[] = new int[result.length + 1];
			System.arraycopy(result, 0, bigger, 1, result.length);
	        bigger[0] = 0x01;
	        return bigger;
		}
		return result;
	}

	public int[] subtract(int[] big, int[] little){
		BigInteger bb;
		
		return null;
	}
	
	public void showResult(int[] result) {
		for (int a : result)
			System.out.print(a);
	}
	
}
