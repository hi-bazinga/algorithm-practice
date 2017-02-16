package practice;

public class TwoSingleNumber {

	public static void main(String[] args) {
		int[] array = {1,4,7,32,45,7,45,1,233,32};
		
		TwoSingleNumber tsn = new TwoSingleNumber();
		int[] result = tsn.findTwoSingleNum(array);
		
		System.out.println(result[0] + " " + result[1]);
	}
	
	public int[] findTwoSingleNum(int[] array){
		int xorResult = array[0];
		for (int i = 1; i < array.length; i++) {
			xorResult ^= array[i];
		}
		
		System.out.println("XOR result is " + Integer.toBinaryString(xorResult));
		
		int compareNum = getLastDecimalNum(xorResult);
		Integer num1 = null, num2 = null;
		for (int i = 0; i < array.length; i++) {
			if ((array[i] & compareNum) == compareNum){
				if (num1 == null)
					num1 = array[i];
				else 
					num1 ^= array[i];
			} else {
				if (num2 == null)
					num2 = array[i];
				else 
					num2 ^= array[i];
			}
		}
		
		int[] result = new int[2];
		result[0] = num1;
		result[1] = num2;
		return result;
	}
	
	/**
	 * Get the last '1' in binary format and return the decimal number represented by it
	 */
	public int getLastDecimalNum(int number){
		int value = 1;
		while (number % 2 == 0){
			number >>= 1;
			value *= 2;
		}
		return value;
	}

}
