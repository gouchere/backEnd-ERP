package com.erp.lymytz.api.converter.base;

import com.erp.lymytz.api.model.base.users.YvsUsersAgence;
import com.fasterxml.jackson.databind.util.StdConverter;

public class ConverterAuthor extends StdConverter<YvsUsersAgence, YvsUsersAgence> {

	@Override
	public YvsUsersAgence convert(YvsUsersAgence value) {
		// TODO Auto-generated method stub
		if (value != null) {
			YvsUsersAgence result = new YvsUsersAgence();
			result.setId(value.getId());
			return result;
		}
		return new YvsUsersAgence();
	}

}
