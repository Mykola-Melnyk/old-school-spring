package com.zoolatech.loganalyzer.reader;

import org.springframework.beans.factory.config.AbstractFactoryBean;

public class ReaderFactory extends AbstractFactoryBean<Reader> {

    private String type;
    private String fileName;

    @Override
    public Class<?> getObjectType() {
        return Reader.class;
    }

    @Override
    protected Reader createInstance() throws Exception {
        if (type == null || type.isEmpty()) {
            return null;
        }
        switch (type) {
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
                throw new IllegalArgumentException("Unknown Reader type: " + type);
            }
        }

    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
