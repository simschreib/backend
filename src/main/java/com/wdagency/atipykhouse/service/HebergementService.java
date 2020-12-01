package com.wdagency.atipykhouse.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import javax.persistence.EntityNotFoundException;
import java.util.Objects;
import com.wdagency.atipykhouse.model.Hebergement;
import com.wdagency.atipykhouse.model.utils.PagingHeaders;
import com.wdagency.atipykhouse.model.utils.PagingResponse;
import com.wdagency.atipykhouse.repository.HebergementRepository;

@Service
public class HebergementService {
	
	@Autowired
	HebergementRepository hbRepo;
	
	public Hebergement findOne(String id) {
		return hbRepo.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(String.format("Can not find the entity hebergement (%s = %s).", "id", id.toString())));
	}
	
	public Hebergement findByName(String name) {
		return hbRepo.findByName(name);
	}

	public List<Hebergement> findAll(Specification<Hebergement> spec, Sort sort) {
		return hbRepo.findAll(spec, sort);
	}
	
	public void deleteOne(String id) {
		Hebergement hbToDelete = hbRepo.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(String.format("Can not find the entity hebergement (%s = %s).", "id", id.toString())));; 
		hbRepo.delete(hbToDelete);
	}
	
	@Transactional
	public Hebergement newHb(Hebergement hb) {
		hb.setCreationDate(new Date());
		hbRepo.save(hb);
		return hb;
	}
	
    public Hebergement update(String id, Hebergement item) {
        if (item.getId() == null) {
            throw new RuntimeException("Can not update entity, entity without ID.");
        } else if (!id.equals(item.getId())) {
            throw new RuntimeException(String.format("Can not update entity, the resource ID (%d) not match the objet ID (%d).", id, item.getId()));
        }
        item.setModifDate(new Date());
        return save(item);
    }

    /**
     * create \ update elements
     *
     * @param item element to save
     * @return element after save
     */
    protected Hebergement save(Hebergement item) {
        return hbRepo.save(item);
    }
	
    public PagingResponse get(Specification<Hebergement> spec, HttpHeaders headers, Sort sort) {
        if (isRequestPaged(headers)) {
            return get(spec, buildPageRequest(headers, sort));
        } else {
            List<Hebergement> entities = get(spec, sort);
            return new PagingResponse((long) entities.size(), 0L, 0L, 0L, 0L, entities);
        }
    }
    
    public PagingResponse get(Specification<Hebergement> spec, Pageable pageable) {
        Page<Hebergement> page = hbRepo.findAll(spec, pageable);
        List<Hebergement> content = page.getContent();
        return new PagingResponse(page.getTotalElements(), (long) page.getNumber(), (long) page.getNumberOfElements(), pageable.getOffset(), (long) page.getTotalPages(), content);
    }
	
    public List<Hebergement> get(Specification<Hebergement> spec, Sort sort) {
        return hbRepo.findAll(spec, sort);
    }
    
    private boolean isRequestPaged(HttpHeaders headers) {
        return headers.containsKey(PagingHeaders.PAGE_NUMBER.getName()) && headers.containsKey(PagingHeaders.PAGE_SIZE.getName());
    }
    
    private Pageable buildPageRequest(HttpHeaders headers, org.springframework.data.domain.Sort sort) {
        int page = Integer.parseInt(Objects.requireNonNull(headers.get(PagingHeaders.PAGE_NUMBER.getName())).get(0));
        int size = Integer.parseInt(Objects.requireNonNull(headers.get(PagingHeaders.PAGE_SIZE.getName())).get(0));
        return PageRequest.of(page, size, sort);
    }

}
