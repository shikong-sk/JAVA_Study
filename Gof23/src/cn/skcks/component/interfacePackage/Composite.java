package cn.skcks.component.interfacePackage;

/*
	容器组件
 */
public interface Composite extends Component{
	void add(Component component);
	void remove(Component component);
	Component getChild(int index);
}
