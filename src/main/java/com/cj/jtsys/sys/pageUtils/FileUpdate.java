package com.cj.jtsys.sys.pageUtils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUpdate {
    /**
     * 获取用户文件信息，包含文件名称
     * 2指定文件上传路径
     * @param fileImage
     * @return
     */
    @RequestMapping("/file")
    public String file(MultipartFile fileImage) throws IOException {
//        获取input里面的name名称，相当于拿到key
        String file= fileImage.getName();
        System.out.println("1"+file);
        //获取文件名称
        String fileName=fileImage.getOriginalFilename() ;
        //存储路径
        File fileDir=new File("D/1-jt/image");

        if(!fileDir.exists()){
            fileDir.mkdir();
        }
        fileImage.transferTo( new File(fileDir+fileName));
        //上传完又回到原来的上传页面
        return "redirect:/file.jsp";




    }

}
