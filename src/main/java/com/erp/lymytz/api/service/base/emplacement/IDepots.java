package com.erp.lymytz.api.service.base.emplacement;

import java.util.List;

import com.erp.lymytz.api.model.base.emplacement.YvsBaseDepots;
import com.erp.lymytz.api.service.IEntity;

public interface IDepots extends IEntity<YvsBaseDepots, Long>  {

	public List<YvsBaseDepots> findByAgence(Object value) throws Exception;

}
