package utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Specification;
import beans.Vehicle;

public class SpecAnalyzer {
	private static List<Specification> specs;
	
	static {
		specs = new ArrayList<Specification>();
		listOfSpecs();
	}
	
	public static boolean matchesSpecification(Vehicle vehicle) {
		int year = vehicle.getYear();
		String makeOrModel = vehicle.getMakeModel().toLowerCase();
		int price = vehicle.getPrice();
		
		for (Specification each : specs) {
			if (each.getYearFrom() <= year
					&& each.getYearTo() >= year
					&& makeOrModel.contains(each.getMakeOrModel())
					&& each.getPriceMax() >= price)
			return true;
		}
		
		return false;
	}
	
	private static void listOfSpecs() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			specs = mapper.readValue(
					new File("vehicle_specs.json"), 
					new TypeReference<List<Specification>>() {});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
