package networking;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class client {

	public static void main(String[] args) throws IOException  {
		Socket s=null;
		try {
			s=new Socket("127.0.0.1",5056);
			DataInputStream dis=new DataInputStream(new BufferedInputStream(s.getInputStream()));
			DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(s.getOutputStream()));
			Scanner sc=new Scanner(System.in);
			
			String toRead="";
			int i=0;
			System.out.println(12000);
			while(!toRead.equals("QUIT")) {
				dos.writeUTF(sc.nextLine());
				dos.flush();
				if((toRead=dis.readUTF())!=null) {
					System.out.println(toRead);
				}
			}
			dis.close();
			dos.flush();
			dos.close();
			sc.close();
		} catch (IOException e) {
			System.out.println("Some exception occured.");
		}
		finally {
			s.close();
			System.out.println("Connection closed.");
			
		}
	}

}
