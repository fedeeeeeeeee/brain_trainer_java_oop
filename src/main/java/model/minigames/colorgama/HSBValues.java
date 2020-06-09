package model.minigames.colorgama;

import org.apache.commons.lang3.tuple.Triple;

/**
 * This class implements {@link ColorValues<Triple<Integer, Double, Double>>}.
 *
 */
public final class HSBValues implements ColorValues<Triple<Integer, Integer, Integer>> {

    private final Integer hue;
    private final Integer saturation;
    private final Integer brightness;

    /**
     * Simple constructor of {@link ColorValues<Triple<Integer, Integer, Integer>>}.
     * 
     * @param h
     *          the hue component.
     * @param s
     *          the saturation component.
     * @param b
     *          the brightness component.
     */
    public HSBValues(final Integer h, final Integer s, final Integer b) {
        this.hue = h;
        this.saturation = s;
        this.brightness = b;
    }

    @Override
    public Triple<Integer, Integer, Integer> getValue() {
        return Triple.of(this.hue, this.saturation, this.brightness);
    }

    @Override
    public String getColorString() {
        return "hsl(" + this.hue + "," + this.saturation + "%," + this.brightness + "%)";
    }
}
