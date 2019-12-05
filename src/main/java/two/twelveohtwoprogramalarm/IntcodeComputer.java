package two.twelveohtwoprogramalarm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntcodeComputer {

    public List<Integer> compute(List<Integer> intCode) {
        for (int i = 0; i < intCode.size(); i += 4) {
            int inputCode = intCode.get(i);

            if (inputCode == 99) {
                break;
            }

            List<Integer> block = intCode.subList(i, i + 4);

            int sourceOne = intCode.get(block.get(1));
            int sourceTwo = intCode.get(block.get(2));
            int destination = block.get(3);

            int result;

            if (inputCode == 1) {
                result = sourceOne + sourceTwo;
            } else if (inputCode == 2) {
                result = sourceOne * sourceTwo;
            } else {
                throw new IllegalArgumentException();
            }

            intCode.set(destination, result);
        }
        return intCode;
    }

    public Map<String, Integer> pairsOfInputsProducing(int target, List<Integer> intCode) {
        for (int noun = 0; noun < 100; noun++) {
            for (int verb = 0; verb < 100; verb++) {
                List<Integer> copy = new ArrayList<>(intCode);
                copy.set(1, noun);
                copy.set(2, verb);

                final List<Integer> computed = compute(copy);

                if (computed.get(0) == target) {
                    Map<String, Integer> response = new HashMap<>();
                    response.put("noun", noun);
                    response.put("verb", verb);
                    return response;
                }
            }
            
        }
        throw new IllegalStateException("unable to compute target " + target + " with given inputs");
    }
}
