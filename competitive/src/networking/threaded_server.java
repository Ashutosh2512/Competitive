package networking;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class threaded_server {
	private static final int PORT_NUM=5056;
	static List<Socket> SocketList=new ArrayList<Socket>();
	//this runs the program
	public static void main(String[] args)  {
		ServerSocket listener=null;
		
		try {
			listener=new ServerSocket(PORT_NUM);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//this is to insure that the server has started. Can be commented out later.
		System.out.println("Server Started.");
		Socket socket=null;
		while(true) {
			 try {
				 //accepts the 
				socket=listener.accept();
				System.out.println("a new connection is established on port "+socket.getPort());
				new client_handler(socket).start();;
			} catch (IOException e) {
				System.out.println("can not add a new client");
				e.printStackTrace();
			}
		}
	}
}
class client_handler extends Thread{
	DataInputStream dis;
	DataOutputStream dos;
	Socket socket;
	public client_handler(Socket socket) {
		this.socket=socket;
		try {
			this.dis=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			this.dos=new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
		} catch (IOException e) {
			System.out.println("problem occurred while creating tunnel.");
			e.printStackTrace();
		}
	}
	@Override
	public synchronized void run(){
		
		Scanner sc=new Scanner(System.in);
		try {
			String toRead=null;
			toRead=dis.readUTF();
			while(!toRead.equals("QUIT")) {
				if(toRead!=null) {
					System.out.println(toRead);
				}
				dos.writeUTF(sc.nextLine());
				dos.flush();
				toRead=dis.readUTF();
			}
			dis.close();
			dos.close();
			sc.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Connection closed.");
		} 
	}
}
