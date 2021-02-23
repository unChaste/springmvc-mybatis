package com.ay.jms;

import com.ay.request.MoodPraiseRequest;
import com.ay.request.MoodUnpraiseRequest;
import com.ay.service.MoodService;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@Component
public class MoodConsumer implements MessageListener {

    @Autowired
    private MoodService moodService;

    @Override
    public void onMessage(Message message) {
        try {
            Object obj = ((ActiveMQObjectMessage) message).getObject();
            if (obj instanceof MoodPraiseRequest) {
                MoodPraiseRequest request = (MoodPraiseRequest) obj;
                moodService.praise(request);
            } else if (obj instanceof MoodUnpraiseRequest) {
                MoodUnpraiseRequest request = (MoodUnpraiseRequest) obj;
                moodService.unpraise(request);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
