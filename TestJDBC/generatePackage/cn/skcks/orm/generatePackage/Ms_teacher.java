package cn.skcks.orm.generatePackage;

import java.sql.*;
import java.util.*;

public class Ms_teacher {

	private String departmentName;
	private String salt;
	private String address;
	private String teacherName;
	private String gender;
	private String idCard;
	private String departmentId;
	private Integer active;
	private String permission;
	private java.sql.Date both;
	private String password;
	private String teacherId;
	private String contact;
	private String email;
	private String teacherImg;

	public String getDepartmentName(){
		return departmentName;
	}
	public String getSalt(){
		return salt;
	}
	public String getAddress(){
		return address;
	}
	public String getTeacherName(){
		return teacherName;
	}
	public String getGender(){
		return gender;
	}
	public String getIdCard(){
		return idCard;
	}
	public String getDepartmentId(){
		return departmentId;
	}
	public Integer getActive(){
		return active;
	}
	public String getPermission(){
		return permission;
	}
	public java.sql.Date getBoth(){
		return both;
	}
	public String getPassword(){
		return password;
	}
	public String getTeacherId(){
		return teacherId;
	}
	public String getContact(){
		return contact;
	}
	public String getEmail(){
		return email;
	}
	public String getTeacherImg(){
		return teacherImg;
	}
	public void setDepartmentName(String departmentName){
		this.departmentName = departmentName;
	}
	public void setSalt(String salt){
		this.salt = salt;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public void setTeacherName(String teacherName){
		this.teacherName = teacherName;
	}
	public void setGender(String gender){
		this.gender = gender;
	}
	public void setIdCard(String idCard){
		this.idCard = idCard;
	}
	public void setDepartmentId(String departmentId){
		this.departmentId = departmentId;
	}
	public void setActive(Integer active){
		this.active = active;
	}
	public void setPermission(String permission){
		this.permission = permission;
	}
	public void setBoth(java.sql.Date both){
		this.both = both;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public void setTeacherId(String teacherId){
		this.teacherId = teacherId;
	}
	public void setContact(String contact){
		this.contact = contact;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public void setTeacherImg(String teacherImg){
		this.teacherImg = teacherImg;
	}
}
