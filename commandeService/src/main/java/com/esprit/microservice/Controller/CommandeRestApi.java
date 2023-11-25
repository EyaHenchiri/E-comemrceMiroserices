package com.esprit.microservice.Controller;

import java.util.List;
import java.util.Optional;

import javax.xml.ws.Response;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.esprit.microservice.Entity.Commande;
import com.esprit.microservice.Repository.CommandeRepository;
import com.esprit.microservice.Service.CommandeService;

import com.fasterxml.jackson.databind.JsonMappingException;


@RestController
@RequestMapping("/commandes")
@EnableGlobalMethodSecurity(prePostEnabled = true)
@CrossOrigin(origins="*")
public class CommandeRestApi {
	private String title="hello I'm the Utilisateur Microservice";
	

	@Autowired
	CommandeService CommandeService; 
	
	@Autowired
	private CommandeRepository CommandeRepository; 

	
	
	
	@PostMapping("/add")	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Commande> createCommandet(@RequestBody Commande Commande , KeycloakAuthenticationToken auth) {
		KeycloakPrincipal<KeycloakSecurityContext> principal = (KeycloakPrincipal<KeycloakSecurityContext>) auth.getPrincipal();
		KeycloakSecurityContext context = principal.getKeycloakSecurityContext();
		boolean hasUserRole = context.getToken().getRealmAccess().isUserInRole("user");
		if(hasUserRole){
			return new ResponseEntity<>(CommandeService.addCommande(Commande), HttpStatus.OK) ;
		}else{
			return new ResponseEntity<>(HttpStatus.FORBIDDEN) ;
		}


	}
	

	
	@PutMapping("/updateCommande/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Commande> updateCommande(@RequestBody Commande Commande){
	return new ResponseEntity<>(CommandeService.updateCommande(Commande),HttpStatus.OK);
	}
	
	
	
	@RequestMapping("/hello")
	
	public String sayHello(KeycloakAuthenticationToken auth) {
		KeycloakPrincipal<KeycloakSecurityContext> principal = (KeycloakPrincipal<KeycloakSecurityContext>) auth.getPrincipal();
		KeycloakSecurityContext context = principal.getKeycloakSecurityContext();
		boolean hasUserRole = context.getToken().getRealmAccess().isUserInRole("user");
		if(hasUserRole){
			System.out.println(title);
			return "Hello Commande";
		}else{

			return "erreur";
		}



	}
	
	@DeleteMapping(value="/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteCommande(@PathVariable(value="id") int  id){
	return new ResponseEntity<>(CommandeService.deleteCommande(id),HttpStatus.OK);

	}
	
	
	@GetMapping("/all")
	   public List<Commande> getAllCommande( ){
		return CommandeService.retrieveAllCommandes();
	   }
	@GetMapping("/Find/{id}")
	   public Optional<Commande> getCommandeById(@PathVariable(value="id") int  id){
		
		return CommandeRepository.findById(id);
	   }
	
}