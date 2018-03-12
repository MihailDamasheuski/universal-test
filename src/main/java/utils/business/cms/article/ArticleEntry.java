package utils.business.cms.article;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArticleEntry {

    @SerializedName("ads_enabled")
    @Expose
    private Integer adsEnabled;
    @SerializedName("article_type")
    @Expose
    private String articleType;
    @SerializedName("autoplay_video")
    @Expose
    private Integer autoplayVideo;
    @SerializedName("breaking_news")
    @Expose
    private Integer breakingNews;
    @SerializedName("breaking_news_alert")
    @Expose
    private Integer breakingNewsAlert;
    @SerializedName("breaking_news_alert_delivery")
    @Expose
    private String breakingNewsAlertDelivery;
    @SerializedName("breaking_news_alert_title")
    @Expose
    private String breakingNewsAlertTitle;
    @SerializedName("breaking_news_headline")
    @Expose
    private String breakingNewsHeadline;
    @SerializedName("byline")
    @Expose
    private List<Byline> byline = null;
    @SerializedName("comments_enabled")
    @Expose
    private Integer commentsEnabled;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("cover_image")
    @Expose
    private CoverImage coverImage;
    @SerializedName("curated_list")
    @Expose
    private List<Object> curatedList = null;
    @SerializedName("editorial_notes")
    @Expose
    private String editorialNotes;
    @SerializedName("external_link")
    @Expose
    private String externalLink;
    @SerializedName("first_publication_date")
    @Expose
    private Integer firstPublicationDate;
    @SerializedName("hidden")
    @Expose
    private Integer hidden;
    @SerializedName("labels")
    @Expose
    private List<Object> labels = null;
    @SerializedName("linked_sections")
    @Expose
    private List<Object> linkedSections = null;
    @SerializedName("linked_sub_topics")
    @Expose
    private List<Object> linkedSubTopics = null;
    @SerializedName("linked_topics")
    @Expose
    private List<Object> linkedTopics = null;
    @SerializedName("main_art")
    @Expose
    private MainArt mainArt;
    @SerializedName("native_ad")
    @Expose
    private Integer nativeAd;
    @SerializedName("news_keywords")
    @Expose
    private String newsKeywords;
    @SerializedName("nid")
    @Expose
    private String nid;
    @SerializedName("publication_date")
    @Expose
    private Integer publicationDate;
    @SerializedName("revision_timestamp")
    @Expose
    private Integer revisionTimestamp;
    @SerializedName("search_enabled")
    @Expose
    private Integer searchEnabled;
    @SerializedName("section")
    @Expose
    private List<String> section = null;
    @SerializedName("seo_headline")
    @Expose
    private String seoHeadline;
    @SerializedName("seo_slug")
    @Expose
    private String seoSlug;
    @SerializedName("show_on_cover")
    @Expose
    private Integer showOnCover;
    @SerializedName("social_media_headline")
    @Expose
    private String socialMediaHeadline;
    @SerializedName("source")
    @Expose
    private List<Object> source = null;
    @SerializedName("source_site_name")
    @Expose
    private String sourceSiteName;
    @SerializedName("source_type")
    @Expose
    private String sourceType;
    @SerializedName("sponsor_label")
    @Expose
    private String sponsorLabel;
    @SerializedName("standout_article")
    @Expose
    private Integer standoutArticle;
    @SerializedName("storyline")
    @Expose
    private List<Object> storyline = null;
    @SerializedName("sub_topic")
    @Expose
    private List<Object> subTopic = null;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("tease_image")
    @Expose
    private Object teaseImage;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("topic")
    @Expose
    private List<String> topic = null;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("video_art_url")
    @Expose
    private String videoArtUrl;

    public Integer getAdsEnabled() {
        return adsEnabled;
    }

    public void setAdsEnabled(Integer adsEnabled) {
        this.adsEnabled = adsEnabled;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public Integer getAutoplayVideo() {
        return autoplayVideo;
    }

    public void setAutoplayVideo(Integer autoplayVideo) {
        this.autoplayVideo = autoplayVideo;
    }

    public Integer getBreakingNews() {
        return breakingNews;
    }

    public void setBreakingNews(Integer breakingNews) {
        this.breakingNews = breakingNews;
    }

    public Integer getBreakingNewsAlert() {
        return breakingNewsAlert;
    }

    public void setBreakingNewsAlert(Integer breakingNewsAlert) {
        this.breakingNewsAlert = breakingNewsAlert;
    }

    public String getBreakingNewsAlertDelivery() {
        return breakingNewsAlertDelivery;
    }

    public void setBreakingNewsAlertDelivery(String breakingNewsAlertDelivery) {
        this.breakingNewsAlertDelivery = breakingNewsAlertDelivery;
    }

    public String getBreakingNewsAlertTitle() {
        return breakingNewsAlertTitle;
    }

    public void setBreakingNewsAlertTitle(String breakingNewsAlertTitle) {
        this.breakingNewsAlertTitle = breakingNewsAlertTitle;
    }

    public String getBreakingNewsHeadline() {
        return breakingNewsHeadline;
    }

    public void setBreakingNewsHeadline(String breakingNewsHeadline) {
        this.breakingNewsHeadline = breakingNewsHeadline;
    }

    public List<Byline> getByline() {
        return byline;
    }

    public void setByline(List<Byline> byline) {
        this.byline = byline;
    }

    public Integer getCommentsEnabled() {
        return commentsEnabled;
    }

    public void setCommentsEnabled(Integer commentsEnabled) {
        this.commentsEnabled = commentsEnabled;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CoverImage getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(CoverImage coverImage) {
        this.coverImage = coverImage;
    }

    public List<Object> getCuratedList() {
        return curatedList;
    }

    public void setCuratedList(List<Object> curatedList) {
        this.curatedList = curatedList;
    }

    public String getEditorialNotes() {
        return editorialNotes;
    }

    public void setEditorialNotes(String editorialNotes) {
        this.editorialNotes = editorialNotes;
    }

    public String getExternalLink() {
        return externalLink;
    }

    public void setExternalLink(String externalLink) {
        this.externalLink = externalLink;
    }

    public Integer getFirstPublicationDate() {
        return firstPublicationDate;
    }

    public void setFirstPublicationDate(Integer firstPublicationDate) {
        this.firstPublicationDate = firstPublicationDate;
    }

    public Integer getHidden() {
        return hidden;
    }

    public void setHidden(Integer hidden) {
        this.hidden = hidden;
    }

    public List<Object> getLabels() {
        return labels;
    }

    public void setLabels(List<Object> labels) {
        this.labels = labels;
    }

    public List<Object> getLinkedSections() {
        return linkedSections;
    }

    public void setLinkedSections(List<Object> linkedSections) {
        this.linkedSections = linkedSections;
    }

    public List<Object> getLinkedSubTopics() {
        return linkedSubTopics;
    }

    public void setLinkedSubTopics(List<Object> linkedSubTopics) {
        this.linkedSubTopics = linkedSubTopics;
    }

    public List<Object> getLinkedTopics() {
        return linkedTopics;
    }

    public void setLinkedTopics(List<Object> linkedTopics) {
        this.linkedTopics = linkedTopics;
    }

    public MainArt getMainArt() {
        return mainArt;
    }

    public void setMainArt(MainArt mainArt) {
        this.mainArt = mainArt;
    }

    public Integer getNativeAd() {
        return nativeAd;
    }

    public void setNativeAd(Integer nativeAd) {
        this.nativeAd = nativeAd;
    }

    public String getNewsKeywords() {
        return newsKeywords;
    }

    public void setNewsKeywords(String newsKeywords) {
        this.newsKeywords = newsKeywords;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public Integer getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Integer publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Integer getRevisionTimestamp() {
        return revisionTimestamp;
    }

    public void setRevisionTimestamp(Integer revisionTimestamp) {
        this.revisionTimestamp = revisionTimestamp;
    }

    public Integer getSearchEnabled() {
        return searchEnabled;
    }

    public void setSearchEnabled(Integer searchEnabled) {
        this.searchEnabled = searchEnabled;
    }

    public List<String> getSection() {
        return section;
    }

    public void setSection(List<String> section) {
        this.section = section;
    }

    public String getSeoHeadline() {
        return seoHeadline;
    }

    public void setSeoHeadline(String seoHeadline) {
        this.seoHeadline = seoHeadline;
    }

    public String getSeoSlug() {
        return seoSlug;
    }

    public void setSeoSlug(String seoSlug) {
        this.seoSlug = seoSlug;
    }

    public Integer getShowOnCover() {
        return showOnCover;
    }

    public void setShowOnCover(Integer showOnCover) {
        this.showOnCover = showOnCover;
    }

    public String getSocialMediaHeadline() {
        return socialMediaHeadline;
    }

    public void setSocialMediaHeadline(String socialMediaHeadline) {
        this.socialMediaHeadline = socialMediaHeadline;
    }

    public List<Object> getSource() {
        return source;
    }

    public void setSource(List<Object> source) {
        this.source = source;
    }

    public String getSourceSiteName() {
        return sourceSiteName;
    }

    public void setSourceSiteName(String sourceSiteName) {
        this.sourceSiteName = sourceSiteName;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getSponsorLabel() {
        return sponsorLabel;
    }

    public void setSponsorLabel(String sponsorLabel) {
        this.sponsorLabel = sponsorLabel;
    }

    public Integer getStandoutArticle() {
        return standoutArticle;
    }

    public void setStandoutArticle(Integer standoutArticle) {
        this.standoutArticle = standoutArticle;
    }

    public List<Object> getStoryline() {
        return storyline;
    }

    public void setStoryline(List<Object> storyline) {
        this.storyline = storyline;
    }

    public List<Object> getSubTopic() {
        return subTopic;
    }

    public void setSubTopic(List<Object> subTopic) {
        this.subTopic = subTopic;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Object getTeaseImage() {
        return teaseImage;
    }

    public void setTeaseImage(Object teaseImage) {
        this.teaseImage = teaseImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getTopic() {
        return topic;
    }

    public void setTopic(List<String> topic) {
        this.topic = topic;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVideoArtUrl() {
        return videoArtUrl;
    }

    public void setVideoArtUrl(String videoArtUrl) {
        this.videoArtUrl = videoArtUrl;
    }
}