package io.swagger.api;

import io.swagger.model.InlineResponse500;
import io.swagger.model.Product;

import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductApiControllerIntegrationTest {

    @Autowired
    private ProductApi api;

    @Test
    public void productGetTest() throws Exception {
        Integer pageNumber = 56;
        Integer pageSize = 56;
        ResponseEntity<List<Product>> responseEntity = api.productGet(pageNumber, pageSize);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void productPostTest() throws Exception {
        Product body = new Product();
        ResponseEntity<Void> responseEntity = api.productPost(body);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void productProductIdGetTest() throws Exception {
        Integer productId = 56;
        Integer customerSecurityHeader = 56;
        ResponseEntity<Product> responseEntity = api.productProductIdGet(productId, customerSecurityHeader);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

}
