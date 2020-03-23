import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
 
public class test {
 
	
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		A a=new A();
		T t1=new T(a);
		T t2=new T(a);
		t1.start();
		t2.start();
	}
}
class A{
	public synchronized void method1() {
		System.out.println("method1");
	}
	public synchronized void method2() {
		System.out.println("method2");
	}	
}

class T extends Thread{
	A a;
	public T(A s) {
		this.a=s;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			a.method1();
			try {
				this.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			a.method2();
		}
	}
}