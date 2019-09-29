package com.ubiqube.etsi.mano.json;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class MapperForView {

	public static ObjectMapper getMapperForView(@Nullable final String exclude, @Nullable final String fields, @Nullable final String excludeDefault, @Nullable final String excludeFields) {
		final ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.setSerializationInclusion(Include.NON_NULL);

		if ((null != exclude) && !exclude.isEmpty()) {
			final List<ViewHolder> excludeList = buildViewList(exclude);
			mapper.registerModule(new SimpleModule() {
				private static final long serialVersionUID = 1L;

				@Override
				public void setupModule(final SetupContext context) {
					super.setupModule(context);
					context.addBeanSerializerModifier(new ExclusionSerializer(excludeList));
				}
			});
		} else if ((null != fields) && !fields.isEmpty()) {
			final List<String> wantedList = Arrays.asList(fields.split(","));
			mapper.registerModule(new SimpleModule() {
				private static final long serialVersionUID = 1L;

				@Override
				public void setupModule(final SetupContext context) {
					super.setupModule(context);
					context.addBeanSerializerModifier(new WantedSerializer(wantedList));
				}
			});
		}
		return mapper;
	}

	@Nonnull
	private static List<ViewHolder> buildViewList(@Nonnull final String fields) {
		final List<String> fieldArray = Arrays.asList(fields.split(","));
		return fieldArray.stream()
				.map(ViewHolder::new)
				.collect(Collectors.toList());
	}

}