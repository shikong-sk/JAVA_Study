package cn.skcks.oop;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestException {
	public static void main(String[] args) {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("E:\\#Java\\test.txt");
			
			char c = (char)fileReader.read();
			System.out.println(c);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(fileReader != null)
				{
					fileReader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
