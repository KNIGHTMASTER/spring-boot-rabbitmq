package com.zisal.messaging.shared;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @since : 2019-09-03
 **/
public interface EventDAO extends JpaRepository<Event, Long> {
}
