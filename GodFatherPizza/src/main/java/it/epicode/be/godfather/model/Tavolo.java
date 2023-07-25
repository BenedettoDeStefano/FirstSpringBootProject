package it.epicode.be.godfather.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@ToString
public class Tavolo {

	private int numeroTavolo;
	private int copertiMax;
	private StatoTavolo statoTavolo;

}
