package griffith;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Skeleton {
	//weather API integration will be added here
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Voyageur, your travel clothing advisor!");

        String tripDate ="";
        boolean isValidDate = false;

        while (!isValidDate) {
            // Prompt user for trip date
            System.out.println("Please enter the date of your trip (YYYY-MM-DD):");
            tripDate = scanner.nextLine();

            isValidDate = isValidWeatherDate(tripDate);

            if (!isValidDate) {
                System.out.println("Error: Invalid trip date. Please enter a valid date.");
            }
        }

        int locationCount = 0;
        for (int day = 1; day <= 3; day++) {
            System.out.println("Day " + day + " of your trip:");

            for (int locationNum = 1; locationNum <= 2; locationNum++) {
                if (locationCount >= 5) {
                    break; // Exit the loop if 5 locations have been entered
                }

                System.out.println("Enter the name of location " + (locationCount + 1) + ":");
                String location = scanner.nextLine();

                String weatherCondition = getWeatherCondition(location, tripDate);
                String suggestedClothing = suggestClothing(weatherCondition);

                System.out.println("For " + location + ", we suggest: " + suggestedClothing);
                locationCount++;
            }
        }

        scanner.close();
    }
	 public static boolean isValidWeatherDate(String tripDate) {
	        try {
	            LocalDate parsedDate = LocalDate.parse(tripDate);
	            // This Validates that the date is not in the past
	            if (parsedDate.isBefore(LocalDate.now())) {
	                return false;
	            }
	            // This Validates that the date is within a reasonable future range
	            if (parsedDate.isAfter(LocalDate.now().plusYears(1))) {
	                return false;
	            }
	            return true;
	        } catch (DateTimeParseException e) {
	            return false;
	        }
	    }


	    public static String getWeatherCondition(String location, String tripDate) {
	     //code to fetch data from weather api
	        return "Sunny"; 
	    }

	    public static String suggestClothing(String weatherCondition) {
	        //once fetched, we suggest clothing based on data
	        return "Light clothes"; 
	    }
	

}
