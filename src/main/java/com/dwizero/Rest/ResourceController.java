package com.dwizero.Rest;

import com.dwizero.Services.resources.ResourceService;
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

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public void upload(HttpServletRequest request) throws IOException
    {
        resourceService.fileUpload(request);
    }
}
