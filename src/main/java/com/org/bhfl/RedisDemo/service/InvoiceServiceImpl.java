/**
 * 
 */
package com.org.bhfl.RedisDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.org.bhfl.RedisDemo.InvoiceNotFoundException;
import com.org.bhfl.RedisDemo.entity.Invoice;
import com.org.bhfl.RedisDemo.repository.InvoiceRepository;

/**
 * @author vijaykumbhar
 *
 */
@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Override
	public Invoice saveInvoice(Invoice inv) {
		return invoiceRepository.save(inv);
	}

	@Override
	@CachePut(value = "Invoice", key = "#invId")
	public Invoice updateInvoice(Invoice inv, Integer invId) {
		Invoice invoice = invoiceRepository.findById(invId)
				.orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
		invoice.setInvAmount(inv.getInvAmount());
		invoice.setInvName(inv.getInvName());
		return invoiceRepository.save(invoice);
	}

	@Override
	@CacheEvict(value = "Invoice", key = "#invId")
	// @CacheEvict(value="Invoice", allEntries=true) //in case there are multiple
	// records to delete
	public void deleteInvoice(Integer invId) {
		Invoice invoice = invoiceRepository.findById(invId)
				.orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
		invoiceRepository.delete(invoice);
	}

	@Override
	@Cacheable(value = "Invoice", key = "#invId")
	public Invoice getOneInvoice(Integer invId) {
		Invoice invoice = invoiceRepository.findById(invId)
				.orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
		return invoice;
	}

	@Override
	@Cacheable(value = "Invoice")
	public List<Invoice> getAllInvoices() {
		List<Invoice> list = invoiceRepository.findAll();
		System.out.println("Total Count" + list.size());
		return invoiceRepository.findAll();
	}

	@Override
	public List<Invoice> findByInvName(String invName) {
		return invoiceRepository.findByInvName(invName);
	}

}
