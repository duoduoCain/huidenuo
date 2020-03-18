package com.hdn.zp.fdfs;

import lombok.extern.slf4j.Slf4j;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedOutputStream;

/**
 * Created by 多多啦 on 2020/3/16 0016.
 * 时间飞逝
 * time goes by
 * 時間が飛ぶ
 */

@Slf4j
@Component
public class FastDFSUtils {
    @Autowired
    private FastDFSConfig fastDFSConfig;
    @Autowired
    private FastDFSClient fastDFSClient;

    /**
     * 获取文件的http地址url
     */
    public String getHttpUrl(String dfsPath) {
        return fastDFSConfig.getNginxHttpRoot() + "/" + dfsPath;
    }

    /**
     * 上传文件方法
     *
     * @param fileName 文件全路径
     * @param extName  文件扩展名，不包含（.）
     * @param metas    文件扩展信息
     */
    public String uploadFile(String fileName, String extName, NameValuePair[] metas) {
        String result = null;
        try {
            result = fastDFSClient.getStorageClient().upload_file1(fileName, extName, metas);
        } catch (Exception e) {
            log.error("FastDFS Exception: " + e);
        }
        return result;
    }

    /**
     * 上传文件,传fileName
     *
     * @param fileName 文件的磁盘路径名称 如：D:/image/aaa.jpg
     * @return null为失败
     */
    public String uploadFile(String fileName) {
        return uploadFile(fileName, null, null);
    }

    /**
     *
     * @param fileName 文件的磁盘路径名称 如：D:/image/aaa.jpg
     * @param extName  文件的扩展名 如 txt jpg等
     * @return null为失败
     */
    public String uploadFile(String fileName, String extName) {
        return uploadFile(fileName, extName, null);
    }

    /**
     * 上传文件方法
     *
     * @param fileContent 文件的内容，字节数组
     * @param extName     文件扩展名
     * @param metas       文件扩展信息
     */
    public String uploadFile(byte[] fileContent, String extName, NameValuePair[] metas) {
        String result = null;
        try {
            result = fastDFSClient.getStorageClient().upload_file1(fileContent, extName, metas);
        } catch (Exception e) {
            log.error("FastDFS Exception: " + e);
        }
        return result;
    }

    /**
     * 上传文件
     *
     * @param fileContent 文件的字节数组
     * @return null为失败 @
     */
    public String uploadFile(byte[] fileContent) {
        return uploadFile(fileContent, null, null);
    }

    /**
     * 上传文件
     *
     * @param fileContent 文件的字节数组
     * @param extName     文件的扩展名 如 txt jpg png 等
     * @return null为失败
     */
    public String uploadFile(byte[] fileContent, String extName) {
        return uploadFile(fileContent, extName, null);
    }

    /**
     * 文件下载到磁盘
     *
     * @param path   图片路径
     * @param output 输出流 中包含要输出到磁盘的路径
     * @return -1失败,0成功
     */
    public int download_file(String path, BufferedOutputStream output) {
        int result = -1;
        try {
            byte[] b = fastDFSClient.getStorageClient().download_file1(path);
            try {
                if (b != null) {
                    output.write(b);
                    result = 0;
                }
            } catch (Exception e) {
            } // 用户可能取消了下载
            finally {
                if (output != null) {
                    try {
                        output.close();
                    } catch (Exception e) {
                        log.error("FastDFS Exception: " + e);
                    }
                }
            }
        } catch (Exception e) {
            log.error("FastDFS Exception: " + e);
        }
        return result;
    }

    /**
     * 获取文件数组
     *
     * @param path 文件的路径 如group1/M00/00/00/wKgRsVjtwpSAXGwkAAAweEAzRjw471.jpg
     */
    public byte[] download_bytes(String path) {
        byte[] b = null;
        try {
            b = fastDFSClient.getStorageClient().download_file1(path);
        } catch (Exception e) {
            log.error("FastDFS Exception: " + e);
        }
        return b;
    }

    /**
     * 删除文件
     *
     * @param group       组名 如：group1
     * @param storagePath 不带组名的路径名称 如：M00/00/00/wKgRsVjtwpSAXGwkAAAweEAzRjw471.jpg
     * @return -1失败,0成功
     */
    public Integer delete_file(String group, String storagePath) {
        int result = -1;
        try {
            result = fastDFSClient.getStorageClient().delete_file(group, storagePath);
        } catch (Exception e) {
            log.error("FastDFS Exception: " + e);
        }
        return result;
    }

    /**
     *
     * @param storagePath 如：group1/M00/00/00/wKgRsVjtwpSAXGwkAAAweEAzRjw471.jpg
     * @return -1失败,0成功
     */
    public Integer delete_file(String storagePath) {
        int result = -1;
        try {
            result = fastDFSClient.getStorageClient().delete_file1(storagePath);
        } catch (Exception e) {
            log.error("FastDFS Exception: " + e);
        }
        return result;
    }

    /**
     * 获取远程服务器文件资源信息
     *
     * @param groupName      文件组名 如：group1
     * @param remoteFileName M00/00/00/wKgRsVjtwpSAXGwkAAAweEAzRjw471.jpg
     */
    public FileInfo getFile(String groupName, String remoteFileName) {
        try {
            return fastDFSClient.getStorageClient().get_file_info(groupName, remoteFileName);
        } catch (Exception e) {
            log.error("FastDFS Exception: " + e);
        }
        return null;
    }

    /**
     * 获取远程服务器文件资源信息
     *
     * @param  如:group1/M00/00/00/wKgRsVjtwpSAXGwkAAAweEAzRjw471.jpg
     */
    public FileInfo getFile(String dfsPath) {
        try {
            return fastDFSClient.getStorageClient().get_file_info1(dfsPath);
        } catch (Exception e) {
            log.error("FastDFS Exception: " + e);
        }
        return null;
    }
}
