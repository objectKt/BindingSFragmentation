package lib.dc.fragmentation;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Fragmentation {

    /**
     * Donot display stack view.
     */
    public static final int NONE = 0;
    /**
     * Shake it to display stack view.
     */
    public static final int SHAKE = 1;
    /**
     * As a bubble display stack view.
     */
    public static final int BUBBLE = 2;

    static volatile Fragmentation INSTANCE;

    private boolean debug;
    private int mode = BUBBLE;
    int targetFragmentEnter, currentFragmentPopExit, currentFragmentPopEnter, targetFragmentExit;


    @IntDef({NONE, SHAKE, BUBBLE})
    @Retention(RetentionPolicy.SOURCE)
    @interface StackViewMode {
    }

    public static Fragmentation getDefault() {
        if (INSTANCE == null) {
            synchronized (Fragmentation.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Fragmentation(new FragmentationBuilder());
                }
            }
        }
        return INSTANCE;
    }

    Fragmentation(FragmentationBuilder builder) {
        debug = builder.debug;
        if (debug) {
            mode = builder.mode;
        } else {
            mode = NONE;
        }

        targetFragmentEnter = builder.targetFragmentEnter;
        currentFragmentPopExit = builder.currentFragmentPopExit;
        currentFragmentPopEnter = builder.currentFragmentPopEnter;
        targetFragmentExit = builder.targetFragmentExit;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }


    public int getMode() {
        return mode;
    }

    public void setMode(@StackViewMode int mode) {
        this.mode = mode;
    }

    public static FragmentationBuilder builder() {
        return new FragmentationBuilder();
    }

    public static class FragmentationBuilder {
        private boolean debug;
        private int mode;
        private int targetFragmentEnter, currentFragmentPopExit, currentFragmentPopEnter, targetFragmentExit;


        /**
         * @param debug Suppressed Exception("Can not perform this action after onSaveInstanceState!") when debug=false
         */
        public FragmentationBuilder debug(boolean debug) {
            this.debug = debug;
            return this;
        }

        public FragmentationBuilder animation(int targetFragmentEnter, int currentFragmentPopExit, int currentFragmentPopEnter, int targetFragmentExit) {
            this.targetFragmentEnter = targetFragmentEnter;
            this.currentFragmentPopExit = currentFragmentPopExit;
            this.currentFragmentPopEnter = currentFragmentPopEnter;
            this.targetFragmentExit = targetFragmentExit;
            return this;
        }

        /**
         * Sets the mode to display the stack view
         * <p>
         * None if debug(false).
         * <p>
         * Default:NONE
         */
        public FragmentationBuilder stackViewMode(@StackViewMode int mode) {
            this.mode = mode;
            return this;
        }

        public Fragmentation install() {
            Fragmentation.INSTANCE = new Fragmentation(this);
            return Fragmentation.INSTANCE;
        }
    }
}
