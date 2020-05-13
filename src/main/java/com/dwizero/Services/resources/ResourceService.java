package com.dwizero.Services.resources;

import com.dwizero.Config.PropertyLoad;
import org.apache.commons.io.FileUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
@Service
public class ResourceService
{
    private Logger logger = LoggerFactory.getLogger(ResourceService.class);
    @Autowired
    private PropertyLoad propertyLoad;

    public void fileUpload(HttpServletRequest request) throws IOException
    {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        String fileName;
        byte[] bytes;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                fileName = propertyLoad.getBaseFilePath() + file.getOriginalFilename();
                try {
                    bytes = file.getBytes();
                    FileUtils.writeByteArrayToFile(new File(fileName),bytes);
                } catch (IOException e) {
                    logger.error(e.getMessage());
                }
            }
        }
    }
}
