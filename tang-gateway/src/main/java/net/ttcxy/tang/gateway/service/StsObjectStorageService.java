package net.ttcxy.tang.gateway.service;

import java.io.File;

/**
 * 对象存储
 * @author huanglei
 */
public interface StsObjectStorageService {

    /**
     * 存储文件
     * @param path 存储路径
     * @param files 文件集合
     * @return 是否存储成功
     */
    boolean addFile(String path, File... files);

}
