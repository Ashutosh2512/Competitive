package comp_important;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PrimeFactors {
	static ArrayList<Long> list;;
	public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br =  
              new BufferedReader(new InputStreamReader(System.in));

        int t=0;
        int l=0;
        t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++) {
        	StringTokenizer st=new StringTokenizer(br.readLine());
        	long x=Long.parseLong(st.nextToken());
        	long y=Long.parseLong(st.nextToken());
        	list=factorize(x-y);
        	l=list.size();
        	if(l>0) {
        		System.out.println("YES");
        	}else {
        		System.out.println("NO");
        	}
        }
    }
	static ArrayList<Long> factorize(long n) { 
        int count = 0; 
        ArrayList<Long> list=new ArrayList<Long>();
        // count the number of times 2 divides  
        while (!(n % 2 > 0)) { 
            // equivalent to n=n/2;  
            n >>= 1; 
  
            count++; 
        } 
  
        // if 2 divides it  
        if (count > 0) { 
            list.add((long)2); 
        } 
  
        // check for all the possible  
        // numbers that can divide it  
        for (long i = 3; i <= (long) Math.sqrt(n); i += 2) { 
            count = 0; 
            while (n % i == 0) { 
                count++; 
                n = n / i; 
            } 
            if (count > 0) { 
                list.add(i); 
            } 
        } 
  
        // if n at the end is a prime number.  
        if (n > 2) { 
            list.add(n); 
        } 
        return list;
    } 
}
