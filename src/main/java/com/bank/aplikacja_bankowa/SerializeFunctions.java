package com.bank.aplikacja_bankowa;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    public static Object deSerializeObjectFromFile(String pathFile) throws IOException, ClassNotFoundException {
        final String file = Files.readAllLines(Paths.get(pathFile)).get(0);
        byte[] data = Base64.getDecoder().decode(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(new
                ByteArrayInputStream(data));
        Object object = objectInputStream.readObject();
        objectInputStream.close();
        return object;
    }
    public static void serializePerson(Person person,String username,String password) throws IOException{
        SerializeFunctions.serializeObjectToFile(person,"src/main/resources/data/u"+Main.userFileNameTab.userCounter.toString()+".data");
        Main.userFileNameTab.userFileName.put(username,"u"+Main.userFileNameTab.userCounter);
        Main.userFileNameTab.userLoginData.put(username,password);
        Main.userFileNameTab.userCounter++;
        SerializeFunctions.serializeObjectToFile(Main.userFileNameTab,"src/main/resources/data/loginData.data");

    }
}
