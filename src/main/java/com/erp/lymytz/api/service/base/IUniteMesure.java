package com.erp.lymytz.api.service.base;

import java.util.List;

import com.erp.lymytz.api.model.base.YvsBaseUniteMesure;
import com.erp.lymytz.api.service.IEntity;

public interface IUniteMesure extends IEntity<YvsBaseUniteMesure, Long>{

	public List<YvsBaseUniteMesure> findAll_(Long societe);
}
