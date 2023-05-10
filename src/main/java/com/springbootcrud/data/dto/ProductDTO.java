package com.springbootcrud.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {

	private String name;// unique

	private String discription;// unique

	private CategoryDTO categoryDTO;
}
