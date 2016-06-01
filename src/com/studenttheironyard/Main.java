package com.studenttheironyard;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("Please choose a letter to see the countries associated with it.");
        System.out.println("** Note: letter input needs to be Uppercase ** ");
        Scanner scanner = new Scanner(System.in);
        String chooseLetter = scanner.nextLine();
        if (chooseLetter.length() > 1) {
            throw new Exception("Invalid input");
        }
        HashMap<String, ArrayList<Country>> countryMap = readCountriesFromFile("countries.txt");
        ArrayList countryArrayList = countryMap.get(chooseLetter);
        System.out.println(countryArrayList);
        loadCountry(chooseLetter, countryArrayList.toString());
        saveCountry(countryArrayList, chooseLetter);
    }

    public static HashMap<String, ArrayList<Country>> readCountriesFromFile(String fileName) throws FileNotFoundException {
        HashMap<String, ArrayList<Country>> countryMap= new HashMap<>();
        File f = new File(fileName);
        Scanner fileScanner = new Scanner(f);
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\|");
            Country country = new Country(columns[0], columns[1]);
            String chooseLetter = String.valueOf(country.countryCode.charAt(0));
            if (!countryMap.containsKey(chooseLetter)) {
                countryMap.put(chooseLetter, new ArrayList<>());
            }
            countryMap.get(chooseLetter).add(country);
        }
        return countryMap;
    }

    public static void loadCountry(String chooseLetter, String countryId ) throws IOException {
        File countryFile = new File(String.format("%s_Countries.txt", chooseLetter));

        FileWriter fw = new FileWriter(countryFile);
        fw.write(countryId);
        fw.close();

    }


    public static void saveCountry(ArrayList countryArrayList, String chooseLetter) throws IOException {
        File f = new File(String.format("%s_country.json", chooseLetter));
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.serialize(countryArrayList);
        FileWriter fw = new FileWriter(f);
        fw.write(json);
        fw.close();
        }


    }







