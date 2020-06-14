package cn.skcks.orm.generatePackage;

import java.sql.*;
import java.util.*;

public class Ms_course {

	private String courseName;
	private String classId;
	private String teacherId;
	private String teacherName;
	private Integer _Public;
	private java.sql.Date startTime;
	private java.sql.Date endTime;
	private String courseId;

	public String getCourseName(){
		return courseName;
	}
	public String getClassId(){
		return classId;
	}
	public String getTeacherId(){
		return teacherId;
	}
	public String getTeacherName(){
		return teacherName;
	}
	public Integer get_Public(){
		return _Public;
	}
	public java.sql.Date getStartTime(){
		return startTime;
	}
	public java.sql.Date getEndTime(){
		return endTime;
	}
	public String getCourseId(){
		return courseId;
	}
	public void setCourseName(String courseName){
		this.courseName = courseName;
	}
	public void setClassId(String classId){
		this.classId = classId;
	}
	public void setTeacherId(String teacherId){
		this.teacherId = teacherId;
	}
	public void setTeacherName(String teacherName){
		this.teacherName = teacherName;
	}
	public void set_Public(Integer _Public){
		this._Public = _Public;
	}
	public void setStartTime(java.sql.Date startTime){
		this.startTime = startTime;
	}
	public void setEndTime(java.sql.Date endTime){
		this.endTime = endTime;
	}
	public void setCourseId(String courseId){
		this.courseId = courseId;
	}
}
