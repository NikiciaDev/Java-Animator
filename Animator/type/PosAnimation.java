package unkown.animator.type;

import unkown.animator.Animator;
import unkown.animator.util.Easing;
import unkown.animator.util.Easings;
import unkown.animator.util.V2;

/**
 * Use if u need to animation the position
 */
public class PosAnimation {

    private final Animator x = new Animator();
    private final Animator y = new Animator();

    /**
     * Main method, use to animate position
     */
    public void animate(V2 posTo, double duration) {
        getX().animate(posTo.getX(), duration, false);
        getY().animate(posTo.getY(), duration, false);
    }

    /**
     * Main method, use to animate position
     */
    public void animate(V2 posTo, double duration, boolean safe) {
        getX().animate(posTo.getX(), duration, Easings.NONE, safe);
        getY().animate(posTo.getY(), duration, Easings.NONE, safe);
    }

    /**
     * Main method, use to animate position
     */
    public void animate(V2 posTo, double duration, Easing easing, boolean safe) {
        getX().animate(posTo.getX(), duration, easing, safe);
        getY().animate(posTo.getY(), duration, easing, safe);
    }

    /**
     * Updates all coordinates
     * @return all v2s alive
     */
    public boolean update() {
        return getX().update() && getY().update();
    }

    /**
     * Get position
     * @return positions via utility V2 class
     */
    public V2 getPosition() {
        return new V2(getX().getValue(), getY().getValue());
    }

    /**
     * @return all coordinates alive
     */
    public boolean isAlive() {
        return getX().isAlive() && getY().isAlive();
    }

    /**
     * @return all coordinates done
     */
    public boolean isDone() {
        return !isAlive();
    }

    public Animator getX() {
        return x;
    }

    public Animator getY() {
        return y;
    }
}