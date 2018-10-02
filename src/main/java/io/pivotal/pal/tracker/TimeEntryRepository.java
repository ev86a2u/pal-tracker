package io.pivotal.pal.tracker;


import org.springframework.context.annotation.Bean;

import java.util.List;


public interface TimeEntryRepository {


    public TimeEntry create(TimeEntry timeEntry);

    public TimeEntry find(long l) ;

    public List<TimeEntry> list() ;

    public TimeEntry update(long eq, TimeEntry any);

    public void delete(long l) ;
}
