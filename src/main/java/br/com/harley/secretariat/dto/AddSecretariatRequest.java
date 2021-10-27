package br.com.harley.secretariat.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.BeanUtils;

import br.com.harley.secretariat.entity.Secretariat;
import br.com.harley.secretariat.enums.Folder;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddSecretariatRequest {

	@Enumerated(EnumType.STRING)
	@NotBlank
	@NotEmpty
	@ApiModelProperty(value = "Pasta", name = "folder", dataType = "Enum: ex. HEALTH, SPORTS", example = "HEALTH")
	private Folder folder;
	
	@NotBlank
	@NotEmpty
	@ApiModelProperty(value = "Nome do(a) Secretário(a)", name = "secretary", dataType = "String", example = "Harley J. Pezzo")
	private String secretary;

	@NotBlank
	@NotEmpty
	@ApiModelProperty(value = "Nota da População", name = "populationGrade", dataType = "Integer", example = "10")
	private Integer populationGrade;

	@NotBlank
	@NotEmpty
	@ApiModelProperty(value = "Sob Investigação", name = "underInvestigation", dataType = "Boolean", example = "false")
	private boolean underInvestigation;

	public Secretariat toEntity() {
		Secretariat secretariat = new Secretariat();
		BeanUtils.copyProperties(this, secretariat);
		return secretariat;
	}
}
