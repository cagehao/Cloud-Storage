package com.udacity.jwdnd.course1.cloudstorage.model;

public class Credential {
//    credentialid INT PRIMARY KEY auto_increment,
//    url VARCHAR(100),
//    username VARCHAR (30),
//    key VARCHAR,
//    password VARCHAR,
//    userid INT,
//    foreign key (userid) references USERS(userid)

    private int credentialid;
    private String url;
    private String username;
    private String key;

    private String encryptedpassword;
    private String password;
    private int userid;



    public void setUserid(int userId) {
        this.userid = userId;
    }

    public int getUserid() {
        return userid;
    }

    public void setCredentialid(int credentialid) {
        this.credentialid = credentialid;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKey() {
        return key;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public int getCredentialid() {
        return credentialid;
    }

    public void setEncryptedpassword(String encryptedpassword) {
        this.encryptedpassword = encryptedpassword;
    }

    public String getEncryptedpassword() {
        return encryptedpassword;
    }
}
