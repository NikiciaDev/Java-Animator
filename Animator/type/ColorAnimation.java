package unkown.animator.type;
import unkown.animator.Animator;
import unkown.animator.util.ColorMath;
import unkown.animator.util.Easing;
import unkown.animator.util.Easings;

import java.awt.*;

/**
 * Use if u need to animation the color value
 */
public class ColorAnimation {

    private final Animator red = new Animator();
    private final Animator green = new Animator();
    private final Animator blue = new Animator();
    private final Animator alpha = new Animator();

    /**
     * Main method, use to animate color
     */
    public void animate(int colorTo, double duration) {
        animate(colorTo, duration, false);
    }

    /**
     * Main method, use to animate color
     */
    public void animate(int colorTo, double duration, boolean safe) {
        animate(colorTo, duration, Easings.NONE, safe);
    }

    /**
     * Main method, use to animate color
     */
    public void animate(int colorTo, double duration, Easing easing, boolean safe) {
        getRed().animate(ColorMath.extractRed(colorTo), duration, easing, safe);
        getGreen().animate(ColorMath.extractGreen(colorTo), duration, easing, safe);
        getBlue().animate(ColorMath.extractBlue(colorTo), duration, easing, safe);
        getAlpha().animate(ColorMath.extractAlpha(colorTo), duration, easing, safe);
    }

    /**
     * Main method, use to animate color
     */
    public void animate(Color colorTo, double duration, Easing easing, boolean safe) {
        animate(colorTo.getRGB(), duration, easing, safe);
    }

    /**
     * Main method, use to animate color
     */
    public void animate(Color colorTo, double duration, boolean safe) {
        animate(colorTo.getRGB(), duration, Easings.NONE, safe);
    }

    /**
     * Main method, use to animate color
     */
    public void animate(Color colorTo, double duration) {
        animate(colorTo.getRGB(), duration, false);
    }

    /**
     * Updates all colors
     *
     * @return all colors alive
     */
    public boolean update() {
        return ((getRed().update() &&
                getGreen().update() &&
                getBlue().update()) &&
                getAlpha().update())
                ||
                (getRed().update() &&
                        getGreen().update() &&
                        getBlue().update())
                ;
    }

    /**
     * @return all colors alive
     */
    public boolean isAlive() {
        return ((getRed().isAlive() && getGreen().isAlive() && getBlue().isAlive()) && getAlpha().isAlive()) || (getRed().isAlive() && getGreen().isAlive() && getBlue().isAlive());
    }

    /**
     * @return all colors done
     */
    public boolean isDone() {
        return !isAlive();
    }

    /**
     * Build java.awt.Color
     *
     * @return java.awt.Color
     */
    public Color getColor() {
        return new Color((int) getRed().getValue(), (int) getGreen().getValue(), (int) getBlue().getValue(), (int) getAlpha().getValue());
    }

    /**
     * return RGB color code
     *
     * @return java.awt.Color#getRGB()
     */
    public int getHex() {
        return getColor().getRGB();
    }

    public Animator getRed() {
        return red;
    }

    public Animator getGreen() {
        return green;
    }

    public Animator getBlue() {
        return blue;
    }

    public Animator getAlpha() {
        return alpha;
    }
}