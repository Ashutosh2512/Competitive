package Streams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class file_writing {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f=new File("/home/ashutosh/Desktop/input.txt");
		BufferedReader fr=new BufferedReader(new FileReader("/home/ashutosh/Desktop/output.txt"));
		FileWriter fw=new FileWriter(f);
		String str;
		while((str=fr.readLine())!=null) {
			System.out.print(str+" ");
			fw.write(str);
		}
		fw.flush();
		fw.close();
		fr.close();
	}

}
