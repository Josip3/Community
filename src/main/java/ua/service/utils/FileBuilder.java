package ua.service.utils;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileBuilder {
    private static final Logger logger = Logger.getLogger(FileBuilder.class);


    //    @Value("${base.path.file}")
    private String basePathFile = "/resources/img";

    //    @Value("${base.path.file.name}")
    private String nameFilePath = "/resources/img";

    /**
     * @param multipartFile
     * @return base path photo
     */

    public String saveFile(MultipartFile multipartFile) {

        String path = "";
        try {
            String uuid = UUID.randomUUID().toString();
            path = nameFilePath + "/" + uuid + "." + getFileTeg(multipartFile.getOriginalFilename());
            File file = new File(System.getProperty("catalina.home") + "" + basePathFile + "/" + uuid + "." + getFileTeg(multipartFile.getOriginalFilename()));
            path = System.getProperty("catalina.home") + "" + basePathFile + "/" + uuid + "." + getFileTeg(multipartFile.getOriginalFilename());
            file.getParentFile().mkdirs();//!correct
            if (!file.exists()) {
                multipartFile.transferTo(file);
                logger.info("----path[" + System.getProperty("catalina.home") + path + "]-------create------------");
            } else {

                logger.info("----path[" + System.getProperty("catalina.home") + path + "]-------not create------------");
            }
            loggerInfo(multipartFile.getOriginalFilename(), "create file->");
        } catch (IOException e) {
            loggerError(e, "------------path{" + System.getProperty("catalina.home") + path + "}-------------------------error file-------------------------------------");
        }
        return path;
    }

    public String getFileTeg(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    private void loggerError(Object e, String message) {
        logger.info(message);
        logger.error(e);
    }

    private void loggerInfo(String object, String info) {
        logger.info("-------------------------------------" + info + " [" + object + "]-------------------------------------");
    }

}