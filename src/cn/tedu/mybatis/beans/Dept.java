package cn.tedu.mybatis.beans;

import java.util.List;

public class Dept {
	private int id;
	private String name;
	private List<Emp> empList;
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
	public List<Emp> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}
	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + ", empList=" + empList
				+ "]";
	}
	
	
}
