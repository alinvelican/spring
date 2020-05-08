package com;

import java.util.HashMap;
import java.util.Map;

public class ServiceLocatorMain {


    public static void main(String[] args) {
        EmailService emailerEng = (EmailService) ServiceLocator.getService("engEmailer");
        emailerEng.send("text");
        EmailService emailerFr = (EmailService) ServiceLocator.getService("frEmailer");
        emailerFr.send("text");
    }
}


class Context {

    public static Object lookup(String key) {
        switch (key) {
            case "engEmailer":
                return new EmailService((EnglishChecker) ServiceLocator.getService("engChecker"));
            case "frEmailer":
                return new EmailService((FrenchChecker) ServiceLocator.getService("frChecker"));
            case "frChecker":
                return new FrenchChecker();
            case "engChecker":
                return new EnglishChecker();
            default:
                return null;
        }
    }
}



class ServiceCache {


    private final Map<String, Object> serviceCache = new HashMap<>();


    public Object getService(String key) {
        if (serviceCache.containsKey(key)) {
            Object cachedService = serviceCache.get(key);
            return cachedService;
        }
        return null;
    }

    public void addService(Object newService, String key) {
        serviceCache.put(key, newService);
    }
}



class ServiceLocator {

    private static ServiceCache serviceCache = new ServiceCache();




    public static Object getService(String key) {
        Object serviceObj = serviceCache.getService(key);
        if (serviceObj != null) {
            return serviceObj;
        } else {
            serviceObj =  Context.lookup(key);
            if (serviceObj != null) {
                serviceCache.addService(serviceObj, key);
            }
            return serviceObj;
        }
    }
}