package it.epicode.be.godfather.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@ToString
public class Ordine {

	private int numeroOrdine;
	private int numeroCoperti;
	private Tavolo tavolo;
	private LocalDateTime oraDiAcquisizione;
	private StatoOrdine statoOrdine;
	private List<ElementoOrdine> elementiOrdine;

	public double calcolaImportoTotale() {
		double importoTotale = 0.0;
		for (ElementoOrdine elementoOrdine : elementiOrdine) {
			MenuItem menuItem = elementoOrdine.getMenuItem();
			importoTotale += menuItem.getPrice();
		}
		importoTotale += getCostoCoperto();
		return importoTotale;
	}

	private double getCostoCoperto() {
		return 2.50;
	}

//	public double getCostoCoperto() {
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Ordine.class);
//
//		CostoCoperto copertoSingolo = ctx.getBean(CostoCoperto.class);
//
//		ctx.close();
//		return copertoSingolo.getMyValue() * numeroCoperti;
//	}

}
