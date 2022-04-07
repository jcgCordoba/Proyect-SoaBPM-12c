package com.test.mock.resources;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventViewer {
    
    @EventListener
    public void handlerEvent( Object obj ){
           System.out.println( "  ------>  " + obj );
    }
}
