package com.wdagency.atipykhouse.controller;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wdagency.atipykhouse.model.Hebergement;
import com.wdagency.atipykhouse.model.utils.PagingHeaders;
import com.wdagency.atipykhouse.model.utils.PagingResponse;
import com.wdagency.atipykhouse.service.HebergementService;

import net.kaczmarzyk.spring.data.jpa.domain.Between;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.In;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@CrossOrigin
@RestController
@RequestMapping("home")
public class HebergementController {

	@Autowired
	HebergementService hebService;
	
	@Transactional
	@GetMapping(value="/allHomes", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Hebergement>> get(
	        @And({
	        		@Spec(path = "name", params = "name", spec = Like.class),
	                @Spec(path = "notation", params = "notation", spec = Like.class),
	                @Spec(path = "price", params = "price", spec = Like.class),
	                @Spec(path = "postalCode", params = "postalCode", spec = In.class),
	                @Spec(path = "type", params = "type", spec = Like.class),
	                @Spec(path = "createDate", params = "createDate", spec = Equal.class),
	                @Spec(path = "owner", params ="owner", spec = Between.class)
	        }) Specification<Hebergement> spec,
	        Sort sort,
	        @RequestHeader HttpHeaders headers) {
	    final PagingResponse response = hebService.get(spec, headers, sort);
	    return new ResponseEntity<>(response.getElements(), returnHttpHeaders(response), HttpStatus.OK);
	}
	
    public HttpHeaders returnHttpHeaders(PagingResponse response) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(PagingHeaders.COUNT.getName(), String.valueOf(response.getCount()));
        headers.set(PagingHeaders.PAGE_SIZE.getName(), String.valueOf(response.getPageSize()));
        headers.set(PagingHeaders.PAGE_OFFSET.getName(), String.valueOf(response.getPageOffset()));
        headers.set(PagingHeaders.PAGE_NUMBER.getName(), String.valueOf(response.getPageNumber()));
        headers.set(PagingHeaders.PAGE_TOTAL.getName(), String.valueOf(response.getPageTotal()));
        return headers;
    }
	
	
//	@GetMapping(value="/allHomes")
//	public List<Hebergement> getHebergements() {
//		return hebService.findAll();
//	}
	
	@GetMapping(value="/{id}")
	public Hebergement getHebergement(@PathVariable String id) {
		return hebService.findOne(id);
	}
	
	@PostMapping(value="/create")
	public void createHebergement(Hebergement hebergement) {
		try {
			hebService.newHb(hebergement);
		} catch (HibernateException e) {
			e.getMessage();
		}
	}
	
	@PostMapping(value="/update")
	public void updateHebergement(Hebergement hebergement) {
		try {
			Hebergement hbToUpdate = hebService.findOne(hebergement.getId());
			hbToUpdate.setType(hebergement.getType());	
			hebService.update(hebergement.getId(), hbToUpdate);
		} catch (HibernateException e) {
			e.getMessage();
			
		}
	}
}
