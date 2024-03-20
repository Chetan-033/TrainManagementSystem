package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Train;
@Repository
public interface TrainRepository extends JpaRepository<Train,Integer> {

	@Query("select max(id) from Train")
	public int getNewId();
	
	@Query("select train from Train train where name=?1")
	public List<Train> getTrainListByName(String name);
	
	@Query("select train from Train train where t_from=?1 and t_to=?2")
	public List<Train> getTrainListByName(String form,String to);

	@Query("select train from Train train where train_no=?1 and name=?2")
	public Train getTrainByNameNo(int train_no,String name);
	
	//@Query("update Train train set train.seat=:seat where train.train_no=:train_no and train.name=:name")
	//public void BookSeat(@Param("seat")int seat,@Param("train_no")int train_no,@Param("name") String name);

	@Query("select train from Train train where id=?1")
	public Train getTrainByID(int id);
}
