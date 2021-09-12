package com.sarvoftware.scheduler.web.scheduledtask.Impl;

import com.sarvoftware.scheduler.model.ScheduledTask;
import com.sarvoftware.scheduler.model.SiteStatusTaskResponse;
import com.sarvoftware.scheduler.web.scheduledtask.Task;
import com.sarvoftware.scheduler.web.service.SiteStatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

@Component
public class SiteIsUpComponent extends Task {

    private static Logger LOGGER = LoggerFactory.getLogger(SiteIsUpComponent.class);

    @Autowired
    SiteStatusService siteStatusService;

    public SiteIsUpComponent() {
        super();
        this.function = this::checkSiteStatus;
    }

    public Boolean checkSiteStatus(ScheduledTask scheduledTask) {
        SiteStatusTaskResponse response = siteStatusService.get(scheduledTask.getTaskId());
        return pingHost(response.getUrl(), 80, 10000);
    }

    private boolean pingHost(String host, int port, int timeout) {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), timeout);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

}
