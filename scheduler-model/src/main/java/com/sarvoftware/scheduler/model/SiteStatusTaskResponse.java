package com.sarvoftware.scheduler.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SiteStatusTaskResponse {

    private Long id;

    private String url;

    private RunFrequencyType frequency;

    private Boolean status;

}
