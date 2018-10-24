package cn.tedu.mybatis.beans;

public class Grade {
	private int id;
	private String name;
	private Room room;
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
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	@Override
	public String toString() {
		return "Grade [id=" + id + ", name=" + name + ", room=" + room + "]";
	}
	
}
