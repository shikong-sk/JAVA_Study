package cn.skcks.orm.generatePackage;

import java.sql.*;
import java.util.*;

public class Ms_major {

	private String departmentName;
	private String majorId;
	private String departmentId;
	private Integer active;
	private String majorName;

	public String getDepartmentName(){
		return departmentName;
	}
	public String getMajorId(){
		return majorId;
	}
	public String getDepartmentId(){
		return departmentId;
	}
	public Integer getActive(){
		return active;
	}
	public String getMajorName(){
		return majorName;
	}
	public void setDepartmentName(String departmentName){
		this.departmentName = departmentName;
	}
	public void setMajorId(String majorId){
		this.majorId = majorId;
	}
	public void setDepartmentId(String departmentId){
		this.departmentId = departmentId;
	}
	public void setActive(Integer active){
		this.active = active;
	}
	public void setMajorName(String majorName){
		this.majorName = majorName;
	}
}
