package com.hdn.zp.fdfs;
import java.io.IOException;
import java.util.Properties;

import lombok.extern.slf4j.Slf4j;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * Created by 多多啦 on 2020/3/16 0016.
 * 时间飞逝
 * time goes by
 * 時間が飛ぶ
 */

@Slf4j
@Component
public class FastDFSClient {
    private volatile boolean isInited = Boolean.FALSE;

    private TrackerClient trackerClient = null;
//	private TrackerServer trackerServer = null;
//	private StorageServer storageServer = null;
//	private StorageClient1 storageClient = null;

    @Autowired
    private FastDFSConfig fastDFSConfig;

    private synchronized void init() {
        if (isInited) {
            return;
        }
        try {
            Properties props = fastDFSConfig.toProperties();
            ClientGlobal.initByProperties(props);
            log.debug("Fastdfs ClientGlobal.configInfo(): " + ClientGlobal.configInfo());

            trackerClient = new TrackerClient();
//			TrackerServer trackerServer = trackerClient.getConnection();
//			StorageServer storageServer = null;
//			StorageClient1 storageClient = new StorageClient1(trackerServer, storageServer);

            isInited = Boolean.TRUE;
        } catch (Exception e) {
            log.error("init fastDFS fail:", e);
        }
    }

    public StorageClient1 getStorageClient() {
        if (trackerClient == null) {
            init();
        }
        try {
            TrackerServer trackerServer = trackerClient.getConnection();
//            trackerClient.get
            StorageServer storageServer = null;
            StorageClient1 storageClient = new StorageClient1(trackerServer, storageServer);
            return storageClient;
        } catch (IOException e) {
            log.error("fastDFS getStorageClient fail:", e);
            return null;
        }
    }

}