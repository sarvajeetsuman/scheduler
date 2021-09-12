package com.sarvoftware.scheduler.web.scheduledtask;

import com.sarvoftware.scheduler.model.ScheduledTask;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Getter
@Setter
@Service
public abstract class Task {

    protected Function<ScheduledTask, Boolean> function;

    public Boolean processTask(ScheduledTask scheduledTask) {
        return function.apply(scheduledTask);
    }

}
