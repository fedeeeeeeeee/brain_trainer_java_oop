package test.minigames.colorgama;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import model.minigames.colorgama.ColorValuesGenerator;
import model.minigames.colorgama.ColorValuesGeneratorImpl;

class ColorValuesGeneratorTest {

    private static final int VALUES = 20;
    private static final int DEGREE = 360;

    private final ColorValuesGenerator colorValuesGenerator = new ColorValuesGeneratorImpl();

    @Test
    public void testSimpleValue() {
        for (int i = 0; i < VALUES; i++) { 
            final int hue = this.colorValuesGenerator.getRandomH();
            final double saturation = this.colorValuesGenerator.getRandomSB();
            final double brightness = this.colorValuesGenerator.getRandomSB();
            assertTrue(hue >= 0 && hue <= DEGREE);
            assertTrue(saturation >= 0.0 && saturation <= 1.0);
            assertTrue(brightness >= 0.0 && brightness <= 1.0);
        }
    }

    @Test
    public void testValueWithBound() {
        for (int i = 0; i < VALUES; i++) { 
            final int hue = this.colorValuesGenerator.getRandomH(267);
            final double saturation = this.colorValuesGenerator.getRandomSB(0.3, 0.8);
            final double brightness = this.colorValuesGenerator.getRandomSB(0.1, 0.5);
            assertTrue(hue >= 0 && hue < 267);
            assertTrue(saturation >= 0.3 && saturation < 0.8);
            assertTrue(brightness >= 0.1 && brightness < 0.5);
        }
    }

    @Test
    public void testHueBound() {
        assertThrows(IllegalArgumentException.class, () -> this.colorValuesGenerator.getRandomH(-4));
        assertThrows(IllegalArgumentException.class, () -> this.colorValuesGenerator.getRandomH(-24));
        assertThrows(IllegalArgumentException.class, () -> this.colorValuesGenerator.getRandomH(362));
        assertThrows(IllegalArgumentException.class, () -> this.colorValuesGenerator.getRandomH(380));
    }

    @Test
    public void testSaturationBrightnessOriginBound() {
        assertThrows(IllegalArgumentException.class, () -> this.colorValuesGenerator.getRandomSB(-0.1, 0.5));
        assertThrows(IllegalArgumentException.class, () -> this.colorValuesGenerator.getRandomSB(0.2, 1.2));
        assertThrows(IllegalArgumentException.class, () -> this.colorValuesGenerator.getRandomSB(-2.1, 3.2));
        assertThrows(IllegalArgumentException.class, () -> this.colorValuesGenerator.getRandomSB(0.3, 0.3));
        assertThrows(IllegalArgumentException.class, () -> this.colorValuesGenerator.getRandomSB(0.6, 0.2));
    }
}
