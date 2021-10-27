package br.com.harley.secretariat.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.harley.secretariat.dto.AddSecretariatRequest;
import br.com.harley.secretariat.entity.Secretariat;
import br.com.harley.secretariat.repository.SecretariatRepository;

@Service
public class SecretariatService {

	SecretariatRepository secretariatRepository;

	public SecretariatService(SecretariatRepository secretariatRepository) {
		this.secretariatRepository = secretariatRepository;
	}

	public Secretariat addSecretariat(AddSecretariatRequest addSecretariatRequest) {
		return secretariatRepository.save(addSecretariatRequest.toEntity());
	}

	public List<Secretariat> listSecretariats() {
		return secretariatRepository.findAll();
	}
	
	public Optional<Secretariat> getSecretariat(Long secretariatId) {
		return secretariatRepository.findById(secretariatId);
	}

	@Transactional
	public Secretariat changeUnderInvestigation(Long secretariatId, boolean underInvestigation) {

		Secretariat secretariat = secretariatRepository.getById(secretariatId);
		secretariat.setUnderInvestigation(underInvestigation);
		secretariatRepository.save(secretariat);

		return secretariat;
	}

}
