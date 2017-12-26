package ua.request.dto;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class Base64MultipartFile implements MultipartFile {


    private byte []fileContent;

    private String fileName;


    public Base64MultipartFile(byte[] fileContent, String fileName) {
        this.fileContent = fileContent;
        this.fileName = fileName;
    }


    @Override
    public String getName() {
        return fileName.split(".")[0];
    }

    @Override
    public String getOriginalFilename() {
        return fileName;
    }

    @Override
    public String getContentType() {
        return fileName.split(".")[1];
    }

    @Override
    public boolean isEmpty() {
        return fileContent.length == 0;
    }

    @Override
    public long getSize() {
        return fileContent.length;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return fileContent;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(fileContent);
    }

    @Override
    public void transferTo(File file) throws IOException, IllegalStateException {
        new FileOutputStream(file).write(fileContent);
    }
}
