package com.bikepoint.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikepoint.dao.PartDao;
import com.bikepoint.dto.PartDto;
import com.bikepoint.entites.Part;
import com.bikepoint.exception.ResourceNotFoundException;

@Service
@Transactional
public class PartServiceImpl implements PartService {

	@Autowired
	private PartDao partDao;

	@Autowired
	private ModelMapper mapper;

	@Override
	public PartDto addPart(PartDto part) {
		Part par = mapper.map(part, Part.class);
		return mapper.map(partDao.save(par), PartDto.class);
	}

	@Override
	public PartDto findPartById(long id) throws ResourceNotFoundException{
		Part part= partDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Part not found"));
		return mapper.map(part, PartDto.class);
	}

}
