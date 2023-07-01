package com.example.UniversityEvent1.UniversityEventManagement1.service;

import com.example.UniversityEvent1.UniversityEventManagement1.Repository.IEventRepo;
import com.example.UniversityEvent1.UniversityEventManagement1.model.EventModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    IEventRepo eventRepo;

    public void addEvent(EventModel eventModel) {
        eventRepo.save(eventModel);

    }

    public String updateEventById(Long eventId, String eventName) {
        Optional<EventModel> myEventOpt =eventRepo.findById(eventId);
        EventModel myEvent=null;
        if(myEventOpt.isPresent()){
            myEvent = myEventOpt.get();
        }else{
            return "Id not found";
        }
        myEvent.setEventName(eventName);
        eventRepo.save(myEvent);
        return "event updated";

    }

    public String deleteEvent(Long eventId) {
        eventRepo.deleteById((eventId));
        return "event deleted";
    }

    public List<EventModel> getAllEventsByDate(LocalDate date){
        return eventRepo.findAllEventByDate(date);
    }

    public Iterable<EventModel> getAllEvent() {
        return eventRepo.findAll();
    }


//    Add event
//Update event
//Delete event
//Get All events by date
}
