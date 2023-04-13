package fp.espacio;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Astronautas {
	private List<Astronauta> astronautas;
	
	public Astronautas(List<Astronauta> astronautas) {
		this.astronautas=astronautas;
	}
	
	public Astronautas() {
		astronautas=new LinkedList<>();
	}

	public List<Astronauta> getAstronautas() {
		return astronautas;
	}

	public Integer getNumeroAstronautas() {
		return astronautas.size();
	}
	
	public void agregarAstronauta(Astronauta a) {
		astronautas.add(a);
	}
	
	public void agregarColeccion(Collection<Astronauta> a) {
		astronautas.addAll(a);
	}
	
	public void eliminarAstronauta(Astronauta e) {
		astronautas.remove(e);
	}
	
	public Boolean hayAstronautaConMasNVuelos(Integer n) {
		return astronautas.stream().anyMatch(e->e.getSpaceFlights()>n);
	}
	
	public Double getMediaDeYear() {
		return astronautas.stream().mapToInt(Astronauta::getYear).average().getAsDouble();
	}
	
	public List<Astronauta> obtenerAstronautasPorGenero(Gender a) {
		return astronautas.stream().filter(e->e.getGender().equals(a)).toList();
	}
	
	public Map<Gender,List<Astronauta>> agruparPorStatus() {
		return astronautas.stream().collect(Collectors.groupingBy(Astronauta::getGender));
	}
	
	public Map<Integer,Integer> getNumeroAstronautasPorAñoDeNacimiento() {
		return astronautas.stream().collect(Collectors.groupingBy(e->e.getBirth().birthDate().getYear(), Collectors.summingInt(Astronauta::getSpaceFlights)));
	}
	
	public Integer obtenerNumeroMaximoViajesPorGenero(Gender a) {
		return astronautas.stream().filter(e->e.getGender().equals(a)).mapToInt(el->el.getSpaceFlights()).max().getAsInt();
	}
	
	public List<Astronauta> obtenerListaOrdenadaPorVuelos(Integer n) {
		return astronautas.stream().sorted(Comparator.comparing(e->e.getSpaceFlights())).limit(n).toList();
	}
	
	public Map<Status,Integer> obtenerMaximosVuelosPorStatus() {
		return astronautas.stream().collect(Collectors.groupingBy(Astronauta::getStatus, Collectors.maxBy(Comparator.comparing(e->e.getSpaceFlights()))));
	}
	
	//Collectors.mapping(Astronauta::getSpaceFlights, Collectors.toList()))
	
	
	
	
	
	
}
