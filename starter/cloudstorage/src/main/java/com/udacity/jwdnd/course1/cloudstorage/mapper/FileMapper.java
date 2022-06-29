package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.FileModel;
import org.apache.ibatis.annotations.*;

import java.util.List;
//private int fileId;
//private String fileName;
//private String contentType;
//private String fileSize;
//private int userId;
//private Blob filedata;
@Mapper
public interface FileMapper {
    @Select("SELECT * FROM FILES WHERE userId = #{userid}")
    List<FileModel> getAllFiles(int userid);

    @Select("SELECT filename FROM FILES")
    List<String> getAllFileNames();

    @Select("SELECT fileName FROM FILES WHERE fileName = #{filename}")
    String getFile(String filename);

    @Insert("INSERT INTO FILES (filename, contenttype, filesize, userid) " +
            "VALUES(#{filename},#{contentType},#{fileSize},#{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    int addFile(FileModel fileModel);

    @Delete("DELETE FROM FILES WHERE fileName = #{filename}")
    void DeleteFile(String filename);
}
