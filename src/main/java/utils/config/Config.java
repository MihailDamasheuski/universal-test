package utils.config;

public class Config {

    private String adapterUrl;

    private int adapterPort;

    private String adapterUser;

    private String adapterPassword;

    private String adapterIngestEndpoint;

    public String getAdapterUrl() {
        return adapterUrl;
    }

    public void setAdapterUrl(String adapterUrl) {
        this.adapterUrl = adapterUrl;
    }

    public int getAdapterPort() {
        return adapterPort;
    }

    public void setAdapterPort(int adapterPort) {
        this.adapterPort = adapterPort;
    }

    public String getAdapterUser() {
        return adapterUser;
    }

    public void setAdapterUser(String adapterUser) {
        this.adapterUser = adapterUser;
    }

    public String getAdapterPassword() {
        return adapterPassword;
    }

    public void setAdapterPassword(String adapterPassword) {
        this.adapterPassword = adapterPassword;
    }

    public String getAdapterIngestEndpoint() {
        return adapterIngestEndpoint;
    }

    public void setAdapterIngestEndpoint(String adapterIngestUrl) {
        this.adapterIngestEndpoint = adapterIngestUrl;
    }

}
