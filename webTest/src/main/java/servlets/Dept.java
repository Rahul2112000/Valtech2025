package servlets;

public class Dept {
	
	private int id;
	private String name;
	private String Location;
	public Dept(int id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		Location = location;
	}
	
	
	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + ", Location=" + Location + "]";
	}


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
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	
	

}
