package com.booking;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class StadiumTicketResourceTest extends BaseTest {

    @Test
    public void booking_sector_byFilter_OK() throws Exception {
        MvcResult res =
                mockMvc
                        .perform(MockMvcRequestBuilders.post("/api/v1/stadium/booking")
                                .param("customerId", "4")
                                .param("sectorId", "3")
                                .param("seatNumber", "2")
                                .param("rowNumber", "3"))
                        .andDo(MockMvcResultHandlers.print()) // print more info
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();
        Long sectorsExpectation = parseJsonObject(res.getResponse().getContentAsByteArray(), Long.class);

        Long id =
                jdbcTemplate.queryForObject("SELECT id FROM STADIUM_TICKET WHERE id=?", Long.class, new Object[]{sectorsExpectation});
        Assert.assertNotNull(id);
        Assert.assertSame(id, sectorsExpectation);

    }
}
