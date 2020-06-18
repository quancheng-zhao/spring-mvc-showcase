package org.springframework.samples.mvc.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;
import static org.springframework.http.MediaType.TEXT_XML_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RequestMapping("/test")
@RestController
public class ResourceController {


    @RequestMapping(value = "/javax",
            method = POST,
            consumes = {APPLICATION_XML_VALUE, TEXT_XML_VALUE},
            produces = {APPLICATION_XML_VALUE, TEXT_XML_VALUE})
    @ResponseStatus(OK)
    public ActionResponse postJavaxBody(@Valid @RequestBody XMLJavaxRequest xmlRequest) {
        StringBuilder sb = new StringBuilder();
        if (xmlRequest.getHeader() != null) {
            sb.append("javax header is not null\n");
            if (xmlRequest.getHeader().getId() != null) {
                sb.append("javax header's id is not null\n");
            } else {
                sb.append("javax header's id is null\n");
            }
            if (xmlRequest.getHeader().getName() != null) {
                sb.append("javax header's name is not null\n");
            } else {
                sb.append("javax header's id is null\n");
            }
        } else {
            sb.append("javax header is null");
        }
        ActionResponse actionResponse = new ActionResponse();
        actionResponse.setStatus(sb.toString());
        return actionResponse;
    }

    //    @Override
    @RequestMapping(value = "/fasterxml",
            method = POST,
            consumes = {APPLICATION_XML_VALUE, TEXT_XML_VALUE},
            produces = {APPLICATION_XML_VALUE, TEXT_XML_VALUE})
    @ResponseStatus(OK)
    public ActionResponse postJacksonXMLBody(@Valid @RequestBody XMLJacksonRequest xmlRequest) {
        StringBuilder sb = new StringBuilder();
        if (xmlRequest.getHeader() != null) {
            sb.append("jackson xml header is not null\n");
            if (xmlRequest.getHeader().getId() != null) {
                sb.append("jackson xml header's id is not null\n");
            } else {
                sb.append("jackson xml header's id is null\n");
            }
            if (xmlRequest.getHeader().getName() != null) {
                sb.append("jackson xml header's name is not null\n");
            } else {
                sb.append("jackson xml header's id is null\n");
            }
        } else {
            sb.append("jackson xml header is null");
        }
        ActionResponse actionResponse = new ActionResponse();
        actionResponse.setStatus(sb.toString());
        return actionResponse;
    }
}
