package com.zoolatech.loganalyzer.reader;

import org.springframework.beans.factory.config.AbstractFactoryBean;

public class CustomSysPropReaderFactory extends AbstractFactoryBean<Reader> {

    private final String sysPropReaderType = System.getProperty("reader.type");
//    private final String sysPropReaderType = "s3";
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

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
