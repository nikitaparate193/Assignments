package com.example.UniversityEvent1.UniversityEventManagement1.Repository;

import com.example.UniversityEvent1.UniversityEventManagement1.model.EventModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface IEventRepo extends CrudRepository<EventModel,Long>{
    List<EventModel> findAllEventByDate(LocalDate date);
}
