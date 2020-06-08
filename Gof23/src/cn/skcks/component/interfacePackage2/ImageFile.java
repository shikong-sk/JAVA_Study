package cn.skcks.component.interfacePackage2;

public class ImageFile implements AbstractFile{
	private final String name;

	public ImageFile(String name) {
		this.name = name;
	}

	@Override
	public void killVirus() {
		System.out.println("查杀 ImageFile：" + name);
	}
}
