package com.codesmart.myproj;

import com.codesmart.myproj.controller.ProductController;
import com.codesmart.myproj.entity.Product;
import com.codesmart.myproj.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
//@ExtendWith()
@WebMvcTest(ProductController.class)
class MyprojApplicationTests {

	@MockBean
	private ProductService productService;

	private ProductController productController;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void testingGetProductControllerMethod() throws Exception {

		Product mockProduct = new Product(1L,"Grape","This is a very nice grape");

		Mockito.when(productService.getProduct(anyLong())).thenReturn(Optional.of(mockProduct));

		mockMvc.perform(get("/product/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.name").value("Grape"))
				.andExpect(jsonPath("$.description").value("This is a very nice grape"));
	}
	@Test
	void testingGetAllProductsControllerMethod() throws Exception {
		List<Product> productList = new ArrayList<>(
				Arrays.asList(
						new Product(1L, "Grape", "This is a very nice grape"),
						new Product(2L, "Banana", "This is a very nice Banana"),
						new Product(3L, "Orange", "This is a very nice Orange")
				)
		);

		Mockito.when(productService.getProductList()).thenReturn(productList);

		mockMvc.perform(get("/product/all"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id").value(1))
				.andExpect(jsonPath("$[0].name").value("Grape"))
				.andExpect(jsonPath("$[0].description").value("This is a very nice grape"))

				.andExpect(jsonPath("$[1].id").value(2))
				.andExpect(jsonPath("$[1].name").value("Banana"))
				.andExpect(jsonPath("$[1].description").value("This is a very nice Banana"))

				.andExpect(jsonPath("$[2].id").value(3))
				.andExpect(jsonPath("$[2].name").value("Orange"))
				.andExpect(jsonPath("$[2].description").value("This is a very nice Orange"));
	}
}
