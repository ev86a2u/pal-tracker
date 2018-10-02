package io.pivotal.pal.tracker;

import java.sql.Time;
import java.util.*;


public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private Map<Long, TimeEntry> timeEntries = new HashMap<Long, TimeEntry>();

    private  int id1=0;

    public TimeEntry create(TimeEntry timeEntry) {
        TimeEntry copy = new TimeEntry(++id1, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        timeEntries.put(copy.getId(), copy);
        return copy;
    }

    public TimeEntry find(long id) {
        return timeEntries.get(id);
    }

    public  List<TimeEntry>  list() {

        List<TimeEntry> list = new ArrayList<TimeEntry>(timeEntries.values());
        return list;
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        TimeEntry copy = timeEntries.get(id);

        if(copy ==null)
            return null;
        else {
            TimeEntry copy2 = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
            timeEntries.put(id, copy2);
            return copy2;
        }
    }

    public void delete(long id) {

        timeEntries.remove(id);
        return ;
    }
}
