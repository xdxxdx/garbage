package com.xdx.garbage.common.util;

import com.xdx.garbage.entity.TCarousel;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import sun.nio.ch.IOUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.springframework.util.ResourceUtils.getURL;

public class UploadUtil {
//    private final static String dist="D:\\nginx-1.10.2\\garbage\\upload";
    private final static String dist="//usr//local//attach//upload//";
    //home//weblogic//upload//

    public static String upload(HttpServletRequest req, MultipartFile upload,String path)  {
        Integer result = 0;
        String originalFileName = upload.getOriginalFilename();
        String suffix = getFileSuffix(originalFileName);
        String fileName = UUIDUtil.getKeys() + "." + suffix;
//        String xdx=ResourceUtils.getURL("classpath:").getPath();
//        String realPath = req.getServletContext().getRealPath(path);
        String fullPath = dist + "/"+path+"/" + fileName;
        File file = new File(fullPath);
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdir();
            }
            upload.transferTo(file);
            return  "/upload/" +path+"/"+ fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取文件的后缀名
     *
     * @param fileName
     * @return
     */
    public static String getFileSuffix(String fileName) {
        int index = fileName.lastIndexOf(".");
        String suffix = fileName.substring((index + 1),
                fileName.length());// 后缀名
        return suffix;
    }
}
