package divide_and_conquer;

import java.math.BigInteger;

public class power {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(power(10,2));

	}
	public static BigInteger power(int x,int y) {
		if(y==0) {
			return new BigInteger("1");
		}
		BigInteger temp=power(x,y/2);
		if(y%2==0) {
			return temp.multiply(temp);
		}
		return new BigInteger(Integer.toString(x)).multiply(temp.multiply(temp));
	}
}
