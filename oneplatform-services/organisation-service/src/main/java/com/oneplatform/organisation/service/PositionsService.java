package com.oneplatform.organisation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeesuite.common.util.AssertUtil;
import com.jeesuite.common.util.BeanUtils;
import com.oneplatform.organisation.dao.entity.PositionEntity;
import com.oneplatform.organisation.dao.mapper.PositionEntityMapper;

/**
 * generated by www.jeesuite.com
 */
@Service
public class PositionsService {

	@Autowired
	private PositionEntityMapper positionsMapper;

	public void addPositions(PositionEntity entity) {
		AssertUtil.isNull(positionsMapper.findByName(entity.getName()), "该职位已存在");
		positionsMapper.insertSelective(entity);
	}

	public void updatePositions(PositionEntity entity) {
		PositionEntity originEntity = positionsMapper.selectByPrimaryKey(entity.getId());
		AssertUtil.notNull(originEntity);
		BeanUtils.copy(entity, originEntity);
		positionsMapper.updateByPrimaryKey(originEntity);
	}
	
	public void deletePositions(Integer id) {
		positionsMapper.deleteByPrimaryKey(id);
	}
	
	public List<PositionEntity> findPositions(){
		return positionsMapper.selectAll();
	}


	public List<PositionEntity> findAll(){
		return positionsMapper.selectAll();
	}
}
