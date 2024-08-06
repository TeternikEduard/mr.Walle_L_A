package edu.em.project.entity;

import java.util.Objects;

public class Bike {

	private String model;
	private String color;
	private double price;
	private int size;

	public Bike() {
	}

	public Bike(String model, String color, double price, int size) {
		this.model = model;
		this.color = color;
		this.price = price;
		this.size = size;
	}

	public Bike(String model, double price, int size) {
		this.model = model;
		this.price = price;
		this.size = size;
	}

	public Bike(String model, double price) {
		this.model = model;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, model, price, size);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bike other = (Bike) obj;
		return Objects.equals(color, other.color) && Objects.equals(model, other.model)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && size == other.size;
	}

	@Override
	public String toString() {
		return getClass().getName() + " Модель [_" + model + "_], цвет - " + color + ", цена = " + price
				+ ", размер колёс - " + size + "\'.";
	}
}
