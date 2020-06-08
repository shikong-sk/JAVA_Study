package cn.skcks.command;

import cn.skcks.command.classPackage.ConcreteCommand;
import cn.skcks.command.classPackage.Invoke;
import cn.skcks.command.classPackage.Receiver;
import cn.skcks.command.interfacePackage.Command;

public class Test {
	public static void main(String[] args) {
		// 命令模式调用
		Command command = new ConcreteCommand(new Receiver());
		Invoke invoke = new Invoke(command);
		invoke.call();

		// 直接调用
		new Receiver().action();
	}
}
