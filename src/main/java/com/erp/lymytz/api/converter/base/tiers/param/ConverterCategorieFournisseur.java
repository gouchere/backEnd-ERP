package com.erp.lymytz.api.converter.base.tiers.param;

import com.erp.lymytz.api.model.base.tiers.param.YvsBaseCategorieFournisseur;
import com.fasterxml.jackson.databind.util.StdConverter;

public class ConverterCategorieFournisseur extends StdConverter<YvsBaseCategorieFournisseur, YvsBaseCategorieFournisseur> {

	@Override
	public YvsBaseCategorieFournisseur convert(YvsBaseCategorieFournisseur value) {
		// TODO Auto-generated method stub
		if (value != null) {
			YvsBaseCategorieFournisseur result = new YvsBaseCategorieFournisseur();
			result.setId(value.getId());
			result.setLibelle(value.getLibelle());
			return result;
		}
		return new YvsBaseCategorieFournisseur();
	}

}
