package com.booking.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
//public abstract class BookingRepository implements BookingRepositoryCustom {
public interface BookingRepository extends JpaRepository<Booking, Long> {

    //@Autowired
    //private RabbitTemplate template;
    //
    //public String save(Booking booking) {
    //    return "Success";
    //}
    //
    //public void deleteById(Long id) {
    //}
    //
    //public void delete(Booking booking) {
    //}
}
