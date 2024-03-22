/**
 * 
 */
package com.org.bhfl.RedisDemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.org.bhfl.RedisDemo.entity.Invoice;

/**
 * @author vijaykumbhar
 *
 */
@Service
public interface InvoiceService {

	public Invoice saveInvoice(Invoice inv);

	public Invoice updateInvoice(Invoice inv, Integer invId);

	public void deleteInvoice(Integer invId);

	public Invoice getOneInvoice(Integer invId);

	public List<Invoice> getAllInvoices();

	public List<Invoice> findByInvName(String invName);
}
