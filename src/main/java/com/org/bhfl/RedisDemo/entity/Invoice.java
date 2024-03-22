/**
 * 
 */
package com.org.bhfl.RedisDemo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @author vijaykumbhar
 *
 */
@Data
@Entity
@Component
public class Invoice implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "inv_id")

	private Integer invId;
	@Column(name = "inv_Name")
	private String invName;
	@Column(name = "inv_amount")
	private Double invAmount;
}
