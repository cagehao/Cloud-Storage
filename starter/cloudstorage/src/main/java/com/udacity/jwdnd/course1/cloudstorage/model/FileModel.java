package com.udacity.jwdnd.course1.cloudstorage.model;

import java.sql.Blob;

public class FileModel {
//    fileId INT PRIMARY KEY auto_increment,
//    filename VARCHAR,
//    contenttype VARCHAR,
//    filesize VARCHAR,
//    userid INT,
//    filedata BLOB,
//    foreign key (userid) references USERS(userid)
    private int fileId;
    private String filename;
    private String contenttype;
    private String filesize;
    private int userid;
    private Blob filedata;

    public void setFileName(String fileName) {
        this.filename = fileName;
    }

    public void setContentType(String contentType) {
        this.contenttype = contentType;
    }

    public void setFileSize(String fileSize) {
        this.filesize = fileSize;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public void setUserId(int userId) {
        this.userid = userId;
    }

    public void setFiledata(Blob filedata) {
        this.filedata = filedata;
    }

    public Blob getFiledata() {
        return filedata;
    }

    public int getFileId() {
        return fileId;
    }

    public int getUserId() {
        return userid;
    }

    public String getContentType() {
        return contenttype;
    }

    public String getFileName() {
        return filename;
    }

    public String getFileSize() {
        return filesize;
    }
}
