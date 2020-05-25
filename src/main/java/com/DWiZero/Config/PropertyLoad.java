package com.DWiZero.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertyLoad
{
    @Value("${def.filePath}")
    private String BaseFilePath;

    public String getBaseFilePath()
    {
        return BaseFilePath;
    }

    public void setBaseFilePath(String baseFilePath)
    {
        BaseFilePath = baseFilePath;
    }
}
