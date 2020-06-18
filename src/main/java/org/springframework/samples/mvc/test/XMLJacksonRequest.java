package org.springframework.samples.mvc.test;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JacksonXmlRootElement(localName = "Request")
public class XMLJacksonRequest {
    @JacksonXmlProperty(localName = "Header")
    private Header header = new Header();

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PUBLIC)
    @JacksonXmlRootElement(localName = "Header")
    public static class Header {
        @JacksonXmlProperty(localName = "Id")
        private String id;
        @JacksonXmlProperty(localName = "Name")
        private String name;
    }
}
