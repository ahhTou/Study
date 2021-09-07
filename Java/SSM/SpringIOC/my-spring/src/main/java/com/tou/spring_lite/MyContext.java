package com.tou.spring_lite;

import com.tou.spring_lite.annotation.Autowired;
import com.tou.spring_lite.annotation.Component;
import com.tou.spring_lite.annotation.Qualifier;
import com.tou.spring_lite.annotation.Value;
import com.tou.spring_lite.utils.BeanDefinition;
import com.tou.spring_lite.utils.MyTools;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class MyContext {

    private final Map<String, Object> ioc = new HashMap<>();

    public MyContext(String pack) {
        // 遍历包，找到目标类
        Set<BeanDefinition> beanDefinitions = findBeanDefinition(pack);
        // 创建对象
        createObject(beanDefinitions);
        // 自动装载
        autowireObject(beanDefinitions);

    }

    public void autowireObject(Set<BeanDefinition> beanDefinitions) {
        try {
            for (BeanDefinition beanDefinition : beanDefinitions) {
                Class<?> clazz = beanDefinition.getBeanClass();
                Field[] declaredFields = clazz.getDeclaredFields();
                for (Field declaredField : declaredFields) {
                    Autowired autowired = declaredField.getAnnotation(Autowired.class);
                    if (autowired != null) {
                        Qualifier qualifier = declaredField.getAnnotation(Qualifier.class);
                        Object obj = getBean(beanDefinition.getBeanName());
                        Object bean;
                        String fieldName = declaredField.getName();
                        String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                        Method method = clazz.getMethod(methodName, declaredField.getType());
                        if (qualifier != null) {
                            // byName
                            bean = getBean(qualifier.value());
                        } else {
                            String prefix = declaredField.getType().getPackage().getName() + ".";
                            String replace = declaredField.getType().getName().replace(prefix, "");
                            String substring = replace.substring(0, 1).toLowerCase() + replace.substring(1);
                            // byType
                            bean = getBean(substring);
                        }
                        method.invoke(obj, bean);


                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Object getBean(String beanName) {
        return ioc.get(beanName);
    }

    public void createObject(Set<BeanDefinition> beanDefinitions) {
        for (BeanDefinition beanDefinition : beanDefinitions) {
            Class<?> clazz = beanDefinition.getBeanClass();
            try {
                Object o = clazz.getConstructor().newInstance();
                // 完成属性的赋值
                Field[] declaredFields = clazz.getDeclaredFields();
                for (Field declaredField : declaredFields) {
                    Value annotation = declaredField.getAnnotation(Value.class);
                    if (annotation != null) {
                        String val = annotation.value();
                        String fieldName = declaredField.getName();
                        String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                        Method method = clazz.getMethod(methodName, declaredField.getType());
                        // 完成数据类型的转换
                        Object value = null;
                        switch (declaredField.getType().getName()) {
                            case "java.lang.Integer":
                                value = Integer.parseInt(val);
                                break;
                            case "java.lang.String":
                                value = val;
                                break;
                            case "java.lang.Float":
                                value = Float.parseFloat(val);
                                break;
                        }
                        method.invoke(o, value);
                    }
                }


                ioc.put(beanDefinition.getBeanName(), o);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param pack 包名
     * @return 返回原材料（beanName-class）
     */
    public Set<BeanDefinition> findBeanDefinition(String pack) {
        /*
         * 1. 获取包下的所有类
         * 2. 遍历这些类，找到添加了注解的类
         * 3. 将这些类封装成 BeanDefinition， 装载到集合中
         * */
        Set<Class<?>> classes = MyTools.getClasses(pack);
        Set<BeanDefinition> beanDefinitions = new HashSet<>();
        classes.forEach(
                clazz -> {
                    Component component = clazz.getAnnotation(Component.class);
                    // 找到添加注解的类
                    if (component != null) {
                        // 获取 Component 注解的值
                        String beanName = component.value();
                        if ("".equals(beanName)) {
                            String prefix = clazz.getPackage().getName() + ".";
                            String replace = clazz.getName().replace(prefix, "");
                            beanName = replace.substring(0, 1).toLowerCase() + replace.substring(1);
                        }
                        beanDefinitions.add(new BeanDefinition(beanName, clazz));
                    }
                }
        );
        return beanDefinitions;
    }
}
