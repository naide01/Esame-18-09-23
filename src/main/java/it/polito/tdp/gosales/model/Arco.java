package it.polito.tdp.gosales.model;

public class Arco {
	Retailers r1;
	Retailers r2;
	int peso;
	public Arco(Retailers r1, Retailers r2, int peso) {
		super();
		this.r1 = r1;
		this.r2 = r2;
		this.peso = peso;
	}
	public Retailers getR1() {
		return r1;
	}
	public Retailers getR2() {
		return r2;
	}
	public int getPeso() {
		return peso;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + peso;
		result = prime * result + ((r1 == null) ? 0 : r1.hashCode());
		result = prime * result + ((r2 == null) ? 0 : r2.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arco other = (Arco) obj;
		if (peso != other.peso)
			return false;
		if (r1 == null) {
			if (other.r1 != null)
				return false;
		} else if (!r1.equals(other.r1))
			return false;
		if (r2 == null) {
			if (other.r2 != null)
				return false;
		} else if (!r2.equals(other.r2))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Arco da " + r1 + " a " + r2 + " con peso: " + peso + "\n";
	}
	
}
