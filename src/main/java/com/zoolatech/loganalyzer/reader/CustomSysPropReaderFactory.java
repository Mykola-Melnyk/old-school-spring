package com.zoolatech.loganalyzer.reader;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


public class CustomSysPropReaderFactory extends AbstractFactoryBean<Reader> {

    @Value("${reader.type}")
    private String sysPropReaderType;

    @Value("${file.name}")
    private String fileName;

    @Override
    public Class<?> getObjectType() {
        return Reader.class;
    }

    @Override
    protected Reader createInstance() throws Exception {
        switch (sysPropReaderType) {
            case "s3": {
                return new S3Reader(fileName);
            }
            case "file": {
                return new FileReader(fileName);
            }
            case "stub": {
                return new StubReader();
            }
            default: {
                throw new IllegalArgumentException("Unknown Reader type: " + sysPropReaderType);
            }
        }

    }

}
