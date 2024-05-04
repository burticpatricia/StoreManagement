package com.ing.store.api.mapper;

import com.ing.store.domain.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.openapitools.model.ProductDto;

import javax.validation.constraints.NotNull;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto dtoFromProduct(@NotNull Product product);
    Product productFromDto(@NotNull ProductDto dto);
    List<ProductDto> dtoListFromProductList(List<Product> productList);
    List<Product> listFromProductDtoList(List<ProductDto> dtoList);
}
