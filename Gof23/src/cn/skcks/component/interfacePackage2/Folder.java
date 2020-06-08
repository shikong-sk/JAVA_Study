package cn.skcks.component.interfacePackage2;


import java.util.ArrayList;
import java.util.List;

public class Folder implements AbstractFile{
	private final String name;
	// 定义容器,用于存放容器下的子节点
	private List<AbstractFile> fileList = new ArrayList<>();

	public Folder(String name) {
		this.name = name;
	}

	public void add(AbstractFile file){
		fileList.add(file);
	}

	public void remove(AbstractFile file){
		fileList.remove(file);
	}

	public AbstractFile getChild(int index){
		return fileList.get(index);
	}

	@Override
	public void killVirus() {
		System.out.println("查杀 Folder：" + name);

		for (AbstractFile file : fileList)
		{
			System.out.print("\t");
			file.killVirus();
		}
	}
}
