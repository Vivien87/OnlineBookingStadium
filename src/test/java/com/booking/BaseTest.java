package com.booking;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@SpringBootTest(
        //        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {BookingApplication.class})
@AutoConfigureMockMvc(print = MockMvcPrint.LOG_DEBUG)
@ActiveProfiles(profiles = {"test"})
@ContextConfiguration(classes = {BookingApplication.class})
public abstract class BaseTest {

    @Autowired
    protected MockMvc mockMvc;
    protected JdbcTemplate jdbcTemplate;

    @Autowired
    protected ObjectMapper objectMapper;

    public BaseTest() {
        DataSource dataSource =
                new EmbeddedDatabaseBuilder()
                        .setType(EmbeddedDatabaseType.H2)
                        .addScript("classpath:data.sql")
                        .build();
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    protected <T> T parseJsonObject(byte[] data, Class<T> typeReference) {
        try {
            return objectMapper.readValue(data, typeReference);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected <T> List<T> parseJsonListObject(byte[] data, Class<T> typeReference) {
        JsonFactory jsonF = new JsonFactory();
        JavaType mapperType =
                objectMapper.getTypeFactory().constructCollectionType(List.class, typeReference);
        try {
            return objectMapper.readValue(jsonF.createParser(data), mapperType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
