package tailor.latest.imran.amandeep.com.latesttailor.MyModelPattern;

import tailor.latest.imran.amandeep.com.latesttailor.R;

/**
 * Created by admin on 9/29/2016.
 */

public enum CustomPagerEnum {

    RED(R.string.red, R.layout.view_red),
    BLUE(R.string.blue, R.layout.view_horizontal),
    ORANGE(R.string.orange, R.layout.view_orange);

    private int mTitleResId;
    private int mLayoutResId;

    CustomPagerEnum(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}
