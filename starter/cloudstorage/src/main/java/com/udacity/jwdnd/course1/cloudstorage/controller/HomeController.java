package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.services.HomeService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.udacity.jwdnd.course1.cloudstorage.model.FileModel;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller

public class HomeController {
    private File projectDirectory = new File("");
    private final String filepath = projectDirectory.getAbsolutePath()+"/files/";

    private UserService userService;
    private HomeService homeService;



    private int userid;


    public HomeController(UserService userService, HomeService homeService) {
        this.homeService = homeService;
        this.userService = userService;


    }

    @RequestMapping("/home")
    public String homeview(Authentication authentication, Model model,  Note note) {
        userid = userService.getUser(authentication.getName()).getUserId();
        model.addAttribute("fileModels",this.homeService.GetAllFiles(userid));
        model.addAttribute("Notes", this.homeService.GetAllNotes(userid));
        model.addAttribute("credentials",this.homeService.GetAllCredentials(userid));
        System.out.println(homeService.GetListofFilesNames().isEmpty());
        return "home";
    }

    @RequestMapping("/uploadfile")
    public String uploaddata(Authentication authentication, MultipartFile fileUpload, FileModel fileModel, Model model, final RedirectAttributes attributes) throws IOException {
        String upLoadFileName = fileUpload.getOriginalFilename();
        if (fileUpload.isEmpty()){
            model.addAttribute("filetip","File not selected");
            model.addAttribute("fileModels",this.homeService.GetAllFiles(userid));
            return "redirect:/home";
        } else if (homeService.IsFileNameExist(upLoadFileName)) {
            model.addAttribute("filetip","Filename already existed");
            model.addAttribute("fileModels",this.homeService.GetAllFiles(userid));
            return "redirect:/home";

        }


        fileModel.setFileName(fileUpload.getOriginalFilename());
        fileModel.setContentType(fileUpload.getContentType());
        fileModel.setFileSize(String.valueOf(fileUpload.getSize())+"bytes");
        fileModel.setUserId(userService.getUser(authentication.getName()).getUserId());
        homeService.UploadFile(fileModel);
        fileUpload.transferTo(new File(filepath+fileUpload.getOriginalFilename()));

        attributes.addFlashAttribute("uploadSuccess", true);
        attributes.addFlashAttribute("uploadItem", "File Upload success!");



        System.out.println("success");
        model.addAttribute("fileModels",this.homeService.GetAllFiles(userid));
        return "redirect:/home";
    }

    @GetMapping("/delete/{filename}")
    public String DeleteFile(@PathVariable("filename") String filename, Model model,  final RedirectAttributes attributes){
        homeService.Deletefile(filename);
        File file = new File(filepath+filename);
        if (file.exists()) {
            file.delete();
            System.out.println("===========deleteSuccess=================");
            attributes.addFlashAttribute("uploadSuccess", true);
            attributes.addFlashAttribute("uploadItem", "File Delete success!");

        } else {
            System.out.println("===============deleteFailed==============");

        }



        model.addAttribute("fileModels",this.homeService.GetAllFiles(userid));
        return "redirect:/home";

    }

    @GetMapping("/download/{filename}")
    public String DownloadFile(@PathVariable("filename") String filename, Model model, HttpServletResponse response) {

        File file = new File(filepath + filename);
        if (!file.exists()) {
            model.addAttribute("fileModels", this.homeService.GetAllFiles(userid));

            System.out.println("===========DownloadFailed=================");
            return "redirect:/home";
        }
        response.reset();
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment;filename=" + filename);
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));) {
            byte[] buff = new byte[1024];
            OutputStream os = response.getOutputStream();
            int i = 0;
            while ((i = bis.read(buff)) != -1) {
                os.write(buff, 0, i);
                os.flush();
            }
        } catch (IOException e) {
            System.out.println("===========DownloadFailed=================");
            System.out.println(e.toString());

        }
        //model.addAttribute("fileModels", this.homeService.GetAllFiles());
        return "redirect:/home";
    }

    @RequestMapping("/uploadNote")
    public String UploadNote(Authentication authentication, Model model, Note note, @ModelAttribute("noteId") String noteId,  final RedirectAttributes attributes){
        System.out.println(noteId);



        if (!noteId.isEmpty()){

            note.setNoteid(Integer.valueOf(noteId).intValue());
            homeService.UpDateNote(note);
            attributes.addFlashAttribute("uploadSuccess", true);
            attributes.addFlashAttribute("uploadItem", "Note Edit success!");

        }else{
            note.setUserid(userService.getUser(authentication.getName()).getUserId());
            homeService.UploadNote(note);
            attributes.addFlashAttribute("uploadSuccess", true);
            attributes.addFlashAttribute("uploadItem", "Note Upload success!");
        }

        model.addAttribute("Notes",this.homeService.GetAllNotes(userid));
        return "redirect:/home";

    }

    @GetMapping("/deleteNote/{noteid}")
    public String DeleteNode(@PathVariable("noteid") int noteid, Model model,  final RedirectAttributes attributes){
        homeService.DeleteNote(noteid);
        model.addAttribute("Notes",this.homeService.GetAllNotes(userid));
        attributes.addFlashAttribute("uploadSuccess", true);
        attributes.addFlashAttribute("uploadItem", "Note Delete success!");
        return "redirect:/home";

    }

    @RequestMapping("/uploadCredential")
    public String UploadCredential(Authentication authentication, Model model, Credential credential, @ModelAttribute("credentialId") String credentialid,  final RedirectAttributes attributes){



        if (!credentialid.isEmpty()){

            credential.setCredentialid(Integer.valueOf(credentialid).intValue());

            homeService.UpDateCredential(credential);
            attributes.addFlashAttribute("uploadSuccess", true);
            attributes.addFlashAttribute("uploadItem", "Credential Edit success!");

        }else{
            credential.setUserid(userService.getUser(authentication.getName()).getUserId());
            attributes.addFlashAttribute("uploadSuccess", true);
            attributes.addFlashAttribute("uploadItem", "Credential Upload success!");
            homeService.UploadCredential(credential);
        }

        //model.addAttribute("credentials",this.homeService.GetAllCredentials());
        return "redirect:/home";

    }

    @GetMapping("/deleteCredential/{credentialid}")
    public String DeleteCredential(@PathVariable("credentialid") int credentialid, Model model,  final RedirectAttributes attributes){
        homeService.DeleteCredential(credentialid);
        //model.addAttribute("credentials",this.homeService.GetAllCredentials());
        attributes.addFlashAttribute("uploadSuccess", true);
        attributes.addFlashAttribute("uploadItem", "Credential Delete success!");
        return "redirect:/home";

    }





}
