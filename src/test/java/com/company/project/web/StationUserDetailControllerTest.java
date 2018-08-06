package com.company.project.web;

import com.company.project.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class StationUserDetailControllerTest {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testFindAny() throws Exception {
        mockMvc.perform(get("/station/user/detail/findAny")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON)
                .param("page", "1")
                .param("size","10")
                .param("dataTime", "20180321")
                .param("eparchyName", "哈尔滨市")
                .param("cityName", "南岗区")
                .param("areaType", "1")
                .param("netType", "4G")
                .param("state", "0")
                .param("userLow", "0")
                .param("userUp", "9999999"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void testFindByIdsDate() throws Exception {
        mockMvc.perform(get("/station/user/detail/findByIdsDate")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON)
                .param("dataTime","20180321")
                .param("ids","'653185','638375'"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }
}