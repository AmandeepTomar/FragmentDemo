package tailor.latest.imran.amandeep.com.latesttailor.MyModelPattern;

/**
 * Created by admin on 9/29/2016.
 */

public class CustomPagerEnumImage {


    private String image;
    private String title;

    public CustomPagerEnumImage() {
    }

    CustomPagerEnumImage(String image, String title) {
        this.image = image;
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
