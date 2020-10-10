package com.mangxiao.orders.doc;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;

public class BuildDoc {

    public static void main(String[] args){
        DocsConfig config = new DocsConfig();
        config.setProjectPath("D:\\workspace\\Java-Projects\\seata-sample\\seata-sample-orders"); // 项目根目录
        config.setProjectName("seata-sample-orders"); // 项目名称
        config.setApiVersion("V1.0");       // 声明该API的版本
        config.setDocsPath("D:\\workspace\\Java-Projects\\seata-sample\\seata-sample-orders\\doc"); // 生成API 文档所在目录
        config.setAutoGenerate(Boolean.TRUE);  // 配置自动生成
        Docs.buildHtmlDocs(config); // 执行生成文档
    }
}
