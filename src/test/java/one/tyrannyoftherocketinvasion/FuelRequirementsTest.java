package one.tyrannyoftherocketinvasion;

import org.junit.Before;
import org.junit.Test;
import util.FileIngestor;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class FuelRequirementsTest {

    private FuelRequirements fuelRequirements;
    private FileIngestor fileIngestor;

    @Before
    public void setup() {
        fuelRequirements = new FuelRequirements();
        fileIngestor = new FileIngestor();
    }

    @Test
    public void twelve() {
        int expected = 2;
        int actual = fuelRequirements.calculate(12);
        assertEquals(expected, actual);
    }

    @Test
    public void withReadInputs() throws IOException {
        final List<Integer> integers = fileIngestor.readListOfNumbers("src/test/resources/one/inputs");
        final int i = fuelRequirements.sumOfRequirements(integers);
        System.out.println(i);
        int expected = 3239503;
        assertEquals(expected, i);
    }

    @Test
    public void twelveAccountingForFuel() {
        int expected = 2;
        int actual = fuelRequirements.calculate(12);
        assertEquals(expected, actual);
    }

    @Test
    public void accountingForFuel1969() {
        int expected = 966;
        int actual = fuelRequirements.calculateAccountingForExtraFuel(1969);
        assertEquals(expected, actual);
    }

    @Test
    public void accountingForFuel100756() {
        int expected = 50346;
        int actual = fuelRequirements.calculateAccountingForExtraFuel(100756);
        assertEquals(expected, actual);
    }

    @Test
    public void sumOfReadInputsAccountingForFuelMass() throws IOException {
        final List<Integer> integers = fileIngestor.readListOfNumbers("src/test/resources/one/inputs");
        int actual = fuelRequirements.sumOfRequirementsAccountingForFuelMass(integers);
        System.out.println(actual);
        assertEquals(4856390, actual);
    }
}