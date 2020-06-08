package cn.skcks.state;

import cn.skcks.state.classPackage.BookedState;
import cn.skcks.state.classPackage.Context;
import cn.skcks.state.classPackage.FreeState;
import cn.skcks.state.classPackage.UsedState;

/*
	状态模式
 */
public class TestState {
	public static void main(String[] args) {
		Context context = new Context();

		// 修改状态 并执行相应的方法
		context.setState(new FreeState());
		context.setState(new BookedState());
		context.setState(new UsedState());
	}
}
