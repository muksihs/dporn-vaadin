package com.steem.muksihs.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("serial")
public class SteemObjectMapper extends ObjectMapper {
	private static ObjectMapper instance;
	public static ObjectMapper instance() {
		if (instance==null) {
			instance = new SteemObjectMapper();
		}
		return instance;
	}
	public SteemObjectMapper() {
		enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
		enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
		enable(DeserializationFeature.ACCEPT_FLOAT_AS_INT);
		enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL);
		enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
		enable(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS);
		disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
		disable(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE);
		disable(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES);
		disable(DeserializationFeature.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY);
		disable(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS);
		disable(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY);
		disable(DeserializationFeature.FAIL_ON_TRAILING_TOKENS);
		disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		disable(DeserializationFeature.FAIL_ON_UNRESOLVED_OBJECT_IDS);
	}
}
