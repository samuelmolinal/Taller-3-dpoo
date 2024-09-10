package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalcularTarifasTemporadaAlta extends CalculadoraTarifas{
	
	protected final int COSTO_POR_KM_NATURAL = 1000;

	@Override
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		int distancia = calcularDistanciaVuelo(vuelo.getRuta());
        return distancia * COSTO_POR_KM_NATURAL;
	}

	@Override
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		return 0.1;
	}
	
	
	
}
