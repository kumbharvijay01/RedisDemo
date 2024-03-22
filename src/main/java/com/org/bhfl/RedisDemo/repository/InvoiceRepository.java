/**
 * 
 */
package com.org.bhfl.RedisDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.bhfl.RedisDemo.entity.Invoice;

/**
 * @author vijaykumbhar
 *
 */
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
	public List<Invoice> findByInvName(String invName);
	

}
