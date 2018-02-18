package com.dwizero.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertyLoad
{
    @Value("${def.filePath}")
    public String BaseFilePath;

    private String getBaseFilePath()
    {
        return BaseFilePath;
    }

    private void setBaseFilePath(String baseFilePath)
    {
        BaseFilePath = baseFilePath;
    }
}
