package com.bank.aplikacja_bankowa;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public abstract class SerializeFunctions {
    public static void serializeObjectToFile(Serializable serializable,String path)throws IOException{
        final FileOutputStream outputStream = new FileOutputStream(path);
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(serializable);
        objectOutputStream.close();
        outputStream.write(Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray()).getBytes(StandardCharsets.UTF_8));
        outputStream.close();
    }
}
