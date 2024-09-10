package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifas {
	
	public static final double IMPUESTO = 0.28;
	private Cliente cliente;
	private Vuelo vuelo;
	public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
		int costoBase = calcularCostoBase(vuelo, cliente);
        double porcentajeDescuento = calcularPorcentajeDescuento(cliente);
        int costoFinal = (int) (costoBase * (1 - porcentajeDescuento));
        int valorImpuestos = calcularValorImpuestos(costoBase);
        return costoFinal + valorImpuestos;
	}
	protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);
	protected abstract double calcularPorcentajeDescuento(Cliente cliente);
	protected int calcularDistanciaVuelo(Ruta ruta) {
		Aeropuerto origen = ruta.getOrigen();
        Aeropuerto destino = ruta.getDestino();
        return Aeropuerto.calcularDistancia(origen, destino);
	}
	protected int calcularValorImpuestos(int CostoBase) {
		return (int) Math.round(CostoBase * IMPUESTO);
	}
	
}
