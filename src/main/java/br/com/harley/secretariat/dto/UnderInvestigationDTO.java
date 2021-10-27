package br.com.harley.secretariat.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UnderInvestigationDTO {

	@NotBlank
	@NotEmpty
	@ApiModelProperty(value = "Sob Investigação", name = "underInvestigation", dataType = "Boolean", example = "false")
	private boolean underInvestigation;
}
