package com.zero.boot;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestIP {
    @Test
   public void testip(){
        try {
            InetAddress inet= InetAddress.getLocalHost();
            String ip = inet.getHostAddress();
            System.out.println(ip);
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
