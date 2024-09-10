package uniandes.dpoo.aerolinea.modelo.cliente;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;


public class ClienteNatural extends Cliente{
	
	public static final String NATURAL = "Natural";
	private String nombre;
	
	public ClienteNatural (String nombre) {
		this.nombre = nombre;
		
	}

	@Override
	public String getTipoCliente() {
		// TODO Auto-generated method stub
		return NATURAL;
	}

	@Override
	public String getIdentificador() {
		// TODO Auto-generated method stub
		return this.nombre + "_";
	}

	
	

}
