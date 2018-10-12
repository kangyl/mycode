package com.kangyl.test.seriable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * <p> Description:
 * <p>
 *
 * @author 康玉琳 (460720197@qq.com)
 * @since 2018年09月30日
 */
public class SerialObj implements Serializable {

    private static final long serialVersionUID = 8366355323754913889L;


    private String name;

    private String addr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }


    private final void readObject(ObjectInputStream in) throws java.io.IOException {
        throw new java.io.IOException("Cannot be deserialized");
    }

    private final void writeObject(ObjectOutputStream outputStream)throws IOException{
        throw new java.io.IOException("Cannot be serialized");
    }

}
