package com.booking;

import com.booking.model.Customer;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

public class CustomerResourceTest extends BaseTest {

    @Test
    public void getAllCustomers_OK() throws Exception {
        int sectorTypeCount =
                jdbcTemplate.queryForObject("SELECT COUNT(*) FROM CUSTOMER", Integer.class);
        MvcResult res =
                mockMvc
                        .perform(MockMvcRequestBuilders.get("/api/v1/customers"))
                        .andDo(MockMvcResultHandlers.print()) // print more info
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();

        List<Customer> customers =
                parseJsonListObject(res.getResponse().getContentAsByteArray(), Customer.class);
        Assert.assertNotNull(customers);
        Assert.assertTrue(customers.size() == sectorTypeCount);
    }


}
