package com.example.demo.controller;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CatalogueMapper {

    CatalogueMapper INSTANCE = Mappers.getMapper(CatalogueMapper.class);

    CatalogueDto toCatalogueDto(Catalogue catalogue);
}
