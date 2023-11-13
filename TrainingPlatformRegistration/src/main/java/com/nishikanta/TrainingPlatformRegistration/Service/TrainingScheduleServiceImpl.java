package com.nishikanta.TrainingPlatformRegistration.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nishikanta.TrainingPlatformRegistration.Entity.TrainingSchedule;
import com.nishikanta.TrainingPlatformRegistration.ExceptionHandler.ResourceNotFoundException;
import com.nishikanta.TrainingPlatformRegistration.Repository.TrainingScheduleRepository;

import java.util.List;

@Service
@Transactional
public class TrainingScheduleServiceImpl implements TrainingScheduleService {

    @Autowired
    private TrainingScheduleRepository trainingScheduleRepository;

    @Override
    public List<TrainingSchedule> getAllTrainingSchedules() {
        return trainingScheduleRepository.findAll();
    }

    @Override
    public TrainingSchedule getTrainingScheduleById(Long id) {
        return trainingScheduleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Schedule not found with id: " + id));
    }

    @Override
    public TrainingSchedule createTrainingSchedule(TrainingSchedule trainingSchedule) {
        return trainingScheduleRepository.save(trainingSchedule);
    }

    @Override
    public TrainingSchedule updateTrainingSchedule(Long id, TrainingSchedule trainingSchedule) {
        trainingSchedule.setScheduleId(id);
        return trainingScheduleRepository.save(trainingSchedule);
    }

    @Override
    public void deleteTrainingSchedule(Long id) {
        trainingScheduleRepository.deleteById(id);
    }
}
