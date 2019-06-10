package com.whhx.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * @Author: jiangwei
 * @Date: 2019-06-03
 * @Desc:
 */
public class Marshal {
    public static String marshal(Object object) throws Exception {
        String returnValue = null;
        Class<?> clazz = null;
        JAXBContext context = null;
        Marshaller marshaller = null;
        StringWriter writer = null;
        try {
            clazz = object.getClass();
            writer = new StringWriter();
            context = JAXBContext.newInstance(clazz);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            marshaller.marshal(object, writer);
            returnValue = writer.toString();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (Exception e) {
                }
                writer = null;
            }
        }
        return returnValue;
    }
}
