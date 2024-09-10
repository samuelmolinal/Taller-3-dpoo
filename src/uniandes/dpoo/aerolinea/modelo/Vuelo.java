package uniandes.dpoo.aerolinea.modelo;

import java.util.HashMap;
import java.util.Map;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo {
	
	private String fecha;
	private Avion avion;
	private Ruta ruta;	
	private Map<String, Tiquete> tiquetes;
	
	public Vuelo (Ruta ruta, String fecha, Avion avion) {
		this.ruta = ruta;
		this.fecha = fecha;
		this.avion = avion;
		this.tiquetes = new HashMap<>();
	}

	public String getFecha() {
		return this.fecha;
	}

	public Avion getAvion() {
		return this.avion;
	}

	public Ruta getRuta() {
		return this.ruta;
	}

	public Map<String, Tiquete> getTiquetes() {
        return this.tiquetes;
    }
	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculador, int cantidad) {
		int totalTarifa = 0;
	    for (int i = 0; i < cantidad; i++) {
	        int tarifa = calculador.calcularTarifa(this, cliente);
	        Tiquete tiquete = GeneradorTiquetes.generarTiquete(this, cliente, tarifa);
	        tiquetes.put(tiquete.getCodigo(), tiquete);
	        totalTarifa += tarifa;
	    }
	    
	    return totalTarifa;
	}
	public boolean equals(Object obj) {
		if (this == obj) {
	        return true;
	    }
	    if (!(obj instanceof Vuelo)) {
	        return false;
	    }
	    Vuelo otroVuelo = (Vuelo) obj;
	    return this.fecha.equals(otroVuelo.fecha) && this.avion.equals(otroVuelo.avion) && this.ruta.equals(otroVuelo.ruta);
		
	}
	
}

