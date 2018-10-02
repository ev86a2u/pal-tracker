package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.sql.Time;
import java.util.List;

@RestController
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController (TimeEntryRepository timeEntryRepository){
        this.timeEntryRepository = timeEntryRepository;

    }

    @PostMapping("/time-entries")
    public ResponseEntity create(TimeEntry timeEntry)
    {
        TimeEntry timeEntry1 = timeEntryRepository.create(timeEntry);

        //ResponseEntity.status(HttpStatus.CREATED).body(timeEntry) ;
        //= new ResponseEntity(timeEntry1, HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(timeEntry) ;
    }

    public ResponseEntity<TimeEntry> read(long l) {

        TimeEntry timeEntry1 = timeEntryRepository.find(l);
        ResponseEntity responseEntity;

        if(timeEntry1 == null)
            responseEntity = new ResponseEntity(timeEntry1, HttpStatus.NOT_FOUND);
        else
            responseEntity = new ResponseEntity(timeEntry1, HttpStatus.OK);


        return  responseEntity;
    }

    public ResponseEntity<List<TimeEntry>> list() {

        List<TimeEntry> list =  timeEntryRepository.list();
        ResponseEntity responseEntity;

        responseEntity = new ResponseEntity(list, HttpStatus.OK);

        return  responseEntity;
    }

    public ResponseEntity update(long l, TimeEntry timeEntry) {
        TimeEntry timeEntry1 = timeEntryRepository.update(l,timeEntry);

        ResponseEntity responseEntity;

        if(timeEntry1 == null)
            responseEntity = new ResponseEntity(timeEntry1, HttpStatus.NOT_FOUND);
        else
            responseEntity = new ResponseEntity(timeEntry1, HttpStatus.OK);


        return  responseEntity;
    }

    public ResponseEntity<TimeEntry> delete(long l) {
        timeEntryRepository.delete(l);
        return new ResponseEntity<TimeEntry>(HttpStatus.NO_CONTENT);
    }
}
