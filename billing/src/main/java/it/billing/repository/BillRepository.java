package it.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.billing.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer> {

}
