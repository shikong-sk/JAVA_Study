package cn.skcks.oop;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestFile {
	public static void main(String[] args) throws IOException{
		File f = new File("test.txt");
		
		System.out.println(f);
		
		if(!f.exists()) {
			f.createNewFile();
		}
		
		File f2 = new File("test");
		
		if(f2.exists()) {
			f.delete();
		}
		else {
			f.renameTo(new File("test"));
		}
		
		System.out.println(System.getProperty("user.dir"));
		
		System.out.println(f2.isDirectory());
		System.out.println(f2.isFile());
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(f2.lastModified())));
		// 获取文件修改时间
		
		System.out.println(f2.getName()); // 获取文件名
		
		System.out.println(new File("E:\\$Adobe全家桶\\CC 2020\\Adobe_2020_MasterCol_win_v10.6#1_20200405\\Adobe_2020_MasterCol_win_v10.6#1_20200405.iso").length()); // 获取文件大小
		
		System.out.println(getSize(new File("E:\\$Adobe全家桶\\CC 2020\\Adobe_2020_MasterCol_win_v10.6#1_20200405\\Adobe_2020_MasterCol_win_v10.6#1_20200405.iso").length()));
		
		System.out.println(f2.getPath()); // 获取文件路径
		
		System.out.println(f2.getAbsolutePath()); // 获取文件绝对路径
		
	}
	
	public static String getSize(double Bytes) {
		String sizeString;
		
		int unit = 0;

		String units = "BKMGT";
		
		while(Bytes >= 1024) {
			Bytes /= 1024;
			unit += 1;
		}
		
		sizeString = String.format("%.1f", new Double(Bytes)) + units.charAt(unit);
		
		return sizeString;
		
	}
}

