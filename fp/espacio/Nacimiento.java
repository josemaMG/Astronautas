package fp.espacio;

import java.time.LocalDate;

import fp.utiles.Utiles;

public record Nacimiento(String birthPlace, LocalDate birthDate) {
	
	public Nacimiento {
		Utiles.checkNoNull(birthDate);
	}
	
}
