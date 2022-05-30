package com.erp.lymytz.api.converter.base.compta;

import com.erp.lymytz.api.model.base.compta.YvsBaseNatureCompte;
import com.fasterxml.jackson.databind.util.StdConverter;

public class ConverterNatureCompte extends StdConverter<YvsBaseNatureCompte, YvsBaseNatureCompte> {

	@Override
	public YvsBaseNatureCompte convert(YvsBaseNatureCompte value) {
		// TODO Auto-generated method stub
		if (value != null) {
			YvsBaseNatureCompte result = new YvsBaseNatureCompte();
			result.setId(value.getId());
			result.setDesignation(value.getDesignation());
			return result;
		}
		return new YvsBaseNatureCompte();
	}

}
