package br.edu.udesc.WebService;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author paulohenrique
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(br.edu.udesc.WebService.CORSResponseFilter.class);
        resources.add(br.edu.udesc.WebService.CategoriaResource.class);
        resources.add(br.edu.udesc.WebService.EnderecoResource.class);
        resources.add(br.edu.udesc.WebService.GenericResource.class);
        resources.add(br.edu.udesc.WebService.PedidoResource.class);
        resources.add(br.edu.udesc.WebService.ProdutoResource.class);
        resources.add(br.edu.udesc.WebService.UsuarioResource.class);
    }
    
}
