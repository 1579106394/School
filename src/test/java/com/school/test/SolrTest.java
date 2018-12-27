package com.school.test;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试solr
 * @author
 * @date
 */
public class SolrTest {

    /**
     * 测试solr是否搭建成功
     * @throws Exception
     */
    @Test
    public void testSolr1() throws Exception {
        String baseURL = "http://193.112.129.159:9080/solr/";
        SolrServer solrServer = new HttpSolrServer(baseURL);
        SolrInputDocument doc = new SolrInputDocument();
        //设置域
        doc.setField("id", "fgo");
        doc.setField("name", "咕哒子");

        //添加
        solrServer.add(doc);
        //提交
        solrServer.commit();
    }

    /**
     * 测试项目集成solr是否成功
     * @throws Exception
     */
    @Test
    public void testSolr2() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/spring-solr.xml");
        SolrServer solrServer = applicationContext.getBean(HttpSolrServer.class);
        SolrInputDocument doc = new SolrInputDocument();
        //设置域
        doc.setField("id", "fgo");
        doc.setField("name", "大不列颠呆毛狼");

        //添加
        solrServer.add(doc);
        //提交
        solrServer.commit();
    }

}
