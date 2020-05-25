package com.DWiZero.Controller;

import com.DWiZero.Services.Resources.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/resource")
public class ResourceController
{
    @Autowired
    private ResourceService resourceService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public void upload(HttpServletRequest request) throws IOException
    {
        resourceService.fileUpload(request);
    }
}
