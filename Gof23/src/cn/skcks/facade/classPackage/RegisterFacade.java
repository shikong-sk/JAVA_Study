package cn.skcks.facade.classPackage;

/*
	门面对象
 */
public class RegisterFacade {
	public void register(){
		new 工商局().checkName();
		new 质检局().orgCodeCertificate();
		new 税务局().taxCertificate();
		new 银行().openAccount();
	}
}
