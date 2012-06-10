package de.schdef.slashcoding.recipeboard.domain;

public class Ingredient {

	final String amount;
	final String name;

	public Ingredient(String amount, String name) {
		super();
		this.amount = amount;
		this.name = name;
	}

	public String getAmount() {
		return amount;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return (amount != null ? amount : "") + " "
				+ (name != null ? name : "");
	}

}
