package beans;

/**
 * Specification bean assuming the following specifications
 * to be defined in the specs file ('vehicle_specs.json'):
 * - year from (int)
 * - year to (int)
 * - make and model (String)
 * - max price (int)
 *
 * @author Shahin 'Sean' Gadimov
 */
public class Specification {
	private int yearFrom;
	private int yearTo;
	private String makeOrModel;
	private int priceMax;
	
	public Specification() { }
	public Specification(int yearFrom, int yearTo, String makeOrModel, int priceMax) {
		super();
		this.yearFrom = yearFrom;
		this.yearTo = yearTo;
		this.makeOrModel = makeOrModel;
		this.priceMax = priceMax;
	}
	
	public int getYearFrom() {
		return yearFrom;
	}
	public void setYearFrom(int yearFrom) {
		this.yearFrom = yearFrom;
	}
	public int getYearTo() {
		return yearTo;
	}
	public void setYearTo(int yearTo) {
		this.yearTo = yearTo;
	}
	public String getMakeOrModel() {
		return makeOrModel;
	}
	public void setMakeOrModel(String makeOrModel) {
		this.makeOrModel = makeOrModel;
	}
	public int getPriceMax() {
		return priceMax;
	}
	public void setPriceMax(int priceMax) {
		this.priceMax = priceMax;
	}
	
	@Override
	public String toString() {
		return "Specification [yearFrom=" + yearFrom 
				+ ", yearTo=" + yearTo 
				+ ", makeOrModel=" + makeOrModel
				+ ", priceMax=" + priceMax + "]";
	}
}
