package tailor.latest.imran.amandeep.com.latesttailor.MyModelPattern;

import java.io.Serializable;

/**
 * Created by admin on 9/28/2016.
 */

public class OfferDataModel implements Serializable {
    String image;
    String title;

    public OfferDataModel() {
    }

    public OfferDataModel(String image, String title) {
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
