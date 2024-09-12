package test;

import java.util.Objects;



public class Goods {
	String name;
	int code, number;
	double price;
	String type;

	public Goods(int code, String name, double price, int number, String type) {
		this.name = name;
		this.code = code;
		this.number = number;
		this.price = price;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return code + "    " + name + "    " + price + "    " + number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Goods))
			return false;
		Goods goods = (Goods) o;
		return getCode() == goods.getCode() && Double.compare(goods.getPrice(), getPrice()) == 0
				&& Objects.equals(getName(), goods.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName(), getCode(), getPrice());
	}
}
