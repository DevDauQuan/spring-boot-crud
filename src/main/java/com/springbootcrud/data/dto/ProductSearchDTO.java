package com.springbootcrud.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProductSearchDTO {
	private String name;// unique

	private String discription;// unique

	private String categoryName;
}
