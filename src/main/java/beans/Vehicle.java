package beans;

/**
 * Vehicle bean assuming the following fields for a given vehicle:
 * - id (long)
 * - year (int)
 * - make and model (String)
 * - price (int)
 * - odometer (int)
 * - VIN (String)
 * - title status (String)
 * - drive-train (String)
 * - URL (String)
 *
 * @author Shahin 'Sean' Gadimov
 */
public class Vehicle {

	private long id;
	private int year;
	private String makeModel;
	private int price;
	private int odometer;
	private String vin;
	private String color;
	private String title;
	private String drivetrain;
	private String url;

	public Vehicle() { }

	public Vehicle(String url) {
		this.url = url;
	}

	public Vehicle(int year, String makeModel, int price) {
		this.year = year;
		this.makeModel = makeModel;
		this.price = price;
	}

	public Vehicle(long id, int year, String makeModel, int price) {
		this.id = id;
		this.year = year;
		this.makeModel = makeModel;
		this.price = price;
	}

	public Vehicle(int year, String makeModel, int price, 
			int odometer, String vin, String color, 
			String title, String drivetrain) {
		this.year = year;
		this.makeModel = makeModel;
		this.price = price;
		this.odometer = odometer;
		this.vin = vin;
		this.color = color;
		this.title = title;
		this.drivetrain = drivetrain;
	}

	@Override
	public String toString() {
		return "Year = " + year + "\n"
				+ "Make & model = " + makeModel + "\n" 
				+ "Price = $" + price + "\n"
				+ "Odometer = " + odometer + "\n"
				+ "VIN = " + vin + "\n"
				+ "Color = " + color + "\n"
				+ "Title = " + title + "\n"
				+ "Drivetrain = " + drivetrain;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getMakeModel() {
		return makeModel;
	}
	public void setMakeModel(String makeModel) {
		this.makeModel = makeModel;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getOdometer() {
		return odometer;
	}
	public void setOdometer(int odometer) {
		this.odometer = odometer;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDrivetrain() {
		return drivetrain;
	}
	public void setDrivetrain(String drivetrain) {
		this.drivetrain = drivetrain;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
