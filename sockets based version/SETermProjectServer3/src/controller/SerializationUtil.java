/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 *
 * @author George Wan
 */
public class SerializationUtil {
 
    /**
     * deserialize to Object from given file. We use the general Object so as
     * that it can work for any Java Class.
     * @param fileName
     * @return 
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        BufferedInputStream bis = new BufferedInputStream(fis);
        Object obj;
        try (ObjectInputStream ois = new ObjectInputStream(bis)) {
            obj = ois.readObject();
        }
        return obj;
    }
 
    /**
     * serialize the given object and save it to given file
     * @param obj
     * @param fileName
     * @throws java.io.IOException
     */
    public static void serialize(Object obj, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        try (ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(obj);
        }
    }
}
