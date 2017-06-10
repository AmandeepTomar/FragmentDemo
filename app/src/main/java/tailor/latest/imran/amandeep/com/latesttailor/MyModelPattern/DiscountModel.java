package tailor.latest.imran.amandeep.com.latesttailor.MyModelPattern;

/**
 * Created by admin on 9/27/2016.
 */

public class DiscountModel {
    String image;
    String tagLine;
    String test_color;
    String test_color_bottom;

    public DiscountModel() {
    }

    public DiscountModel(String image, String tagLine,String test_color,String test_color_bottom) {
        this.image = image;
        this.tagLine = tagLine;
        this.test_color=test_color;
        this.test_color_bottom=test_color_bottom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTagLine() {
        return tagLine;
    }

    public void setTagLine(String tagLine) {
        this.tagLine = tagLine;
    }

    public String getTest_color() {
        return test_color;
    }

    public void setTest_color(String test_color) {
        this.test_color = test_color;
    }

    public String getTest_color_bottom() {
        return test_color_bottom;
    }

    public void setTest_color_bottom(String test_color_bottom) {
        this.test_color_bottom = test_color_bottom;
    }
}
