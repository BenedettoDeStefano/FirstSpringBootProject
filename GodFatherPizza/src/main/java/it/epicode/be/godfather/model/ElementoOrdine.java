package it.epicode.be.godfather.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ElementoOrdine {

	private MenuItem menuItem;
	private String note;

}