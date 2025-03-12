package com.ks.generator;

import com.ks.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        String property = System.getProperty("user.dir");
        System.out.println("根路径是： " + property);
        String inputPath = property + File.separator+ "samples" + File.separator + "acm-template";
        String outputPath = property;
        System.out.println("inputPath: " + inputPath + "outputPath: " + outputPath);
        StaticGenerator.copyFileByHutool(inputPath, outputPath);



        String projectPath = System.getProperty("user.dir");
        String inputPath1 = projectPath + File.separator + "ks-generator-basic" +File.separator +"src/main/resources/template/MainTemplate.java.ftl";
        String outputPath1 = projectPath + File.separator + "acm-template/src/com/ks/acm/MainTemplate.java";
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("ks");
        mainTemplateConfig.setLoop(true);
        mainTemplateConfig.setOutputText("求和结果：");


        DynamicGenerator.doGenerate(inputPath1, outputPath1, mainTemplateConfig);
    }
}
