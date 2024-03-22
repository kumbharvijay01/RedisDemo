/**
 * 
 */
package com.org.bhfl.RedisDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.bhfl.RedisDemo.entity.Invoice;
import com.org.bhfl.RedisDemo.service.InvoiceService;

/**
 * @author vijaykumbhar
 *
 */
@RestController
@RequestMapping("/invoice")
public class InvoiceController {

	@Autowired
	InvoiceService invoiceService;

	@PostMapping("/saveInv")
	public Invoice saveInvoice(@RequestBody Invoice invoice) {
		return invoiceService.saveInvoice(invoice);
	}

	@GetMapping("/allInv")
	public List<Invoice> getAllInvoices() {
		return invoiceService.getAllInvoices();
	}

	@GetMapping("/getOne/{id}")
	public Invoice getOneInvoice(@PathVariable Integer id) {
		return invoiceService.getOneInvoice(id);
	}

	@PutMapping("/modify/{id}")
	public Invoice updateInvoice(@RequestBody Invoice inv, @PathVariable Integer id) {
		return invoiceService.updateInvoice(inv, id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteInvoice(@PathVariable Integer id) {
		invoiceService.deleteInvoice(id);
		return "Employee with id: " + id + " Deleted !";
	}
}