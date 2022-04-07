package com.test.mock.control;

import com.test.mock.model.Person;
import com.test.mock.model.Response;
import com.test.mock.resources.PersonService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin( origins = "*" )
public class PersonController {

    private PersonService service;


    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping( value = "/persons" , produces = MediaType.APPLICATION_JSON_VALUE ) 
    @ResponseBody
    public Page<Person> getPersonsByPage( Pageable pageable ){
    	Pageable page = PageRequest.of( pageable.getPageNumber(), pageable.getPageSize(), Sort.by( Sort.Direction.DESC, "id" ) );
        return service.getPersonByPage( page );
    }

    @GetMapping( value = "/personid" , produces = MediaType.APPLICATION_JSON_VALUE ) 
    @ResponseBody
    public Response getPersonById( @RequestParam(  name="id" ) long id ){
        return service.findPersonById(id);
    }
 
    @PostMapping( value = "/create" , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE ) 
    @ResponseBody
    public Response createPerson( @RequestBody Person person ){
        return service.createPerson( person );
    }

    @PostMapping( value = "/delete" , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE ) 
    @ResponseBody
    public Response deletePerson( @RequestBody Person person ){
        return service.deletePerson( person );
    }
}
