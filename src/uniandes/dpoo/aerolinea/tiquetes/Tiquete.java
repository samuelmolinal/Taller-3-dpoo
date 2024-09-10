package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Tiquete {
	
	private String codigo;
	private int tarifa;
	private boolean usado;
	private Vuelo vuelo;
	private Cliente cliente;
	
	public Tiquete (String codigo, Vuelo vuelo, Cliente clienteComprador, int tarifa) {
		this.codigo = codigo;
		this.vuelo = vuelo;
		this.cliente = clienteComprador;
		this.tarifa = tarifa;
		
	}

	public String getCodigo() {
		return this.codigo;
	}

	public int getTarifa() {
		return this.tarifa;
	}

	public Vuelo getVuelo() {
		return this.vuelo;
	}

	public Cliente getCliente() {
		return this.cliente;
	}
	public void marcarComoUsado() {
		this.usado = true;
		
	}
	public boolean esUsado() {
		return this.usado;
	}
}
