package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.FileModel;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

@Service
public class HomeService {
    private final FileMapper fileMapper;
    private final NoteMapper noteMapper;


    private final CredentialMapper credentialMapper;

    private final HashService hashService;

    public HomeService(FileMapper fileMapper, NoteMapper noteMapper, CredentialMapper credentialMapper, HashService hashService) {
        this.fileMapper = fileMapper;
        this.noteMapper = noteMapper;
        this.credentialMapper = credentialMapper;
        this.hashService = hashService;
    }

    public List<String > GetListofFilesNames(){

        return fileMapper.getAllFileNames();
    }

    public List<FileModel > GetAllFiles(int userid){

        return fileMapper.getAllFiles(userid);
    }

    public int UploadFile(FileModel fileModel){
        return fileMapper.addFile(fileModel);
    }

    public boolean IsFileNameExist(String fileName){
        return !(fileMapper.getFile(fileName)==null);
    }

    public void Deletefile(String filename) {
        fileMapper.DeleteFile(filename);
    }

    public void UploadNote(Note note) {
        noteMapper.addNote(note);
    }

    public List<Note> GetAllNotes(int userid) {
        return noteMapper.getAllNotes(userid);
    }

    public void UpDateNote(Note note) {
        noteMapper.updateNote(note);
    }

    public void DeleteNote(int noteid) {
        noteMapper.deleteNote(noteid);
    }

    public void UpDateCredential(Credential credential) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.getHashedValue(credential.getPassword(), encodedSalt);
        credential.setEncryptedpassword(hashedPassword);
        credential.setKey(encodedSalt);
        credentialMapper.updateCredential(credential);

    }

    public void UploadCredential(Credential credential) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.getHashedValue(credential.getPassword(), encodedSalt);
        credential.setEncryptedpassword(hashedPassword);
        credential.setKey(encodedSalt);
        credentialMapper.addCredential(credential);
    }

    public List<Credential> GetAllCredentials(int userid) {
        return credentialMapper.getAllCredentials(userid);
    }

    public void DeleteCredential(int credentialid) {
        credentialMapper.deleteCredential(credentialid);
    }


}
