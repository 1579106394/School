package com.school.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;

/**
 * 消息队列测试
 *
 * @author
 * @date
 */
public class ActiveMqTest {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Test
    public void testSpringActiveMq() throws Exception {
        //初始化spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/spring-activemq.xml");
        //从spring容器中获得JmsTemplate对象
        JmsTemplate jmsTemplate = applicationContext.getBean(JmsTemplate.class);
        //从spring容器中取Destination对象
        Destination destination = (Destination) applicationContext.getBean("queueDestination");
        //使用JmsTemplate对象发送消息。
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                //创建一个消息对象并返回
                TextMessage textMessage = session.createTextMessage("spring activemq queue message");
                return textMessage;
            }
        });
    }

}
