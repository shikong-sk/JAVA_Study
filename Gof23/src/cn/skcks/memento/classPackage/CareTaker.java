package cn.skcks.memento.classPackage;

/*
	负责人类
	管理备忘录对象
 */
public class CareTaker {

	// 替换为列表/堆栈 则可保存多个备忘点
	private EmpMemento empMemento;

	public EmpMemento getEmpMemento() {
		return empMemento;
	}

	public void setEmpMemento(EmpMemento empMemento) {
		this.empMemento = empMemento;
	}
}
