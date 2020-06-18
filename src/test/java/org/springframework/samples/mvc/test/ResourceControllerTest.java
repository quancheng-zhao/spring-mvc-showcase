package org.springframework.samples.mvc.test;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.samples.mvc.AbstractContextControllerTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.io.InputStream;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
public class ResourceControllerTest  extends AbstractContextControllerTests {
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).alwaysExpect(status().isOk()).build();
    }

    @Test
    public void postJavax() throws Exception {
        String content = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<Request>\n" +
                "    <Header>\n" +
                "        <Id>TestId</Id>\n" +
                "        <Name>TestName</Name>\n" +
                "    </Header>\n" +
                "</Request>";

        this.mockMvc
                .perform(
                        MockMvcRequestBuilders.post("/test/javax")
                                .accept(MediaType.APPLICATION_XML_VALUE)
                                .contentType(MediaType.APPLICATION_XML_VALUE)
                                .content(content)
                )
                .andDo(res -> System.out.println("======= " + res.getResponse().getContentAsString()));
    }

    @Test
    public void postFasterxml() throws Exception {
        String content = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<Request>\n" +
                "    <Header>\n" +
                "        <Id>TestId</Id>\n" +
                "        <Name>TestName</Name>\n" +
                "    </Header>\n" +
                "</Request>";
        this.mockMvc
                .perform(
                        MockMvcRequestBuilders.post("/test/fasterxml")
                                .accept(MediaType.APPLICATION_XML_VALUE)
                                .contentType(MediaType.APPLICATION_XML_VALUE)
                                .content(content)
                )
                .andDo(res -> System.out.println(">>>>>>> " + res.getResponse().getContentAsString()));
    }


    private String getFileAsString(String fileName) {
        InputStream inputFile = getClass().getResourceAsStream(fileName);
        try {
            return IOUtils.toString(inputFile)
                    // this is windows specific - so that CRLF gets converted to LF
                    .replace("\r\n", "\n");
        } catch (IOException e) {
            Assert.fail("Failed parsing file: " + fileName + ". Error was: " + e.getMessage());
            return "";
        }
    }
}
