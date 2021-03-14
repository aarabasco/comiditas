package clients;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import products.Drink;
import products.Food;

/* Aquí tenemos el constructor de Persona. Este constructor sirve para establecer datos como:
 * el nombre, el dni, la edad.
 * También tiene una función boleana con la que comprobamos que no hay ningun usuario registrado con anterioridad
 * con el mismo dni con el que nos estamos registrando.
 * Y finalmente el toString devuelve el nombre, dni y edad que hemos introducido.
 */

@XmlRootElement(name="person")
@XmlSeeAlso({Client.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class Person implements Serializable{
	private String name; 
	private String dni;
	private int age;
	
	
	
	public Person (String name, String dni, int age) {
		this.name=name;
		this.dni=dni;
		this.age=age;
	}
	
	public Person() {
		this("","",0);
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
		return "\n Cliente "+this.getName()+"\n"+
			     " -------------------------------------------\n"+
			     " DNI del Cliente: "+this.getDni()+".\n"+
				 " Edad:            "+this.getAge()+".";
	
	
	}
	
}
