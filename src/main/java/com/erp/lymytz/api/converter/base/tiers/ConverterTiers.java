package com.erp.lymytz.api.converter.base.tiers;

import com.erp.lymytz.api.model.base.tiers.YvsBaseTiers;
import com.fasterxml.jackson.databind.util.StdConverter;

public class ConverterTiers extends StdConverter<YvsBaseTiers, YvsBaseTiers> {

	@Override
	public YvsBaseTiers convert(YvsBaseTiers value) {
		// TODO Auto-generated method stub
		if (value != null) {
			YvsBaseTiers result = new YvsBaseTiers();

			return result;
		}
		return new YvsBaseTiers();
	}

}
