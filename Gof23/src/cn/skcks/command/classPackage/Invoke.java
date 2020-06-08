package cn.skcks.command.classPackage;

import cn.skcks.command.interfacePackage.Command;

public class Invoke {
	// 可通过容器 容纳多条命令 批量执行
	private final Command command;

	public Invoke(Command command) {
		this.command = command;
	}

	// 业务方法,用于调用命令类的方法
	public void call(){
		command.execute();
	}
}
