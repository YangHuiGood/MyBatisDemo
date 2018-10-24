package cn.tedu.mybatis.beans;

import java.util.List;

public class Teacher {
	private int id;
	private String name;
	private List<Stu> stuList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Stu> getStuList() {
		return stuList;
	}
	public void setStuList(List<Stu> stuList) {
		this.stuList = stuList;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", stuList=" + stuList
				+ "]";
	}
	
}
