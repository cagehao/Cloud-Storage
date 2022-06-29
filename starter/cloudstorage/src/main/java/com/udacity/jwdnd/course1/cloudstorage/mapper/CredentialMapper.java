package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import org.apache.ibatis.annotations.*;

import java.util.List;
//    credentialid INT PRIMARY KEY auto_increment,
//    url VARCHAR(100),
//    username VARCHAR (30),
//    key VARCHAR,
//    password VARCHAR,
//    userid INT,
//    foreign key (userid) references USERS(userid)

//private int credentialid;
//private String url;
//private String username;
//private String key;
//private String password;
//private int userId;
@Mapper
public interface CredentialMapper {


    @Select("SELECT * FROM CREDENTIALS WHERE userId = #{userid}")
    List<Credential> getAllCredentials(int userid);

    @Insert("INSERT INTO CREDENTIALS ( url, username, key, password,encryptedpassword ,userid) " +
            "VALUES( #{url},#{username},#{key},#{password},#{encryptedpassword},#{userid})")
    @Options(useGeneratedKeys = true, keyProperty = "credentialid")
    int addCredential(Credential credential);

    @Update("UPDATE CREDENTIALS SET url = #{url}, username = #{username}, password = #{password} WHERE credentialid = #{credentialid}")
    void updateCredential(Credential credential);


    @Delete("DELETE FROM CREDENTIALS WHERE credentialid = #{credentialid}")
    void deleteCredential(int credentialid);
}
