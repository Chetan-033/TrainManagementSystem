package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Train;
import com.repository.TrainRepository;

@Service
public class TrainService {
	@Autowired
	TrainRepository repository; 
	public int getNewId()
	{	
		return repository.getNewId()+1;
	}
	public void addNewTrain(Train train)
	{
		repository.save(train);
	}
	public List<Train> getAllTrain() {
		return repository.findAll();
	}
	public List<Train> getAllTrainByName(String name) {
		return repository.getTrainListByName(name);
	}
	public void deleteTrain(int id)
	{
		repository.deleteById(id);
	}
	public List<Train> getTrainByDestination(String from,String to) {
		return repository.getTrainListByName(from, to);
	}
	public Train getTrainByNameNo(int no,String name) {
		return repository.getTrainByNameNo(no, name);
	}
	public void bookSeat(Train train)
	{
		//repository.BookSeat(seat,train_no, name);
		repository.save(train);
	}
	
	public Train getTrainById(int id)
	{
		return repository.getTrainByID(id);
	}
}
