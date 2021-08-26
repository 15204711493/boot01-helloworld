package com.atguigu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
public class FormController {

    @GetMapping("/form_layouts")
    public String formLayouts() {
        return "form/form_layouts";
    }


    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestParam("headerImg") MultipartFile headerImg,
                         @RequestParam("photos") MultipartFile[] photos, HttpServletRequest request) throws IOException {

        if (!StringUtils.isEmpty(headerImg)) {
            String path = ResourceUtils.getURL("classpath:/static/file/").getPath();
            String filename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File(path+ filename));
        }

        if (photos.length > 0) {
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()) {
                    String path = ResourceUtils.getURL("classpath:/static/file/").getPath();
                    String filename = photo.getOriginalFilename();
                    photo.transferTo(new File(path + filename));
                }
            }
        }

        return "main";
    }

    @GetMapping("/s")
    @ResponseBody
    public String path() throws FileNotFoundException {
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();

        return  path;
    }
}
