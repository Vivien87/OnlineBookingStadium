package com.booking;

import com.booking.model.SectorType;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

public class SectorTypeResourceTest extends BaseTest {

    @Test
    public void getAllType_OK() throws Exception {
        int sectorTypeCount =
                jdbcTemplate.queryForObject("SELECT COUNT(*) FROM SECTOR_TYPE", Integer.class);
        MvcResult res =
                mockMvc
                        .perform(MockMvcRequestBuilders.get("/types"))
                        .andDo(MockMvcResultHandlers.print()) // print more info
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();

        List<SectorType> sectorTypes =
                parseJsonListObject(res.getResponse().getContentAsByteArray(), SectorType.class);
        Assert.assertNotNull(sectorTypes);
        Assert.assertTrue(sectorTypes.size() == sectorTypeCount);
    }
}