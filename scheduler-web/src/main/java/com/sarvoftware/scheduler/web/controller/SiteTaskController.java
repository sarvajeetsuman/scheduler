package com.sarvoftware.scheduler.web.controller;

import com.sarvoftware.scheduler.model.SiteStatusTaskRequest;
import com.sarvoftware.scheduler.model.SiteStatusTaskResponse;
import com.sarvoftware.scheduler.web.service.SiteStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(path = "/sitestatus")
public class SiteTaskController {

    @Autowired
    SiteStatusService siteStatusService;

    @PostMapping(value = "")
    public ResponseEntity<SiteStatusTaskResponse> save(@RequestBody SiteStatusTaskRequest request) {
        return new ResponseEntity(siteStatusService.save(request), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SiteStatusTaskResponse> get(@PathVariable Long id) {
        return new ResponseEntity(siteStatusService.get(id), HttpStatus.OK);
    }

}
