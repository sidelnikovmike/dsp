package pro.proxeter.dsp.services;

import org.springframework.stereotype.Service;

/**
 * Created by proxeter on 04.06.17.
 */
@Service
public class DSPService {

    public void shouldWait(int wait) {
        try {
            Thread.sleep(wait);
        } catch (InterruptedException e) {
            // Ignore
        }
    }

}
