import org.junit.jupiter.api.Test;
import rotten.pizza.service.PizzaConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaConfigTest {
    @Test
    public void testTaxRateValue() {
        assertEquals(0.19, PizzaConfig.taxRate, 0.0001, "taxRate should be 0.19");
    }
}