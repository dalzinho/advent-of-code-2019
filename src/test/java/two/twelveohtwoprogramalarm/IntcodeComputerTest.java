package two.twelveohtwoprogramalarm;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class IntcodeComputerTest {

    private IntcodeComputer intcodeComputer;
    private List<Integer> testInput;

    @Before
    public void setup() {
        intcodeComputer = new IntcodeComputer();
        testInput = Arrays.asList(1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,1,9,19,1,13,19,23,2,23,9,27,1,6,27,31,2,10,31,35,1,6,35,39,2,9,39,43,1,5,43,47,2,47,13,51,2,51,10,55,1,55,5,59,1,59,9,63,1,63,9,67,2,6,67,71,1,5,71,75,1,75,6,79,1,6,79,83,1,83,9,87,2,87,10,91,2,91,10,95,1,95,5,99,1,99,13,103,2,103,9,107,1,6,107,111,1,111,5,115,1,115,2,119,1,5,119,0,99,2,0,14,0);
    }

    @Test
    public void test1() {
        List<Integer> input = Arrays.asList(1,0,0,0,99);
        List<Integer> expected = Arrays.asList(2,0,0,0,99);
        List<Integer> actual = intcodeComputer.compute(input);
        assertEquals(expected,actual);
    }

    @Test
    public void test2() {
        List<Integer> input = Arrays.asList(1,9,10,3,2,3,11,0,99,30,40,50);
        List<Integer> expected = Arrays.asList(3500,9,10,70,2,3,11,0,99,30,40,50);
        List<Integer> actual = intcodeComputer.compute(input);
        assertEquals(expected, actual);
    }

    @Test
    public void useTestInput() {
        testInput.set(1, 12);
        testInput.set(2, 2);
        final List<Integer> integers = intcodeComputer.compute(testInput);
        System.out.println(integers);
        List<Integer> expected = Arrays.asList(2894520, 12, 2, 2, 1, 1, 2, 3, 1, 3, 4, 3, 1, 5, 0, 3, 2, 1, 9, 36, 1, 13, 19, 41, 2, 23, 9, 123, 1, 6, 27, 125, 2, 10, 31, 500, 1, 6, 35, 502, 2, 9, 39, 1506, 1, 5, 43, 1507, 2, 47, 13, 7535, 2, 51, 10, 30140, 1, 55, 5, 30141, 1, 59, 9, 30144, 1, 63, 9, 30147, 2, 6, 67, 60294, 1, 5, 71, 60295, 1, 75, 6, 60297, 1, 6, 79, 60299, 1, 83, 9, 60302, 2, 87, 10, 241208, 2, 91, 10, 964832, 1, 95, 5, 964833, 1, 99, 13, 964838, 2, 103, 9, 2894514, 1, 6, 107, 2894516, 1, 111, 5, 2894517, 1, 115, 2, 2894519, 1, 5, 119, 0, 99, 2, 0, 14, 0);
        assertEquals(expected, integers);
    }

    @Test
    public void pairsOfInputsProducing19690720() {
        final Map<String, Integer> stringIntegerMap = intcodeComputer.pairsOfInputsProducing(19690720, testInput);
        System.out.println(stringIntegerMap);
        System.out.println(100 * stringIntegerMap.get("noun") + stringIntegerMap.get("verb"));

    }

}