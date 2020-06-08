package cn.skcks.command.classPackage;

import cn.skcks.command.interfacePackage.Command;

public class ConcreteCommand implements Command {
	private final Receiver receiver;

	public ConcreteCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		// 命令真正之前前后 进行相关处理
		receiver.action();
	}
}
