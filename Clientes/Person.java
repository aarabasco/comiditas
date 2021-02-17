package Clientes;
public class Person {
	private String name; 
	private int dni;
	private int age;
	
	public Person (String name, int dni, int age) {
		this.setName(name);
		this.setDni(dni);
		this.setAge(age);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}