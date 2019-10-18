
package br.edu.udesc.WebService;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Drew
 */
@Provider
public class CORSResponseFilter implements ContainerResponseFilter, ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext crc, ContainerResponseContext responseContext) throws IOException {
        MultivaluedMap<String, Object> headers = responseContext.getHeaders();
        
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        
//        
//        responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
//        responseContext.getHeaders().add("Access-Control-Allow-Credentials", "true");
//        responseContext.getHeaders().add("Access-Control-Allow-Headers","origin, content-type, accept, authorization");
//        responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
    }

    @Override
    public void filter(ContainerRequestContext responseContext) throws IOException {
        
        MultivaluedMap<String, String> headers = responseContext.getHeaders();
        
        
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        
    }
    
}
