package net.ttcxy.tang.gateway.entity.model;

import java.io.Serializable;

public class UtsFile implements Serializable {
    private Integer fileId;

    private String fileName;

    private String fileType;

    private String filePath;

    private String fileDate;

    private String fileIco;

    private String fileSize;

    private Integer fileParentId;

    private static final long serialVersionUID = 1L;

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileDate() {
        return fileDate;
    }

    public void setFileDate(String fileDate) {
        this.fileDate = fileDate;
    }

    public String getFileIco() {
        return fileIco;
    }

    public void setFileIco(String fileIco) {
        this.fileIco = fileIco;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public Integer getFileParentId() {
        return fileParentId;
    }

    public void setFileParentId(Integer fileParentId) {
        this.fileParentId = fileParentId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fileId=").append(fileId);
        sb.append(", fileName=").append(fileName);
        sb.append(", fileType=").append(fileType);
        sb.append(", filePath=").append(filePath);
        sb.append(", fileDate=").append(fileDate);
        sb.append(", fileIco=").append(fileIco);
        sb.append(", fileSize=").append(fileSize);
        sb.append(", fileParentId=").append(fileParentId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}