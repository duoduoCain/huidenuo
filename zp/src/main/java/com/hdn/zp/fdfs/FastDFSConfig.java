package com.hdn.zp.fdfs;

import org.csource.fastdfs.ClientGlobal;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * Created by 多多啦 on 2020/3/16 0016.
 * 时间飞逝
 * time goes by
 * 時間が飛ぶ
 */

@ConfigurationProperties(prefix = "fastdfs")
@Component
public class FastDFSConfig {
    private String trackerServers;
    private String connectTimeoutInSeconds;
    private String networkTimeoutInSeconds;
    private String charset;
    private String httpAntiStealToken;
    private String httpSecretKey;
    private String httpTrackerHttpPort;
    private String nginxHttpRoot;

    public Properties toProperties() {
        Properties props = new Properties();
        props.setProperty(ClientGlobal.PROP_KEY_TRACKER_SERVERS, trackerServers);
        props.setProperty(ClientGlobal.PROP_KEY_CONNECT_TIMEOUT_IN_SECONDS, connectTimeoutInSeconds);
        props.setProperty(ClientGlobal.PROP_KEY_NETWORK_TIMEOUT_IN_SECONDS, networkTimeoutInSeconds);
        props.setProperty(ClientGlobal.PROP_KEY_CHARSET, charset);
        props.setProperty(ClientGlobal.PROP_KEY_HTTP_ANTI_STEAL_TOKEN, httpAntiStealToken);
        props.setProperty(ClientGlobal.PROP_KEY_HTTP_SECRET_KEY, httpSecretKey);
        props.setProperty(ClientGlobal.PROP_KEY_HTTP_TRACKER_HTTP_PORT, httpTrackerHttpPort);
        return props;
    }

    public String getTrackerServers() {
        return trackerServers;
    }

    public void setTrackerServers(String trackerServers) {
        this.trackerServers = trackerServers;
    }

    public String getConnectTimeoutInSeconds() {
        return connectTimeoutInSeconds;
    }

    public void setConnectTimeoutInSeconds(String connectTimeoutInSeconds) {
        this.connectTimeoutInSeconds = connectTimeoutInSeconds;
    }

    public String getNetworkTimeoutInSeconds() {
        return networkTimeoutInSeconds;
    }

    public void setNetworkTimeoutInSeconds(String networkTimeoutInSeconds) {
        this.networkTimeoutInSeconds = networkTimeoutInSeconds;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getHttpAntiStealToken() {
        return httpAntiStealToken;
    }

    public void setHttpAntiStealToken(String httpAntiStealToken) {
        this.httpAntiStealToken = httpAntiStealToken;
    }

    public String getHttpSecretKey() {
        return httpSecretKey;
    }

    public void setHttpSecretKey(String httpSecretKey) {
        this.httpSecretKey = httpSecretKey;
    }

    public String getHttpTrackerHttpPort() {
        return httpTrackerHttpPort;
    }

    public void setHttpTrackerHttpPort(String httpTrackerHttpPort) {
        this.httpTrackerHttpPort = httpTrackerHttpPort;
    }

    public String getNginxHttpRoot() {
        return nginxHttpRoot;
    }

    public void setNginxHttpRoot(String nginxHttpRoot) {
        this.nginxHttpRoot = nginxHttpRoot;
    }

}
