package one.tyrannyoftherocketinvasion;

import java.util.List;
import java.util.function.Function;

public class FuelRequirements {

    public int calculate(int mass) {
        return (mass / 3) - 2;
    }

    public int sumOfRequirements(List<Integer> ints) {
        return sumOfRequirements(ints, this::calculate);
    }

    public int sumOfRequirementsAccountingForFuelMass(List<Integer> ints) {
        return sumOfRequirements(ints, this::calculateAccountingForExtraFuel);
    }

    private int sumOfRequirements(List<Integer> ints, Function<Integer, Integer> calculationMethod) {
        return ints.stream()
                .map(calculationMethod)
                .mapToInt(i -> i)
                .sum();
    }

    public int calculateAccountingForExtraFuel(int rocketMass) {
        return recursiveFuelCounter(rocketMass, 0);
    }

    private int recursiveFuelCounter(int fuelmass, int totalFuel) {
        int extraFuel = calculate(fuelmass);

        if (extraFuel <= 0) {
            return totalFuel;
        }

        return recursiveFuelCounter(extraFuel, totalFuel + extraFuel);
    }
}
