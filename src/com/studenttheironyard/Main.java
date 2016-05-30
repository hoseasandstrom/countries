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
    static final String SAVE_FILE = "country.json";
    static Scanner scanner = new Scanner(System.in);
    static Country country = new Country();

    static HashMap<String, ArrayList<Country>> countryMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        country = loadCountry(SAVE_FILE);
        if (country == null) {
            country = new Country();
            System.out.println("This will start again");
        } else {
            System.out.println("Found saved file.");
            System.out.println("Start this again? [y/n]");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                country = new Country();
            }
        }
        System.out.println("Look up a country:");
    if (country.country == null) country.chooseLetter();
    }

    public static void saveCountry(Country country, String filename) {
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.include("*").serialize(country);

        File f = new File(filename);
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(json);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Country loadCountry(String filename) throws FileNotFoundException {
        File f = new File(filename);
        try {
            Scanner scanner = new Scanner(f);
            scanner.useDelimiter("\\Z");
            String contents = scanner.next();
            JsonParser parser = new JsonParser();
            return parser.parse(contents, Country.class);
        } catch (FileNotFoundException e) {
        }
        return null;
    }
}






