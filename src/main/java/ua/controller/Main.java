package ua.controller;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.entity.User;
import ua.service.CityService;
import ua.service.UserService;
import ua.service.impl.CityServiceImpl;
import ua.service.impl.UserServiceImpl;



public class Main {

    
//    public static void main(String[] args) {
//
//        ConfigurableApplicationContext context =
//                new ClassPathXmlApplicationContext("/META-INF/appContext.xml");
//
//        CityService service
//                = context.getBean(CityServiceImpl.class);
//
//
//        UserService userService
//                = context.getBean(UserServiceImpl.class);
//
//
//
//        //логіка в сервісі
//        //витягуэм з контексту .getBean
//        //.getBean передаэм екземпляр класу якого ми хочем витягнути
//        //context вернення до нашого контейнера спринг
////        Country Ukraine = new Country("Ukraine");
////        City city = new City("Львов",Ukraine);
////
////        service.save(city);
//
//
//        context.close();
//    }
}
