package com;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

public class ReflectionMain {
    private static Class[] getClasses(String packageName) throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.', '/');
        var resources = classLoader.getResources(path);
        var dirs = new ArrayList<File>();
        while (resources.hasMoreElements()) {
            var resource =  resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        var classes = new ArrayList<Class>();
        for (var directory : dirs) {
            classes.addAll(findClasses( directory, packageName));
        }
        return  classes.toArray(new Class[classes.size()]);
    }

    private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
        var classes = new ArrayList<Class>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //        var list = ReflectionMain.getClasses("com");
        var list = ReflectionMain.getClasses(Config.class.getPackageName());
        for(var clazz : list) {
//            System.out.println(clazz);
//            System.out.println(Arrays.toString(clazz.getAnnotations()));
            if(Arrays.stream(clazz.getAnnotations()).filter(x -> x.annotationType().equals(Component.class)).count() == 1) {
                System.out.println(clazz.getName());
            }
        }
    }
}
