package cn.skcks.oop;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestFileTree {
	public static void main(String[] args) {
		fileTree(new File(System.getProperty("user.dir")));
	}
	
	public static void fileTree(File file) {
		fileTree(file, 0);
	}
	
	public static void fileTree(File file,int level) {
		for (int i = 0; i < level; i++) {
			System.out.print("-");
		}
		
		System.out.print(file.getName());
		
		if (file.isDirectory()) {
			System.out.println("\t 文件夹");
			File [] files = file.listFiles();
			
			for (File temp : files) {
				fileTree(temp,level+1);
			}
		}
		else {
			System.out.println("\t" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file.lastModified())) );
		}
		
	}
	
}
