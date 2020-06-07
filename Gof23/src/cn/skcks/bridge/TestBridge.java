package cn.skcks.bridge;

import cn.skcks.bridge.classPackage.Computer;
import cn.skcks.bridge.classPackage.Dell;
import cn.skcks.bridge.classPackage.Hasee;
import cn.skcks.bridge.classPackage.Lenovo;
import cn.skcks.bridge.classPackage.category.DesktopBridge;
import cn.skcks.bridge.classPackage.category.LaptopBridge;
import cn.skcks.bridge.classPackage.category.PadBridge;
import cn.skcks.bridge.interfacePackage.Brand;

public class TestBridge {
	public static void main(String[] args) {
		// 销售戴尔笔记本
		Computer dellLaptop = new LaptopBridge(new Dell());
		dellLaptop.sale();

		// 销售神舟台式机
		Computer haseeDesktop = new DesktopBridge(new Hasee());
		haseeDesktop.sale();

		// 销售联想平板
		Computer lenovoPad = new PadBridge(new Lenovo());
		lenovoPad.sale();
	}
}
