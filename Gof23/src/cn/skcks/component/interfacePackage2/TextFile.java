package cn.skcks.component.interfacePackage2;

public class TextFile implements AbstractFile{
	private final String name;

	public TextFile(String name) {
		this.name = name;
	}

	@Override
	public void killVirus() {
		System.out.println("查杀 TextFile：" + name);
	}
}
