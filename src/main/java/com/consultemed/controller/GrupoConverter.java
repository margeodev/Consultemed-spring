package com.consultemed.controller;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.consultemed.model.Grupo;

public class GrupoConverter implements Converter<String, Grupo> {
	@Override
	public Grupo convert(String id) {
		if (!StringUtils.isEmpty(id)) {
			Grupo grupo = new Grupo();
			grupo.setId(Long.valueOf(id));
			return grupo;
		}
		
		return null;
	}
}

