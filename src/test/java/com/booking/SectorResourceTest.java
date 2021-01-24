package com.booking;

import com.booking.model.Sector;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SectorResourceTest extends BaseTest {

    @Test
    public void getAllSectors_OK() throws Exception {
        int sectorCount =
                jdbcTemplate.queryForObject("SELECT COUNT(*) FROM SECTORS", Integer.class);
        MvcResult res =
                mockMvc
                        .perform(MockMvcRequestBuilders.get("/api/v1/sectors"))
                        .andDo(MockMvcResultHandlers.print()) // print more info
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();

        List<Sector> sectors =
                parseJsonListObject(res.getResponse().getContentAsByteArray(), Sector.class);
        Assert.assertNotNull(sectors);
        Assert.assertTrue(sectors.size() == sectorCount);
    }

    @Test
    public void getSectorById_Ok() throws Exception {
        Long id = 2L;
        Sector sectorActual =
                jdbcTemplate.queryForObject("SELECT * FROM SECTORS WHERE id= ?", new RowMapper<Sector>() {
                    @Override
                    public Sector mapRow(ResultSet resultSet, int i) throws SQLException {
                        Sector sectorResult = new Sector();
                        sectorResult.setId(resultSet.getLong("id"));
                        sectorResult.setBooked(resultSet.getBoolean("is_booked"));
                        sectorResult.setRowNumber(resultSet.getInt("row_number"));
                        sectorResult.setSeatNumber(resultSet.getInt("seat_number"));
                        return sectorResult;
                    }
                }, new Object[]{id});
        MvcResult res =
                mockMvc
                        .perform(MockMvcRequestBuilders.get("/api/v1/sectors/" + id))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();

        Sector sectorsExpectation = parseJsonObject(res.getResponse().getContentAsByteArray(), Sector.class);
        Assert.assertSame(sectorsExpectation.isBooked(), sectorActual.isBooked());
        Assert.assertSame(sectorsExpectation.getRowNumber(), sectorActual.getRowNumber());
        Assert.assertSame(sectorsExpectation.getSeatNumber(), sectorActual.getSeatNumber());

    }

    @Test
    public void getAllSectorAvailable_Ok() throws Exception {
        int sectorIsAvailableActual =
                jdbcTemplate.queryForObject("SELECT COUNT(*) FROM SECTORS WHERE is_booked= false", Integer.class);
        MvcResult res =
                mockMvc
                        .perform(MockMvcRequestBuilders.get("/api/v1/sectors/available"))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();

        List<Sector> sectors =
                parseJsonListObject(res.getResponse().getContentAsByteArray(), Sector.class);
        Assert.assertNotNull(sectors);
        Assert.assertTrue(sectors.size() == sectorIsAvailableActual);

    }
}
