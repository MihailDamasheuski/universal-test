package utils.business.cms.article;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Byline {

    @SerializedName("byline")
    @Expose
    private String byline;
    @SerializedName("byline_type")
    @Expose
    private String bylineType;

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getBylineType() {
        return bylineType;
    }

    public void setBylineType(String bylineType) {
        this.bylineType = bylineType;
    }

}