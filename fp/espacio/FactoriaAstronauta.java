package fp.espacio;

import fp.utiles.Utiles;

public class FactoriaAstronauta {
	
	public Astronauta parsearAstronauta(String linea) {
		return new Astronauta(linea);
	}
	
	public Astronautas leerAstronautas(String path) {
		Astronautas result= new Astronautas();
		for (String e: Utiles.leerCSV(path)) {
			result.agregarAstronauta(parsearAstronauta(e));
		}
		return result;
	}

	
}
