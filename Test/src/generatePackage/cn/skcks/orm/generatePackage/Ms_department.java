package cn.skcks.orm.generatePackage;

import java.sql.*;
import java.util.*;

public class Ms_department {

	private String departmentName;
	private String departmentId;
	private Integer active;

	public String getDepartmentName(){
		return departmentName;
	}
	public String getDepartmentId(){
		return departmentId;
	}
	public Integer getActive(){
		return active;
	}
	public void setDepartmentName(String departmentName){
		this.departmentName = departmentName;
	}
	public void setDepartmentId(String departmentId){
		this.departmentId = departmentId;
	}
	public void setActive(Integer active){
		this.active = active;
	}
}
