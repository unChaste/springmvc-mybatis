package com.ay.controller;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

@Controller
public class FileUploadController {
    private static Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @GetMapping("/uploadForm")
    public String uploadForm(HttpServletRequest request, Model model) {
        String path = request.getServletContext().getRealPath("/images");
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }
        ArrayList<String> fileNameList = new ArrayList<>();
        for (File file : dir.listFiles()) {
            fileNameList.add(file.getName());
        }
        model.addAttribute("fileNameList", fileNameList);
        return "uploadForm";
    }

    @PostMapping("/upload")
    public String upload(HttpServletRequest request,
                         @RequestParam("description") String description,
                         @RequestParam("file") MultipartFile file,
                         RedirectAttributes redirectAttributes) {
        System.out.println(description);

        if (!file.isEmpty()) {
            String path = request.getServletContext().getRealPath("/images");
            String fileName = file.getOriginalFilename();
            File filePath = new File(path, fileName);
            if (!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdir();
            }
            try {
                file.transferTo(new File(path + File.separator + fileName));
                logger.debug("上传文件路径：" + path + File.separator + fileName);
                redirectAttributes.addFlashAttribute("message", "上传文件成功");
            } catch (IOException e) {
                e.printStackTrace();
                redirectAttributes.addFlashAttribute("message", "上传文件失败");
            }
        } else {
            redirectAttributes.addFlashAttribute("message", "上传文件为空");
        }
        return "redirect:uploadForm";
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,
                                           @RequestParam("filename") String filename,
                                           @RequestHeader("User-Agent") String userAgent) throws IOException {
        String path = request.getServletContext().getRealPath("/images");
        File file = new File(path + File.separator + filename);

        ResponseEntity.BodyBuilder builder = ResponseEntity.ok();

        builder.contentLength(file.length());
        builder.contentType(MediaType.APPLICATION_OCTET_STREAM);

        filename = URLEncoder.encode(filename, "UTF-8").replace('+', ' ');

        builder.header("Content-Disposition", "attachment;filename=" + filename);
//        if (false && userAgent.contains("MSIE")) {
//        } else {
//            builder.header("Content-Disposition", "attachment;filename*=UTF-8''" + filename);
//        }
        return builder.body(FileUtils.readFileToByteArray(file));
    }
}
