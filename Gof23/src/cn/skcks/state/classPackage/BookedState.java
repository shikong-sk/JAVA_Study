package cn.skcks.state.classPackage;

import cn.skcks.state.interfacePackage.State;

public class BookedState implements State {
	@Override
	public void handle() {
		System.out.println("已被预定");
	}
}
