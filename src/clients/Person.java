package clients;

import java.io.Serializable;

/* Aquí tenemos el constructor de Persona. Este constructor sirve para establecer datos como:
 * el nombre, el dni, la edad.
 * También tiene una función boleana con la que comprobamos que no hay ningun usuario registrado con anterioridad
 * con el mismo dni con el que nos estamos registrando.
 * Y finalmente el toString devuelve el nombre, dni y edad que hemos introducido.
 */

public class Person implements Serializable{
	private String name; 
	private String dni;
	private int age;
	
	public Person (String name, String dni, int age) {
		this.name=name;
		this.dni=dni;
		this.age=age;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;	
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", dni=" + dni + ", age=" + age+",";
	}
	
	
	
	
}
