package io.swagger.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.model.Product;

@Service
public class ProductService {

	private static List<Product> products = new ArrayList<Product>();

	static {

		ObjectMapper mapper = new ObjectMapper();
		try {
			products = Arrays.asList(mapper.readValue("[{\"id\":\"1\",\"name\":\"Item1\",\"price\":\"120\",\"quantity\":\"10\"},{\"id\":\"2\",\"name\":\"Item2\",\"price\":\"50\",\"quantity\":\"80\"},{\"id\":\"3\",\"name\":\"Item3\",\"price\":\"11\",\"quantity\":\"100\"},{\"id\":\"4\",\"name\":\"Item4\",\"price\":\"25\",\"quantity\":\"300\"},{\"id\":\"5\",\"name\":\"Item5\",\"price\":\"33\",\"quantity\":\"20\"}]",
					Product[].class));
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Product> getProducts() {
		return products;
	}

	public Product getProduct(Integer productId) {
		
		Product selectedProduct = null;
		
		for(Product product:products) {
			
			if(product.getId().equals(productId)) {
				selectedProduct = product;
			}
		}
		
		return selectedProduct;
	}

}
