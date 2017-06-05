package pro.proxeter.dsp.models;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * Created by proxeter on 04.06.17.
 */
@XmlRootElement(name = "bid")
public class Bid {

    private String url;

    private float price;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Bid withUrl(String url) {
        this.url = url;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Bid withPrice(float price) {
        this.price = price;
        return this;
    }

    public Bid withRandom() {
        this.price = round(RandomUtils.nextFloat(0.1f, 2.5f), 2);
        this.url = "http://" + RandomStringUtils.randomAlphabetic(5) + ".com/" + RandomStringUtils.randomAlphabetic(8);

        return this;
    }

    private static float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }

}
