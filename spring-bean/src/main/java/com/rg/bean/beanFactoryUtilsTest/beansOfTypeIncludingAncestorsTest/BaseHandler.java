package com.rg.bean.beanFactoryUtilsTest.beansOfTypeIncludingAncestorsTest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.bean.beanFactoryUtilsTest.beansOfTypeIncludingAncestorsTest 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月18日12:47   
 *  * @Version:   v1.0
 *  *    
 *  
 */
@Component
public class BaseHandler implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private List<IBeanConverter> list;

    @PostConstruct
    private void init() {
        Map<String, IBeanConverter> matchBeans = BeanFactoryUtils.beansOfTypeIncludingAncestors(
                applicationContext, IBeanConverter.class, true, false);
        System.out.println(matchBeans);
        if(matchBeans.isEmpty()){
            throw new RuntimeException("IBeanConverter impl bean is empty !");
        }
        this.list = new ArrayList<>(matchBeans.values());
    }

    public IBeanConverter getMatchConverter(String type) {
        Optional<IBeanConverter> optional = list.stream().filter(e -> e.match(type)).findFirst();
        return optional.orElseThrow(() -> new RuntimeException("no match IBeanConverter impl with type ["
                + type + "]"));
    }

    public <T>String[] get1(Class<T> clz){
        if(clz == null){
            return BeanFactoryUtils.beanNamesIncludingAncestors(applicationContext);
        }
        return BeanFactoryUtils.beanNamesForTypeIncludingAncestors(applicationContext, IBeanConverter.class);
    }

    public String[] get2(){
        return BeanFactoryUtils.beanNamesForTypeIncludingAncestors(applicationContext,
                ResolvableType.forClass(IBeanConverter.class));
    }

    public IBeanConverter get3(){
        return BeanFactoryUtils.beanOfType(applicationContext, IBeanConverter.class);
    }

}
