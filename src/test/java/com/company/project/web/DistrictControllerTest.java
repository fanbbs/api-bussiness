package com.company.project.web;

import com.company.project.Application;
import com.company.project.model.District;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class DistrictControllerTest  {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testAdd() throws Exception {
        District district = new District();
        district.setDistrictId(90000001);
        district.setDistrictName("董建斌地区");
        district.setEparchyCode("0451");
        ObjectMapper mapper = new ObjectMapper();

        //调用接口，传入添加的用户参数
        String result = mockMvc.perform(post("/district/")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(district)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.code", is(200)))
                .andExpect(jsonPath("$.message", is("SUCCESS")))
                .andReturn().getResponse().getContentAsString();
        System.out.print("aaaaaaaa" + result);

        mockMvc.perform(get("/district/90000001")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is(200)))
                .andExpect(jsonPath("$.data", notNullValue()))
                .andExpect(jsonPath("$.data.districtName", is("董建斌地区")))
                .andExpect(jsonPath("$.data.eparchyCode", is("0451")))
                .andExpect(jsonPath("$.message", is("SUCCESS")));
    }

    @Test
    public void testUpdate() throws Exception {
        District district = new District();
        district.setDistrictId(90000001);
        district.setDistrictName("董建斌地区-改");
        district.setEparchyCode("0452");
        ObjectMapper mapper = new ObjectMapper();

        String result = mockMvc.perform(put("/district/")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .content(mapper.writeValueAsString(district)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.code", is(200)))
                .andExpect(jsonPath("$.message", is("SUCCESS")))
                .andReturn().getResponse().getContentAsString();
        System.out.print("fffffff" + result);

    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete("/district/90000001")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is(200)))
                .andExpect(jsonPath("$.message", is("SUCCESS")));
    }

    @Test
    public void testDetail() throws Exception {
        mockMvc.perform(get("/district/1150183")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is(200)))
                .andExpect(jsonPath("$.data", notNullValue()))
                .andExpect(jsonPath("$.data.cityCode", is("972017")))
                .andExpect(jsonPath("$.data.eparchyCode", is("0451")))
                .andExpect(jsonPath("$.message", is("SUCCESS")));
    }

    @Test
    public void testList() throws Exception {
        mockMvc.perform(get("/district/")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON)
                .param("page","1")
                    .param("size","10"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void testFindByAddressID() throws Exception {
        mockMvc.perform(get("/district/findByLatnid/'0451'")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is(200)))
                .andExpect(jsonPath("$.data", notNullValue()))
                .andExpect(jsonPath("$.message", is("SUCCESS")));
    }
}