package com.bikepoint.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikepoint.dao.PartDatabaseDao;
import com.bikepoint.dto.PartDatabaseDto;
import com.bikepoint.entites.PartDatabase;
import com.bikepoint.exception.ResourceNotFoundException;

@Service
@Transactional
public class PartDatabaseServiceImpl implements PartDatabaseService {

	@Autowired
	private PartDatabaseDao partDatabaseDao;

	@Autowired
	private ModelMapper mapper;

	@Override
	public PartDatabaseDto addPart(PartDatabaseDto part) {
		PartDatabase par = mapper.map(part, PartDatabase.class);
		return mapper.map(partDatabaseDao.save(par), PartDatabaseDto.class);
	}

	@Override
	public PartDatabaseDto findPartById(long id) throws ResourceNotFoundException{
		PartDatabase part= partDatabaseDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Part not found"));
		return mapper.map(part, PartDatabaseDto.class);
	}

}
