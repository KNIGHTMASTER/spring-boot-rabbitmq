package com.zisal.messaging.shared;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author : <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @since : 2019-09-03
 **/
public interface EventDetailDAO extends JpaRepository<EventDetail, Long> {

    List<EventDetail> findByEventId(Long p_EventId);
}
