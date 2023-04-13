package fp.espacio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import fp.utiles.Utiles;

public class Astronauta {
	private String name;
	private Integer year,spaceFlights;
	private Status status;
	private Gender gender;
	private Boolean dead;
	private Nacimiento birth;
	
	public Astronauta(String name, Integer year, Status status, LocalDate fecha, String lugar, Gender gender, Integer spaceFlights, Boolean dead) {
		Utiles.checkNoNull(name);
		this.name = name;
		this.year = year;
		this.spaceFlights = spaceFlights;
		this.status = status;
		this.gender = gender;
		this.dead = dead;
		this.birth = new Nacimiento(lugar, fecha);
	}
	
	public Astronauta(String linea) {
		String[] trozos= linea.split("\t");
		LocalDate fecha=LocalDate.parse(trozos[3].trim(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		Utiles.checkNoNull(trozos[0].trim());
		name=trozos[0].trim();
		year=Integer.valueOf(trozos[1].trim());
		status=Status.valueOf(trozos[2].trim().toUpperCase());
		birth= new Nacimiento(trozos[4].trim(),fecha);
		gender=Gender.valueOf(trozos[5].trim().toUpperCase());
		spaceFlights=Integer.valueOf(trozos[6].trim());
		dead=Boolean.valueOf(trozos[7].trim().toLowerCase());
	}
	

	public String getName() {
		return name;
	}
	

	public Integer getYear() {
		return year;
	}
	

	public Integer getSpaceFlights() {
		return spaceFlights;
	}
	

	public Status getStatus() {
		return status;
	}
	

	public Gender getGender() {
		return gender;
	}
	

	public Boolean getDead() {
		return dead;
	}
	

	public Nacimiento getBirth() {
		return birth;
	}

	
	public void setSpaceFlights(Integer spaceFlights) {
		this.spaceFlights = spaceFlights;
	}
	

	public void setStatus(Status status) {
		this.status = status;
	}
	

	public void setDead(Boolean dead) {
		this.dead = dead;
	}
	

	public void setBirth(Nacimiento birth) {
		this.birth = birth;
	}


	public int hashCode() {
		return Objects.hash(birth, name);
	}


	public boolean equals(Object obj) {
		Boolean result=false;
		if (getClass() == obj.getClass()) {
		Astronauta other = (Astronauta) obj;
		return Objects.equals(birth, other.birth) && Objects.equals(name, other.name);
		}
		return result;
	}

}
