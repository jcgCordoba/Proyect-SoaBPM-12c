package com.test.mock.resources;

import java.util.Optional;

import com.test.mock.model.Person;
import com.test.mock.model.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository repository;
    
    @Autowired
    public PersonService( PersonRepository repository ) {
         this.repository = repository;
    }


    public Page<Person> getPersonByPage( Pageable pageable ){
          return repository.findAll( pageable );
    }

    public Response createPerson( Person person ){
        Response response = null;
         try{
             repository.save( person );
             response = new Response( HttpStatus.OK.value() , "Transaction processed successfully" );
         }
         catch( Exception error ){
            response = new Response( HttpStatus.BAD_REQUEST.value() , "Failed execute createPerson caused by " + error.toString()  );
            System.out.println( " ---> " + HttpStatus.BAD_REQUEST.value() + " Failed execute createPerson caused by " + error.toString() );
         }
        return response;
    }

    public Response findPersonById( long id ){
         Response response = null;
           try{
            System.out.println( "Repository " + repository );
             Optional<Person> option = repository.findById( id );
               if( !option.isEmpty() ){
                   response = new Response( HttpStatus.OK.value() , "Transaction processed successfully" , option.get() );
               }
               else{
                response = new Response( HttpStatus.NOT_FOUND.value() , "No results found for your search"  );
               }
           }
           catch( Exception error ){
              response = new Response( HttpStatus.BAD_REQUEST.value() , "Failed execute findPersonById caused by " + error.toString()  );
              System.out.println( " ---> " + HttpStatus.BAD_REQUEST.value() + " Failed execute findPersonById caused by " + error.toString() );
           }
         return response;
    }
    

    public Response deletePerson( Person person ){
        Response response = null;
         try{
             repository.delete( person );
             response = new Response( HttpStatus.OK.value() , "Transaction processed successfully" );
         }
         catch( Exception error ){
            response = new Response( HttpStatus.BAD_REQUEST.value() , "Failed execute deletePerson caused by " + error.toString()  );
            System.out.println( " ---> " + HttpStatus.BAD_REQUEST.value() + " Failed execute deletePerson caused by " + error.toString() );
         }
        return response;
    }
    
}
