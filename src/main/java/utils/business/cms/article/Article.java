package utils.business.cms.article;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Article {

    @SerializedName("action")
    @Expose
    private String action;
    @SerializedName("articleEntry")
    @Expose
    private ArticleEntry articleEntry;
    @SerializedName("externalId")
    @Expose
    private String externalId;
    @SerializedName("externalSource")
    @Expose
    private String externalSource;
    @SerializedName("type")
    @Expose
    private String type;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public ArticleEntry getArticleEntry() {
        return articleEntry;
    }

    public void setArticleEntry(ArticleEntry articleEntry){
        this.articleEntry = articleEntry;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getExternalSource() {
        return externalSource;
    }

    public void setExternalSource(String externalSource) {
        this.externalSource = externalSource;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
