package cn.skcks.component.interfacePackage2;

public class VideoFile implements AbstractFile{
	private final String name;

	public VideoFile(String name) {
		this.name = name;
	}

	@Override
	public void killVirus() {
		System.out.println("查杀 VideoFile：" + name);
	}
}
