package br.com.harley.secretariat.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.harley.secretariat.dto.AddSecretariatRequest;
import br.com.harley.secretariat.dto.UnderInvestigationDTO;
import br.com.harley.secretariat.entity.Secretariat;
import br.com.harley.secretariat.service.SecretariatService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/secretariats")
public class SecretariatController {

	SecretariatService secretariatService;

    public SecretariatController(SecretariatService secretariatService) {
        this.secretariatService = secretariatService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value="Adicionar secretaria", notes="Esse método adiciona uma nova secretaria")
    @ApiResponses(value = {
    		@ApiResponse(code = 201, message="Secretaria criada"),
    		@ApiResponse(code = 500, message="Internal error")
    })
    public Secretariat addSecretariat(@RequestBody AddSecretariatRequest secretariat) {
        return secretariatService.addSecretariat(secretariat);
    }

    @GetMapping
    public List<Secretariat> listSecretariats() {
    	return secretariatService.listSecretariats();
    }
    
    @GetMapping(path = "/{id}")
    public Optional<Secretariat> getSecretariat(@PathVariable Long id) {
    	return secretariatService.getSecretariat(id);
    }
   
    @PatchMapping(path = "/{id}/investigation")
	@ApiOperation(value = "Atualiza sob investigação", notes = "Esse método atualiza o status sob investigação da secretaria com o id informado")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Secretaria atualizada"),
			@ApiResponse(code = 400, message = "Erro no valor informado")})
    public Secretariat changeUnderInvestigation(@PathVariable Long id, @RequestBody UnderInvestigationDTO underInvestigationDTO) {
    	return secretariatService.changeUnderInvestigation(id, underInvestigationDTO.isUnderInvestigation());
    }

}
