package cn.skcks.proxy;

import cn.skcks.proxy.classPackage.ProxyStar;
import cn.skcks.proxy.classPackage.RealStar;
import cn.skcks.proxy.interfacePackage.Star;

/*
	代理模式
 */
public class TestProxy {
	public static void main(String[] args) {
		// 真实角色
		Star realStar = new RealStar();
		// 代理角色
		Star proxyStar = new ProxyStar(realStar);

		proxyStar.confer();
		proxyStar.signContract();
		proxyStar.bookTicket();
		proxyStar.sing();
		proxyStar.collectMoney();
	}
}
