package com.zisal.messaging.shared;

/**
 * Created on 3/4/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IReceiver<DATA> {

    void receive(DATA p_DATA);
}
