package auto;

public class Vehicle {

	public static Long id;
	
	private int year;
	private String makeModel;
	private int price;
	private int odometer;
	private String vin;
	private String color;
	private String title;
	private String drive;
	
	public Vehicle() { }
	
	public Vehicle(int year, String makeModel, int price) {
		this.year = year;
		this.makeModel = makeModel;
		this.price = price;
	}
	
	public Vehicle(int year, String makeModel, int price, 
			int odometer, String vin, String color, 
			String title, String drive) {
		this.year = year;
		this.makeModel = makeModel;
		this.price = price;
		this.odometer = odometer;
		this.vin = vin;
		this.color = color;
		this.title = title;
		this.drive = drive;
	}

	@Override
	public String toString() {
		return "Year = " + year + "\n"
				+ "Make & model = " + makeModel + "\n" 
				+ "Price = " + price + "\n"
				+ "Odometer = " + odometer + "\n"
				+ "VIN = " + vin + "\n"
				+ "Color = " + color + "\n"
				+ "Title = " + title + "\n"
				+ "Drivetrain = " + drive;
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
	public String getDrive() {
		return drive;
	}
	public void setDrive(String drive) {
		this.drive = drive;
	}	
}
