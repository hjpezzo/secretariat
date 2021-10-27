package br.com.harley.secretariat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.harley.secretariat.entity.Secretariat;

@Repository
public interface SecretariatRepository extends JpaRepository<Secretariat, Long> {

}
