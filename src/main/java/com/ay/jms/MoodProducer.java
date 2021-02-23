package com.ay.jms;

import com.ay.request.MoodPraiseRequest;
import com.ay.request.MoodUnpraiseRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


@Component
public class MoodProducer {
    private static final Logger logger = LoggerFactory.getLogger(MoodProducer.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    private static final String QUEUE_PRAISE = "ay.queue.praise";

    public void sendPraiseMessage(MoodPraiseRequest moodPraiseRequest) {
        logger.info("生产者--->>>用户id：" + moodPraiseRequest.getUserId() + " 给说说id：" + moodPraiseRequest.getMoodId() + " 点赞");
        jmsTemplate.convertAndSend(QUEUE_PRAISE, moodPraiseRequest);
    }

    public void sendUnpraiseMessage(MoodUnpraiseRequest moodUnpraiseRequest) {
        logger.info("生产者--->>>用户id：" + moodUnpraiseRequest.getUserId() + " 给说说id：" + moodUnpraiseRequest.getMoodId() + " 取消点赞");
        jmsTemplate.convertAndSend(QUEUE_PRAISE, moodUnpraiseRequest);
    }
}
