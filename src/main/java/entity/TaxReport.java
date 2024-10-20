package entity;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TaxReport {
    private final Map<String, Float> values;

    public TaxReport(Map<String, Float> values) {
        this.values = values;
    }

    public void displayAscending(boolean ascending) {
        Map<String, Float> valuesSorted = values.entrySet()
                .stream()
                .sorted(ascending 
                        ? Map.Entry.<String, Float>comparingByValue()
                        : Map.Entry.<String, Float>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        
        valuesSorted.forEach((key, value) -> System.out.println(key + " = " + value + " hrn"));
    }

    public Map<String, Float> getValues() {
        return values;
    }
}
