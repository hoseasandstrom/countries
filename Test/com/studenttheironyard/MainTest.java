package com.studenttheironyard;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by hoseasandstrom on 5/31/16.
 */
public class MainTest {
    @Test
    public void readCountriesFromFile() throws Exception {
        HashMap<String, ArrayList<Country>> testRun = Main.readCountriesFromFile("countries.txt");
        assertTrue();

    }

}