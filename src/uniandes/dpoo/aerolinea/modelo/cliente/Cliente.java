package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;
import java.util.List;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {
	
	private List<Tiquete> tiquetesSinUsar = new ArrayList<>();
	private List<Tiquete> tiquetesUsados = new ArrayList<>();
	
	public abstract String getTipoCliente();
	public abstract String getIdentificador();
	
	public void agregarTiquete(Tiquete tiquete) {
		
		tiquetesSinUsar.add(tiquete);
	}
	public int calcularValorTotalTiquetes() {
		int valorTotal = 0;
	    for (Tiquete tiquete : tiquetesSinUsar) {
	        valorTotal += tiquete.getTarifa();
	    }
	    for (Tiquete tiquete : tiquetesUsados) {
	        valorTotal += tiquete.getTarifa();
	    }
	    return valorTotal;
	}
	public void usarTiquetes(Vuelo vuelo) {
		List<Tiquete> tiquetesParaUsar = new ArrayList<>();

	    for (Tiquete tiquete : tiquetesSinUsar) {
	        if (tiquete.getVuelo().equals(vuelo)) {
	            tiquete.marcarComoUsado();
	            tiquetesParaUsar.add(tiquete);
	        }
	    }
	    tiquetesSinUsar.removeAll(tiquetesParaUsar);
	    tiquetesUsados.addAll(tiquetesParaUsar);
	}
	public abstract int getTamanoEmpresa();
	
}
