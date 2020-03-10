package com.rg.bean.factoryBeanClass;

import org.springframework.beans.factory.FactoryBean;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.bean.factoryBeanClass 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月24日11:42   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class CarFacrotyBean implements FactoryBean<Car> {

    private String carInfo;

    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        String[] split = carInfo.split(",");
        car.setBrand(split[0]);
        car.setMaxSpeed(Integer.parseInt(split[1]));
        car.setPrice(Double.parseDouble(split[2]));
        return car;
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }
}
