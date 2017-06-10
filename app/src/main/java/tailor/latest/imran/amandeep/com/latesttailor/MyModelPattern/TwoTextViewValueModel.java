package tailor.latest.imran.amandeep.com.latesttailor.MyModelPattern;

import java.io.Serializable;

/**
 * Created by admin on 10/3/2016.
 */

public class TwoTextViewValueModel implements Serializable {
    String headingOne;
    String HeadingTwo;

    public TwoTextViewValueModel() {
    }

    public TwoTextViewValueModel(String headingOne, String headingTwo) {
        this.headingOne = headingOne;
        HeadingTwo = headingTwo;
    }

    public String getHeadingOne() {
        return headingOne;
    }

    public void setHeadingOne(String headingOne) {
        this.headingOne = headingOne;
    }

    public String getHeadingTwo() {
        return HeadingTwo;
    }

    public void setHeadingTwo(String headingTwo) {
        HeadingTwo = headingTwo;
    }
}
