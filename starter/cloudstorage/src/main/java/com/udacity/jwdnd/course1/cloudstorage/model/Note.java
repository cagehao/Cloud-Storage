package com.udacity.jwdnd.course1.cloudstorage.model;

public class Note {
//    noteid INT PRIMARY KEY auto_increment,
//    notetitle VARCHAR(20),
//    notedescription VARCHAR (1000),
//    userid INT,
//    foreign key (userid) references USERS(userid)
    private int noteid = -1;
    private String noteTitle;
    private String noteDescription;
    private int userid;

    public void setUserid(int userId) {
        this.userid = userId;
    }

    public void setNoteDescription(String noteDescription) {
        this.noteDescription = noteDescription;
    }

    public void setNoteid(int noteid) {
        this.noteid = noteid;
    }

    public void setNoteTitle(String notetitle) {
        this.noteTitle = notetitle;
    }

    public int getUserid() {
        return userid;
    }

    public int getNoteid() {
        return noteid;
    }



    public String getNoteDescription() {
        return noteDescription;
    }

    public String getNoteTitle() {
        return noteTitle;
    }
}
