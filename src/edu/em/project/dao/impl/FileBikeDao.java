package edu.em.project.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import edu.em.project.dao.BikeDao;
import edu.em.project.dao.DaoException;
import edu.em.project.entity.Bike;

public class FileBikeDao implements BikeDao {

	private static final String FILE_NAME = "resources\\bike.txt";

	@Override
	public void addBike(Bike bike) throws DaoException {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileWriter(FILE_NAME, true));
			writer.println(convertBikeToString(bike));
		} catch (IOException e) {
			throw new DaoException(e);
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	@Override
	public void deleteBikeByModel(String model) throws DaoException {
		try {

			List<String> bikes = Files.readAllLines(Paths.get(FILE_NAME));
			List<String> updatedLines = new ArrayList<>();

			for (String line : bikes) {
				if (!line.contains(model)) {
					updatedLines.add(line);
				}
			}

			Files.write(Paths.get(FILE_NAME), updatedLines);
		} catch (IOException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public List<Bike> findBikeByModel(String model) throws DaoException {

		List<Bike> matchingBikes = new ArrayList<>();
		List<Bike> allBikes = getAllBikes();

		for (Bike bike : allBikes) {
			if (bike.getModel().equalsIgnoreCase(model)) {
				matchingBikes.add(bike);
			}
		}
		return matchingBikes;
	}

	@Override
	public List<Bike> findBikeByColor(String color) throws DaoException {

		List<Bike> matchingBikes = new ArrayList<>();
		List<Bike> allBikes = getAllBikes();

		for (Bike bike : allBikes) {
			if (bike.getColor().equalsIgnoreCase(color)) {
				matchingBikes.add(bike);
			}
		}
		return matchingBikes;
	}

	@Override
	public List<Bike> findBikeBySize(int size) throws DaoException {
		
		List<Bike> matchingBikes = new ArrayList<>();
		List<Bike> allBikes = getAllBikes();

		for (Bike bike : allBikes) {
			if (bike.getSize() == size) {
				matchingBikes.add(bike);
			}
		}
		return matchingBikes;
	}

	@Override
	public List<Bike> findBikeByPrice(double price) throws DaoException {
		
		List<Bike> matchingBikes = new ArrayList<>();
		List<Bike> allBikes = getAllBikes();

		for (Bike bike : allBikes) {
			if (bike.getPrice() == price) {
				matchingBikes.add(bike);
			}
		}
		return matchingBikes;
	}

	@Override
	public List<Bike> allBikes(List<Bike> bikes) throws DaoException {
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
			
			for (Bike bike : bikes) {
				writer.write(convertBikeToString(bike));
				writer.newLine();
			}
		} catch (IOException e) {
			throw new DaoException(e);
		}
		return bikes;
	}

	private List<Bike> getAllBikes() throws DaoException {
		List<Bike> bikes = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
			String line;
			while ((line = reader.readLine()) != null) {
				bikes.add(convertStringToBike(line));
			}
		} catch (IOException e) {
			throw new DaoException(e);
		}
		return bikes;
	}

	private String convertBikeToString(Bike bike) {
		return bike.getModel() + "," + bike.getColor() + "," + bike.getPrice() + "," + bike.getSize();
	}

	private Bike convertStringToBike(String line) {
		String[] parts = line.split(",");
		return new Bike(parts[0], parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]));
	}
}
