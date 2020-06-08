package cn.skcks.component;

import cn.skcks.component.interfacePackage2.*;

/*
	组合模式
 */
public class TestComponent {
	public static void main(String[] args) {
		Folder folder1,folder2;
		AbstractFile file1,file2,file3,file4;
		folder1 = new Folder("计算机");
		file1 = new ImageFile("图片.jpg");
		file2 = new TextFile("HelloWorld.txt");

		folder1.add(file1);
		folder1.add(file2);

		file2.killVirus();

		folder1.killVirus();


		folder2 = new Folder("收藏");
		file3 = new VideoFile("复联3.avi");
		file4 = new VideoFile("父愁者4.mp4");
		folder2.add(file3);
		folder2.add(file4);

		folder1.add(folder2);

		folder1.killVirus();
	}
}
