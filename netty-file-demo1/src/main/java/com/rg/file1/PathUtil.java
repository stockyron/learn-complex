package com.rg.file1;

import java.io.File;

/**
 *    
 *  *  
 *  * @Project: netty 
 *  * @Package: com.rg.file1 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年11月28日11:31   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class PathUtil {

    private static final ClassLoader classLoader = PathUtil.class.getClassLoader();

    public static String getFileBasePath() {
        String os = System.getProperty("os.name");
        String basePath;
        if (os.toLowerCase().startsWith("win")) {
            basePath = "C:/Users/Administrator/Pictures/Camera Roll";
        } else {
            basePath = "/root/upload_source";
        }
        basePath = basePath.replace("/", File.separator);
        return basePath;
    }

    public static String getSourcePath(String name) {
        return classLoader.getResource(name).getPath();
    }

}
