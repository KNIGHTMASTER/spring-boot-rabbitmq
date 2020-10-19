package com.zisal.messaging.shared;

import java.io.Serializable;

/**
 * @author : <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @since : 2019-09-04
 **/
public class PublishDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -3057095516044305506L;

    private Long eventId;
    private String content;

    public PublishDTO() {
    }

    public PublishDTO(Long eventId, String content) {
        this.eventId = eventId;
        this.content = content;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PublishDTO{" +
                "eventId=" + eventId +
                ", content='" + content + '\'' +
                '}';
    }
}
