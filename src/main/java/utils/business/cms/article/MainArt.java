package utils.business.cms.article;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainArt {

    @SerializedName("alt_text")
    @Expose
    private String altText;
    @SerializedName("byline")
    @Expose
    private String byline;
    @SerializedName("caption")
    @Expose
    private String caption;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("crop_rect")
    @Expose
    private Object cropRect;
    @SerializedName("fid")
    @Expose
    private Object fid;
    @SerializedName("focus_rect")
    @Expose
    private Object focusRect;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("use_video_art")
    @Expose
    private Integer useVideoArt;
    @SerializedName("width")
    @Expose
    private String width;

    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Object getCropRect() {
        return cropRect;
    }

    public void setCropRect(Object cropRect) {
        this.cropRect = cropRect;
    }

    public Object getFid() {
        return fid;
    }

    public void setFid(Object fid) {
        this.fid = fid;
    }

    public Object getFocusRect() {
        return focusRect;
    }

    public void setFocusRect(Object focusRect) {
        this.focusRect = focusRect;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getUseVideoArt() {
        return useVideoArt;
    }

    public void setUseVideoArt(Integer useVideoArt) {
        this.useVideoArt = useVideoArt;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

}