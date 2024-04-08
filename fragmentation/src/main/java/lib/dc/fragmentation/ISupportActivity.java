package lib.dc.fragmentation;

import android.view.MotionEvent;

import lib.dc.fragmentation.animation.FragmentAnimator;

public interface ISupportActivity {

    SupportActivityDelegate getSupportDelegate();

    ExtraTransaction extraTransaction();

    void post(Runnable runnable);

    void onBackPressed();

    void onBackPressedSupport();

    boolean dispatchTouchEvent(MotionEvent ev);

    FragmentAnimator getFragmentAnimator();

    void setFragmentAnimator(FragmentAnimator fragmentAnimator);
}
