package it.epicode.be.godfather.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import it.epicode.be.godfather.config.MenuConfig;

@Component
public class GestoreOrdini implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MenuConfig.class);
		Menu menu = (Menu) ctx.getBean("menu");

		Tavolo tavolo1 = new Tavolo(1, 10, StatoTavolo.OCCUPATO);
		Tavolo tavolo2 = new Tavolo(2, 10, StatoTavolo.LIBERO);

		Ordine ordine = new Ordine(1, 4, tavolo2, LocalDateTime.now(), StatoOrdine.IN_CORSO, new ArrayList<>());

		ElementoOrdine elemento1 = new ElementoOrdine(menu.getMenuPizza().get(0), "Senza formaggio");
		ElementoOrdine elemento2 = new ElementoOrdine(menu.getMenuDrink().get(0), null);

		ordine.getElementiOrdine().add(elemento1);
		ordine.getElementiOrdine().add(elemento2);

		double importoTotale = ordine.calcolaImportoTotale();


		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Ordine numero: " + ordine.getNumeroOrdine());
		System.out.println(ordine.getTavolo());
		System.out.println("Stato ordine: " + ordine.getStatoOrdine());
		System.out.println("Ora di acquisizione: " + ordine.getOraDiAcquisizione());
		System.out.println("Numero coperti attuale: " + ordine.getNumeroCoperti());
		System.out.println("Elementi ordine:");

		for (ElementoOrdine elementoOrdine : ordine.getElementiOrdine()) {
			MenuItem menuItem = elementoOrdine.getMenuItem();
			String note = elementoOrdine.getNote();

			System.out.println("- " + menuItem.getName() + " - " + (note != null ? "Note: " + note : ""));
		}

		System.out.println("Importo totale: " + importoTotale);
	}
}
