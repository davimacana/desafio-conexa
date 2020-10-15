/**
 * 
 */
package com.desafio.conexa.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

/**
 * @author Davi Maçana
 *
 */
public class GenericMapper {

	public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
	    return source
	      .stream()
	      .map(element -> new ModelMapper().map(element, targetClass))
	      .collect(Collectors.toList());
	}
}
